package com.cursods.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursods.workshop.entities.Products;
import com.cursods.workshop.services.ProductsService;

@RestController
@RequestMapping(value = "/products")
public class ProductsResource {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping
	public ResponseEntity<List<Products>> findAll() {
		List<Products> products = productsService.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> findOne(@PathVariable Long id) {
		Products product = productsService.findOne(id);
		return ResponseEntity.ok().body(product);
	}
}
