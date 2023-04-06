package com.management.project_managment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
