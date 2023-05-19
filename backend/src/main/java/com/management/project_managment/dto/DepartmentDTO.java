package com.management.project_managment.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.management.project_managment.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	private Set<UserDTO> employees = new HashSet<>();

	public DepartmentDTO(Department entity) {
		id = entity.getId();
		name = entity.getName();
		entity.getEmployees().forEach(emp -> this.employees.add(new UserDTO(emp)));
	}

}
