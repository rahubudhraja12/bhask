package com.rubix.inventorymanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.OrderAddressDetail;
import com.rubix.inventorymanagement.domain.OrderDetail;
import com.rubix.inventorymanagement.repository.OrderAddressDetailRepository;
import com.rubix.inventorymanagement.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository orderRepository;
	@Autowired
	private OrderAddressDetailRepository orderAddressRepository;

	public ResponseEntity<Object> placeOrder(OrderDetail order) throws Exception {
		OrderDetail orders = new OrderDetail();
		BeanUtils.copyProperties(order, orders, "orderAddressDetail");
		OrderDetail savedOrder = orderRepository.save(orders);
		OrderAddressDetail address = new OrderAddressDetail();
		address = order.getOrderAddressDetail();
		address.setOrder(savedOrder);
		orderAddressRepository.save(address);
		if (savedOrder != null)
			return ResponseEntity.ok("Order Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add order");
	}
	@Transactional
	public ResponseEntity<Object> updateOrder(OrderDetail order, Long orderId) throws Exception {
		OrderDetail orders = orderRepository.findByOrderId(orderId);
		BeanUtils.copyProperties(order, orders, "orderAddressDetail", "orderId");
		orders.setOrderId(orderId);
		OrderDetail savedOrder = orderRepository.save(orders);
		long orderAddressId = orderAddressRepository.findAddressIdByOrderId(orderId);
		OrderAddressDetail address = new OrderAddressDetail();
		address = order.getOrderAddressDetail();
		address.setOrderAddressDetailId(orderAddressId);
		address.setOrder(savedOrder);
		orderAddressRepository.save(address);
		if (savedOrder != null)
			return ResponseEntity.ok("Order Updated");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to update order");
	}

	public ResponseEntity<?> deleteOrder(long orderId) {

		OrderDetail order = orderRepository.findByOrderId(orderId);
		if (order == null) {
			return ResponseEntity.unprocessableEntity().body("No order found with this ID");
		} else {
			orderRepository.delete(order);
			return ResponseEntity.ok("Order Deleted");
		}
	}
}
