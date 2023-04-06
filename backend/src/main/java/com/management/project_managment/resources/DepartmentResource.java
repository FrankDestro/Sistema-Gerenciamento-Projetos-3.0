package com.management.project_managment.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.project_managment.dto.DepartmentDTO;
import com.management.project_managment.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentResource {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> findAll() {
		List<DepartmentDTO> list = departmentService.findAllDepartments();		
		return ResponseEntity.ok().body(list);
	}
}
