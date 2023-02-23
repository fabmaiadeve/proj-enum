package com.dev.fab.projenum.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dev.fab.projenum.entities.Order;
import com.dev.fab.projenum.repositories.OrderRepository;

@Service
public class OrderService {
	
	final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Transactional
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> listAllOrders() {
		return orderRepository.findAll();
	}
	
	public Optional<Order> findOrderById(Long id) {
		return orderRepository.findById(id);
	}
	
	@Transactional
	public void deleteOrder(Order order) {
		orderRepository.delete(order);
	}
}
