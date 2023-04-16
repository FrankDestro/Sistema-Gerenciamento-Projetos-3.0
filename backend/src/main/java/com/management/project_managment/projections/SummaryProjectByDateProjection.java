package com.management.project_managment.projections;

public interface SummaryProjectByDateProjection {
	
	Double getInvoicing();
	Double getExpenses();
	Double getBudget();
	Integer getQtdproject();
	Integer getQtdtask();
	Integer getQtdusers();
	Integer getProjetosconcluidos();
}
