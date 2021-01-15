package com.cursods.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursods.workshop.entities.Category;
import com.cursods.workshop.entities.Order;
import com.cursods.workshop.entities.Products;
import com.cursods.workshop.entities.User;
import com.cursods.workshop.entities.enums.OrderStatus;
import com.cursods.workshop.repositories.CategoryRepository;
import com.cursods.workshop.repositories.OrderRepository;
import com.cursods.workshop.repositories.ProductsRepository;
import com.cursods.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Pedro", "99999", "Pedro@email.com", "12345");
		User user2 = new User(null, "Maria", "88888", "Maria@gmail.com", "12345");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user1);

		Category c1 = new Category(null, "moda");
		Category c2 = new Category(null, "Higiene");
		Category c3 = new Category(null, "Comida");
		
		Products p1 = new Products(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Products p2 = new Products(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Products p3 = new Products(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
	
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		productsRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategory().add(c2);
		p2.getCategory().add(c1);
		p2.getCategory().add(c3);
		p3.getCategory().add(c3);
		
		productsRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
	
	
}
