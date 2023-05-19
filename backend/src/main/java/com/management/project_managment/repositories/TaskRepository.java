package com.management.project_managment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{


	@Query(nativeQuery = true, value = "SELECT "
			+ "	SUM(EXTRACT(DAY FROM (t.due_data - t.data_initial))) + 1 AS duration "
			+ " FROM tb_task t "
			+ " WHERE t.id = :id"
			)
    Long duration(Long id);

}
