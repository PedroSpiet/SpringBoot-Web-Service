package com.cursods.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursods.workshop.entities.Products;
import com.cursods.workshop.repositories.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Products> findAll() {
		List<Products> products = productsRepository.findAll();
		return products;
	}
	
	public Products findOne(Long id) {
		Optional<Products> products = productsRepository.findById(id);
		return products.get();
	}
}
