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

import com.management.project_managment.enums.Status;

@Entity
@Table(name = "tb_project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private Date initialDate;
	private Date dueData;
	private Status status;
	private String imgUrl;
	private Double budget;
	private Double expenses;
	private Double invoicing;
	private Long ownerId;
	private Double percentCompleted;

	@OneToMany(mappedBy = "project")
	private Set<Task> tasks = new HashSet<>();

	@OneToMany(mappedBy = "project")
	private Set<Historic> historical = new HashSet<>();

	@OneToMany(mappedBy = "project")
	private Set<Attachment> attachments = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Project() {
	}

	public Project(Long id, String name, String description, Date initialDate, Date dueData, Status status, String imgUrl, Double budget,
				   Double expenses, Double invoicing, Long ownerId, Double percentCompleted, Client client, Category category, int totalTasks, int unfinishedTasks, int completedTasks) {
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
		this.ownerId = ownerId;
		this.percentCompleted = percentCompleted;
		this.client = client;
		this.category = category;
	}
	
	public Project(long projectNull) {
		this.id = projectNull;
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

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPercentCompleted() {
		return percentCompleted;
	}

	public void setPercentCompleted(Double percentCompleted) {
		this.percentCompleted = percentCompleted;
	}

	public Set<Historic> getHistorical() {
		return historical;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Project project = (Project) o;

		return id.equals(project.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
