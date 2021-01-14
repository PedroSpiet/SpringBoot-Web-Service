package com.cursods.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursods.workshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
