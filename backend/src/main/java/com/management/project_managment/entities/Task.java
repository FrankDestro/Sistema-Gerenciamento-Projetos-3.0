package com.management.project_managment.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.management.project_managment.enums.Priority;
import com.management.project_managment.enums.Status;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "tb_task")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")	
	private Date dataInitial;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")	
	private Date dueData;
	private Status status;
	private Priority priority;
	
	@Formula("(SELECT SUM(EXTRACT(DAY FROM (t.due_data - t.data_initial))) + 1 FROM tb_task t WHERE t.id = id)")
	@Column(name = "total_duration")
	private Integer totalDuration;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_project")
	private Project project;
	
	@OneToMany(mappedBy = "project")
	private Set<Historic> historical = new HashSet<>();

	public Task(long taskNull) {
		this.id = taskNull;
	}

}
