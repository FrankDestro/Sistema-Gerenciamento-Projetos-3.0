package com.management.project_managment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.project_managment.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	// metodo para buscar email no banco de dados para validação
	User findByEmail(String email);
}
