package com.management.project_managment.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.management.project_managment.entities.Project;
import com.management.project_managment.entities.Task;
import com.management.project_managment.entities.User;
import com.management.project_managment.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TaskDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private Date dataInitial;
	private Date dueData;
	private Status status;
	private Long userId;
	private String userName;
	private Long projectId;
	private String projectName;

	public TaskDTO(Task entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		dataInitial = entity.getDataInitial();
		dueData = entity.getDueData();
		status = entity.getStatus();
		userId = entity.getUser().getId();
		userName = entity.getUser().getFirstName();
		projectId = entity.getProject().getId();
		projectName = entity.getProject().getName();
	}

}
