package com.cursods.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursods.workshop.entities.Order;
import com.cursods.workshop.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderResources {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = orderService.findAll();
		return ResponseEntity.ok().body(orders);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findOne(@PathVariable Long id) {
		Order order = orderService.findOne(id);
		return ResponseEntity.ok().body(order);
	}
}
