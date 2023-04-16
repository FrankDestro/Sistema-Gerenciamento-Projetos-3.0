package com.management.project_managment.dto;

import java.io.Serializable;
import java.time.Instant;

import com.management.project_managment.entities.Historic;

public class HistoricDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private Instant date;
	private Long projectId;
	private Long taskId;

	public HistoricDTO() {
	}

	public HistoricDTO(Long id, String description, Instant date, Long projectId, Long taskId) {
		this.id = id;
		this.description = description;
		this.date = date;
		this.projectId = projectId;
		this.taskId = taskId;
	}

	public HistoricDTO(Historic entity) {
		id = entity.getId();
		description = entity.getDescription();
		date = entity.getDate();
		projectId = entity.getProject().getId();
		taskId = entity.getTask().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Long getProjectId() {
		return this.projectId == null ? 0 : this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getTaskId() {
		return this.taskId == null ? 0 : this.taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

}
