package com.management.project_managment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
