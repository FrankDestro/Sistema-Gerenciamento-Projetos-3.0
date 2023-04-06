package com.management.project_managment.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.project_managment.dto.TaskDTO;
import com.management.project_managment.entities.Project;
import com.management.project_managment.entities.Task;
import com.management.project_managment.entities.User;
import com.management.project_managment.repositories.ProjectRepository;
import com.management.project_managment.repositories.TaskRepository;
import com.management.project_managment.repositories.UserRepository;
import com.management.project_managment.services.exceptions.ResourceNotFoundException;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private AuthService authService;

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllTask(Pageable pageable) {
		Page<Task> list = taskRepository.findAll(pageable);
		return list.map(x -> new TaskDTO(x));
	}

	@Transactional
	public TaskDTO CreateTask(TaskDTO dto) {
		authService.authenticated();
		Task entity = new Task();
		copyDtoToEntity(dto, entity);
		entity = taskRepository.save(entity);
		return new TaskDTO(entity);
	}

	@Transactional
	public TaskDTO UpdateTask(Long id, TaskDTO dto) {
		authService.authenticated();
		try {
			Task entity = taskRepository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = taskRepository.save(entity);
			return new TaskDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
	}

	private void copyDtoToEntity(TaskDTO dto, Task entity) {

		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDataInitial(dto.getDataInitial());
		entity.setDueData(dto.getDueData());
		entity.setStatus(dto.getStatus());
		entity.setStatus(dto.getStatus());
		User user = userRepository.getOne(dto.getUserId());
		entity.setUser(user);
		Project project = projectRepository.getOne(dto.getProjectId());
		entity.setProject(project);
	}

}
