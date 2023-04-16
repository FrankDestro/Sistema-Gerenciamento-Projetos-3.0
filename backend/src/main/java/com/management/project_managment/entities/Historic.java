package com.management.project_managment.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "tb_historic")
public class Historic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String description;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;

	@ManyToOne(optional = true)
	@JoinColumn(name = "project_id", nullable = true)
	private Project project;

	@ManyToOne(optional = true)
	@JoinColumn(name = "task_id", nullable = true)
	private Task task;

	public Historic() {
	}

	public Historic(Long id, String description, Instant date, Project project, Task task) {
		this.id = id;
		this.description = description;
		this.date = date;
		this.project = project;
		this.task = task;
	}

	// Construtor sem o projectid e taskid
	public Historic(Long id, String description, Instant date) {
		this.id = id;
		this.description = description;
		this.date = date;
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

	@PrePersist
	public void prePersist() {
		date = Instant.now();
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Project getProject() {
		return project == null ? new Project((long) 0) : this.project;
	}

	public Task getTask() {
		return task == null ? new Task((long) 0) : this.task;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historic other = (Historic) obj;
		return Objects.equals(date, other.date);
	}
}
