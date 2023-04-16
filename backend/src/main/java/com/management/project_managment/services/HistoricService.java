package com.management.project_managment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.project_managment.dto.HistoricDTO;
import com.management.project_managment.entities.Historic;
import com.management.project_managment.entities.Project;
import com.management.project_managment.entities.Task;
import com.management.project_managment.repositories.HistoricRepository;
import com.management.project_managment.repositories.ProjectRepository;
import com.management.project_managment.repositories.TaskRepository;
import com.management.project_managment.services.exceptions.ResourceNotFoundException;

@Service
public class HistoricService {
	
	@Autowired
	private AuthService authService;

	@Autowired
	private HistoricRepository historicRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Transactional
	public HistoricDTO InsertHistorical(HistoricDTO dto) {
		authService.authenticated();
		Historic entity = new Historic();
		copyDtoToEntity(dto, entity);
		entity = historicRepository.save(entity);
		return new HistoricDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public HistoricDTO findById(Long id) {
	    Optional<Historic> obj = historicRepository.findById(id);
	    Historic entity = obj.orElseThrow(() -> new ResourceNotFoundException("Historic not found"));
	    HistoricDTO dto = new HistoricDTO(entity);
	    return new HistoricDTO(entity);
	}

	private void copyDtoToEntity(HistoricDTO dto, Historic entity) {
		entity.setDescription(dto.getDescription());
			
		if (dto.getProjectId() != 0) {
			Project project = projectRepository.getOne(dto.getProjectId());
			entity.setProject(project);
		}
		
		if (dto.getTaskId()!= 0) {
			Task task = taskRepository.getOne(dto.getTaskId());
			entity.setTask(task);
		}
	}

}
