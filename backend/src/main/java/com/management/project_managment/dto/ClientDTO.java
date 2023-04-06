package com.management.project_managment.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.management.project_managment.entities.Client;
import com.management.project_managment.entities.Project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String city;
	private String country;
	private String address;
	private Long zip;
	private String marketSegment;

	private List<ProjectDTO> projects = new ArrayList<>();

	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		city = entity.getCity();
		country = entity.getCountry();
		address = entity.getAddress();
		zip = entity.getZip();
		marketSegment = entity.getMarketSegment();
		entity.getProjects().forEach(projects -> this.projects.add(new ProjectDTO(projects)));
	}
}
