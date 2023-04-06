package com.management.project_managment.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.management.project_managment.entities.Client;
import com.management.project_managment.entities.Project;
import com.management.project_managment.entities.Task;
import com.management.project_managment.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private Date initialDate;
	private Date dueData;
	private Status status;
	private String imgUrl;
	private Double budget;
	private Double expenses;
	private Double invoicing;
	private String owner;
	private Long client;
	private String clientName;
	private Long categoryId;
	private String categoryDescription;

	Set<TaskDTO> tasks = new HashSet<>();

	public ProjectDTO(Project entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		initialDate = entity.getInitialDate();
		dueData = entity.getDueData();
		status = entity.getStatus();
		imgUrl = entity.getImgUrl();
		budget = entity.getBudget();
		expenses = entity.getExpenses();
		invoicing = entity.getInvoicing();
		owner = entity.getOwner();
		client = entity.getClient().getId();
		clientName = entity.getClient().getName();
		categoryId = entity.getCategory().getId();
		categoryDescription = entity.getCategory().getDescription();
		entity.getTasks().forEach(tk -> this.tasks.add(new TaskDTO(tk)));

	}

}
