package com.management.project_managment.services;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.project_managment.dto.ProjectDTO;
import com.management.project_managment.dto.TaskDTO;
import com.management.project_managment.entities.Client;
import com.management.project_managment.entities.Project;
import com.management.project_managment.entities.Task;
import com.management.project_managment.repositories.ClientRepository;
import com.management.project_managment.repositories.ProjectRepository;
import com.management.project_managment.repositories.TaskRepository;
import com.management.project_managment.services.exceptions.DatabaseException;
import com.management.project_managment.services.exceptions.ResourceNotFoundException;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired 
	private ClientRepository clientRepository; 
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired 
	private AuthService authService;

	@Transactional
	public ProjectDTO CreateNewProject(ProjectDTO dto) {
		authService.validaIfUserIsAdmin();
		Project entity = new Project();
		copyDtoToEntity(dto, entity);
		entity = projectRepository.save(entity);
		return new ProjectDTO(entity);
	}
	
	@Transactional
	public ProjectDTO UpdateProject(Long id, ProjectDTO dto) {
		authService.validaIfUserIsAdmin();
		try {
		Project entity = projectRepository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity = projectRepository.save(entity);
		return new ProjectDTO(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
	}
	
	public void delete(Long id) {
		authService.validaIfUserIsAdmin();
		try {
			projectRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Project not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}


	@Transactional(readOnly = true)
	public Page<ProjectDTO> findAllProjects(Pageable pageable) {
		Page<Project> projects = projectRepository.findAll(pageable);
		List<ProjectDTO> projectDTOs = new ArrayList<>();

		for (Project project : projects) {
			ProjectDTO projectDTO = new ProjectDTO(project);
			projectDTO.setPercentCompleted(projectRepository.PercentualConcluido(project.getId()));
			List<Object[]> projectTasks = projectRepository.findProjectTasks();
			for (Object[] taskCount : projectTasks) {
				projectDTO.setTotalTasks(((BigInteger) taskCount[0]).intValue());
				projectDTO.setUnfinishedTasks(((BigInteger) taskCount[1]).intValue());
				projectDTO.setCompletedTasks(((BigInteger) taskCount[2]).intValue());
			}
			projectDTOs.add(projectDTO);
		}

		return new PageImpl<>(projectDTOs, pageable, projects.getTotalElements());
	}

	@Transactional(readOnly = true)
	public ProjectDTO findById(Long id) {
		Optional<Project> obj = projectRepository.findById(id);
		Project entity = obj.orElseThrow(() -> new ResourceNotFoundException("Project not found"));
		ProjectDTO dto = new ProjectDTO(entity);

		// First query
		List<Object[]> projectTasks = projectRepository.findProjectTasks();
		for (Object[] taskCount : projectTasks) {
			dto.setTotalTasks(((BigInteger) taskCount[0]).intValue());
			dto.setUnfinishedTasks(((BigInteger) taskCount[1]).intValue());
			dto.setCompletedTasks(((BigInteger) taskCount[2]).intValue());
		}
		// Second query
		Double percentCompleted = projectRepository.PercentualConcluido(id);
		dto.setPercentCompleted(percentCompleted);

		return dto;
	}

	private void copyDtoToEntity(ProjectDTO dto, Project entity) {

		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setInitialDate(dto.getInitialDate());
		entity.setDueData(dto.getDueData());
		entity.setStatus(dto.getStatus());	
		entity.setImgUrl(dto.getImgUrl());
		entity.setBudget(dto.getBudget());
		entity.setExpenses(dto.getExpenses());
		entity.setInvoicing(dto.getInvoicing());
		entity.setOwnerId(dto.getOwner());
		Client client = clientRepository.getOne(dto.getClient());
		entity.setClient(client);
		
		entity.getTasks().clear();
		for (TaskDTO TaksDto : dto.getTasks()) {
			Task tasks = taskRepository.getOne(TaksDto.getId());
			entity.getTasks().add(tasks);				
		}
	}
}
