package com.management.project_managment.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.management.project_managment.entities.pk.AllocationPK;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "tb_allocation")
public class Allocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AllocationPK id = new AllocationPK();

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant MomentAllocation;

	private Integer workLoad;

	public Allocation() {
	}

	public Allocation(User user, Project project, Instant momentAllocation, Integer workLoad) {
		id.setUser(user);
		id.setProject(project);
		this.MomentAllocation = momentAllocation;
		this.workLoad = workLoad;
	}

}
