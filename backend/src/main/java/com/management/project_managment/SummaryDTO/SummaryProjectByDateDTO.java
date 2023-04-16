package com.management.project_managment.SummaryDTO;

import com.management.project_managment.projections.SummaryProjectByDateProjection;

public class SummaryProjectByDateDTO {
	
	private Double invoicing;
	private Double expenses;
	private Double budget;
	private	Integer qtdProject;
	private Integer qtdTask;
	private Integer qtdUsers;
	private Integer completedProjects;
	
	public SummaryProjectByDateDTO() {
	}

	public SummaryProjectByDateDTO(Double invoicing, Double expenses, Double budget, Integer qtdProject,
			Integer qtdTask, Integer qtdUsers, Integer completedProjects) {
		this.invoicing = invoicing;
		this.expenses = expenses;
		this.budget = budget;
		this.qtdProject = qtdProject;
		this.qtdTask = qtdTask;
		this.qtdUsers = qtdUsers;
		this.completedProjects = completedProjects;
	}
	
	public SummaryProjectByDateDTO(SummaryProjectByDateProjection projection) {
		invoicing = projection.getInvoicing();
		expenses = projection.getExpenses();
		budget = projection.getBudget();
		qtdProject = projection.getQtdproject();
		qtdTask = projection.getQtdtask();
		qtdUsers = projection.getQtdusers();
		completedProjects = projection.getQtdusers();
	}

	public Double getInvoicing() {
		return invoicing;
	}

	public void setInvoicing(Double invoicing) {
		this.invoicing = invoicing;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Integer getQtdProject() {
		return qtdProject;
	}

	public void setQtdProject(Integer qtdProject) {
		this.qtdProject = qtdProject;
	}

	public Integer getQtdTask() {
		return qtdTask;
	}

	public void setQtdTask(Integer qtdTask) {
		this.qtdTask = qtdTask;
	}

	public Integer getQtdUsers() {
		return qtdUsers;
	}

	public void setQtdUsers(Integer qtdUsers) {
		this.qtdUsers = qtdUsers;
	}

	public Integer getCompletedProjects() {
		return completedProjects;
	}

	public void setCompletedProjects(Integer completedProjects) {
		this.completedProjects = completedProjects;
	}
}
