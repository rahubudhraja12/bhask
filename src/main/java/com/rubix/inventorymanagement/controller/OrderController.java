package com.rubix.inventorymanagement.controller;

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

import com.rubix.inventorymanagement.domain.OrderDetail;
import com.rubix.inventorymanagement.repository.OrderDetailRepository;
import com.rubix.inventorymanagement.service.OrderDetailService;

@RestController
@RequestMapping("inventory")
public class OrderController {
	@Autowired
	private OrderDetailService orderService;
	@Autowired
	private OrderDetailRepository orderRepository;

	@GetMapping("/getOrders")
	public List<OrderDetail> getAllOrder() {
		return orderRepository.findAll();

	}

	@PostMapping("/order")
	public ResponseEntity<Object> placeOrder(@RequestBody OrderDetail order) throws Exception {
		return orderService.placeOrder(order);
	}

	@PutMapping("/order/{orderId}")
	public ResponseEntity<Object> updateOrder(@RequestBody OrderDetail order,
			@PathVariable(value = "orderId") Long orderId) throws Exception {
		return orderService.updateOrder(order, orderId);
	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
		return orderService.deleteOrder(orderId);

	}
}
