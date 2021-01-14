package com.cursods.workshop.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursods.workshop.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<User> FindUsers() {
		User users = new User(1L, "Pedro", "99999", "Pedro@gmail.com", "12345");
		return ResponseEntity.ok().body(users);
	}
}
