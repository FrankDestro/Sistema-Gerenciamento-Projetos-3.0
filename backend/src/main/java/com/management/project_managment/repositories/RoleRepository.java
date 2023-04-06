package com.management.project_managment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
