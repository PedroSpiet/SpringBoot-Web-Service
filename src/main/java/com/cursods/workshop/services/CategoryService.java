package com.cursods.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursods.workshop.entities.Category;
import com.cursods.workshop.repositories.CategoryRepository;

@Service
public class CategoryService  {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}
	
	public Category findOne(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
}
