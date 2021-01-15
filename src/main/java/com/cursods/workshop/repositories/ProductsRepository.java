package com.cursods.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursods.workshop.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
	
}
