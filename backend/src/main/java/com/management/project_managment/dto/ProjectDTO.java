package com.management.project_managment.dto;

import java.io.Serializable;
import java.util.*;

import com.management.project_managment.entities.Project;
import com.management.project_managment.entities.Task;
import com.management.project_managment.enums.Status;

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
	private Long owner;
	private Long client;
	private String clientName;
	private Long categoryId;
	private String categoryDescription;
	private Double percentCompleted;

	private int totalTasks;
	private int unfinishedTasks;
	private int completedTasks;
	private int canceledTasks;


	Set<TaskDTO> tasks = new HashSet<>();

	Set<HistoricDTO> historical = new HashSet<>();

	Set<AttachmentDTO> attachments = new HashSet<>();

	public ProjectDTO() {
	}

	public ProjectDTO(Long id, String name, String description, Date initialDate, Date dueData, Status status, String imgUrl, Double budget, Double expenses,
					  Double invoicing, Long owner, Long client, String clientName, Long categoryId,
					  String categoryDescription, Double percentCompleted,  int totalTasks, int unfinishedTasks, int completedTasks, int canceledTasks) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.initialDate = initialDate;
		this.dueData = dueData;
		this.status = status;
		this.imgUrl = imgUrl;
		this.budget = budget;
		this.expenses = expenses;
		this.invoicing = invoicing;
		this.owner = owner;
		this.client = client;
		this.clientName = clientName;
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
		this.percentCompleted = percentCompleted;
		this.totalTasks = totalTasks;
		this.unfinishedTasks = unfinishedTasks;
		this.completedTasks = completedTasks;
		this.canceledTasks = canceledTasks;
	}

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
		owner = entity.getOwnerId();
		client = entity.getClient().getId();
		clientName = entity.getClient().getName();
		categoryId = entity.getCategory().getId();
		categoryDescription = entity.getCategory().getDescription();
		percentCompleted = entity.getPercentCompleted();
		entity.getTasks().forEach(tk -> this.tasks.add(new TaskDTO(tk)));
		entity.getHistorical().forEach(ht -> this.historical.add(new HistoricDTO(ht)));
		entity.getAttachments().forEach(at -> this.attachments.add(new AttachmentDTO(at)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getDueData() {
		return dueData;
	}

	public void setDueData(Date dueData) {
		this.dueData = dueData;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public Double getInvoicing() {
		return invoicing;
	}

	public void setInvoicing(Double invoicing) {
		this.invoicing = invoicing;
	}

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Double getPercentCompleted() {
		return percentCompleted;
	}

	public void setPercentCompleted(Double percentCompleted) {
		this.percentCompleted = percentCompleted;
	}

	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public int getUnfinishedTasks() {
		return unfinishedTasks;
	}

	public void setUnfinishedTasks(int unfinishedTasks) {
		this.unfinishedTasks = unfinishedTasks;
	}

	public int getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}
	
	public int getCanceledTasks() {
		return canceledTasks;
	}

	public void setCanceledTasks(int canceledTasks) {
		this.canceledTasks = canceledTasks;
	}

	public Set<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(Set<TaskDTO> tasks) {
		this.tasks = tasks;
	}

	public Set<HistoricDTO> getHistorical() {
		return historical;
	}

	public void setHistorical(Set<HistoricDTO> historical) {
		this.historical = historical;
	}

	public Set<AttachmentDTO> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<AttachmentDTO> attachments) {
		this.attachments = attachments;
	}
}