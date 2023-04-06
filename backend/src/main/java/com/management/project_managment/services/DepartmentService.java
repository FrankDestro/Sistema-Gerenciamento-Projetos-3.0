package com.management.project_managment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.project_managment.dto.DepartmentDTO;
import com.management.project_managment.entities.Department;
import com.management.project_managment.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional(readOnly=true)
	public List<DepartmentDTO> findAllDepartments(){
		List<Department> list = departmentRepository.findAll();
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}

}
