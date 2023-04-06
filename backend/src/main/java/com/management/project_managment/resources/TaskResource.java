package com.management.project_managment.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.management.project_managment.dto.ProjectDTO;
import com.management.project_managment.dto.TaskDTO;
import com.management.project_managment.dto.UserDTO;
import com.management.project_managment.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<Page<TaskDTO>> findAllTask(Pageable pageable) {
		Page<TaskDTO> list = taskService.findAllTask(pageable);		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<TaskDTO> CreateTask(@RequestBody TaskDTO dto) {
		dto = taskService.CreateTask(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> UpdateTask(@PathVariable Long id, @RequestBody TaskDTO dto) {
		dto = taskService.UpdateTask(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
}
