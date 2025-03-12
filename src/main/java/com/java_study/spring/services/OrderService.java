package com.java_study.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_study.spring.entities.Order;
import com.java_study.spring.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		return optionalOrder.orElseThrow();
	}
	
	public Order insert(Order order) {
		return orderRepository.save(order);
	}
	
	public Order update(Long id, Order order) {
		Order entityOrder = orderRepository.getReferenceById(id);
		entityOrder.setMoment(order.getMoment());
		return orderRepository.save(entityOrder);
	}
	
	public void delete(Long id) {
		orderRepository.deleteById(id);
	}
}
