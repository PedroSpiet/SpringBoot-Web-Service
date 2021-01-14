package com.cursods.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursods.workshop.entities.User;
import com.cursods.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Pedro", "99999", "Pedro@email.com", "12345");
		User user2 = new User(null, "Maria", "88888", "Maria@gmail.com", "12345");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
	
	
}
