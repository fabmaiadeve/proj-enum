package com.dev.fab.projenum.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fab.projenum.entities.Order;
import com.dev.fab.projenum.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	final OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.listAllOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOrderById(@PathVariable(value = "id") Long id){
		Optional<Order> orderOptional = orderService.findOrderById(id);
		
		if(orderOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found!");		
		}		
		return ResponseEntity.status(HttpStatus.OK).body(orderOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOrder(@PathVariable(value = "id") Long id) {
		Optional<Order> orderOptional = orderService.findOrderById(id);
		
		if(orderOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found!");
		}
		orderService.deleteOrder(orderOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Order record deleted successfully!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateOrder(@PathVariable(value = "id") Long id, @RequestBody Order order) {
		Optional<Order> orderOptional = orderService.findOrderById(id);
		
		if(orderOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found!");
		}
		Order orderUpdate = new Order();
		orderUpdate.setId(orderOptional.get().getId());
		orderUpdate.setMoment(order.getMoment());
		orderUpdate.setOrderStatus(order.getOrderStatus());
		
		return ResponseEntity.status(HttpStatus.OK).body(orderService.save(orderUpdate));
	}
}
