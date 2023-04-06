package com.management.project_managment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.Allocation;
import com.management.project_managment.entities.pk.AllocationPK;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, AllocationPK>{

}
