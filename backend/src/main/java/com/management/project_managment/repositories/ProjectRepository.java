package com.management.project_managment.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.Project;
import com.management.project_managment.projections.SummaryProjectByDateProjection;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query(nativeQuery = true, value = "SELECT "
            + " CAST(COUNT(*) FILTER (WHERE t.status = 3) * 100.0 / COUNT(*) AS DECIMAL(10,1)) AS percentual "
            + "FROM tb_task t "
            + "JOIN tb_project p ON t.id_project = p.id "
            + "WHERE p.id = :id")
    Double PercentualConcluido(Long id);
	
	@Query(nativeQuery = true, value = "SELECT "
            + " COUNT(*) AS total_tasks, "
            + " COUNT(*) FILTER (WHERE t.status = 0 OR t.status= 1 OR t.status=2) AS unfinished_tasks, "
            + " COUNT(*) FILTER (WHERE t.status = 3) AS completed_tasks, "
            + " COUNT(*) FILTER (WHERE t.status = 4) AS canceled_task "
            + " FROM tb_task t "
            + " JOIN tb_project p ON t.id_project = p.id "
            + " WHERE t.id_project = :id"
            + " GROUP BY p.name")
    List<Object[]> findProjectTasks(Long id);
    
    
    @Query(nativeQuery = true, value = "SELECT "
            + " COUNT(*) AS total_tasks, "
            + " COUNT(*) FILTER (WHERE t.status = 0) AS unfinished_tasks, "
            + " COUNT(*) FILTER (WHERE t.status = 3) AS completed_tasks "
            + " FROM tb_task t "
            + " JOIN tb_project p ON t.id_project = p.id "
            + " WHERE t.id_project = :id"
            + " GROUP BY p.name")
    List<Object[]> SummaryProjectsByDate(Long id);
   	
    
    @Query(nativeQuery = true, value = "SELECT "
    		+ " sum(tp.invoicing) Invoicing, "
    		+ "	sum(tp.expenses) Expenses, "
    		+ "	sum(tp.budget) Budget, "
    		+ "	count( distinct tp.id) QtdProject, "
    		+ "	count( distinct tt.id) QtdTask, "
    		+ "	count( distinct tu.id) QtdUsers, "
    		+ "	count(distinct case when tp.status = 3 then tp.id end) ProjetosConcluidos "
    		+ "	FROM tb_project tp "
    		+ "	FULL OUTER JOIN tb_task tt ON ( tp.id = tt.id_project  ) "
    		+ "	FULL OUTER JOIN tb_user tu ON ( tt.id_user = tu.id  )  "
    		+ "	WHERE tp.initial_date between to_timestamp(:initialDate1,'yyyy-mm-dd hh24:mi:ss') and to_timestamp(:initialDate2,'yyyy-mm-dd hh24:mi:ss') "
	)
	List<SummaryProjectByDateProjection> SummaryProjectByDate(Timestamp initialDate1, Timestamp initialDate2);

}
