package com.management.project_managment.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.management.project_managment.dto.ProjectDTO;
import com.management.project_managment.projections.SummaryProjectByDateProjection;
import com.management.project_managment.services.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {
	
	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping(value = "/summaryProjectsByDate")
	public ResponseEntity<List<SummaryProjectByDateProjection>> getSummaryProjectByDate(
	    @RequestParam(name = "initialDate1", required = false) String initialDate1,
	    @RequestParam(name = "initialDate2", required = false) String initialDate2) throws ParseException {
	    List<SummaryProjectByDateProjection> summary = projectService.getSummaryProjectByDate(initialDate1, initialDate2);
	    return ResponseEntity.ok(summary);
	}

			
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProjectDTO> findById(@PathVariable Long id) {
		ProjectDTO dto = projectService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
		
	@PostMapping
	public ResponseEntity<ProjectDTO> CreateNewProject(@RequestBody ProjectDTO dto) {
		dto = projectService.CreateNewProject(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProjectDTO> UpdateProject(@PathVariable Long id, @RequestBody ProjectDTO dto) {
		dto = projectService.UpdateProject(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		projectService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
