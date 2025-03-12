package com.java_study.spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java_study.spring.entities.Order;
import com.java_study.spring.services.OrderService;

@RestController
@RequestMapping(path = "/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;
	private Order order;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = orderService.findAll();
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		order = orderService.findById(id);
		return ResponseEntity.ok(order);
	}
	
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody Order orderToInsert) {
		order = orderService.insert(orderToInsert);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order orderToUpdate) {
		order = orderService.update(id, orderToUpdate);
		return ResponseEntity.ok(order);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		orderService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
