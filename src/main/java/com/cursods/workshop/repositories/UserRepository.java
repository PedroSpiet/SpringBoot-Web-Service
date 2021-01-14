package com.cursods.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursods.workshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
