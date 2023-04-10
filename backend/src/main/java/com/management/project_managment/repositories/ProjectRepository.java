package com.management.project_managment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

    @Query(nativeQuery = true, value = "SELECT "
            + " CAST(COUNT(*) FILTER (WHERE t.status = 0) * 100.0 / COUNT(*) AS DECIMAL(10,1)) AS percentual "
            + "FROM tb_task t "
            + "JOIN tb_project p ON t.id_project = p.id "
            + "GROUP BY p.name;"
    )
    Double PercentualConcluido(Long id);

    @Query(nativeQuery = true, value = "SELECT "
            + " COUNT(*) AS total_tasks, "
            + " COUNT(*) FILTER (WHERE t.status = 0) AS unfinished_tasks, "
            + " COUNT(*) FILTER (WHERE t.status = 3) AS completed_tasks "
            + " FROM tb_task t "
            + " JOIN tb_project p ON t.id_project = p.id "
            + " GROUP BY p.name"
    )
    List<Object[]> findProjectTasks();


}
