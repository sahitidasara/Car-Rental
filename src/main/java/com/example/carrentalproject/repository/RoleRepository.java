package com.example.carrentalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrentalproject.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	
	Role findByName(String roleName);

}
