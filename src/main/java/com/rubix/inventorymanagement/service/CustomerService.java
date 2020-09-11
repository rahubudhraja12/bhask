package com.rubix.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.*;
import com.rubix.inventorymanagement.repository.*;

@Service
public class CustomerService {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private SsUserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getCustomer() {
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

	public ResponseEntity<Object> addCustomer(Customer customer, long userId, long addressId) throws Exception {

		SsUser users = userRepository.findByUserId(userId);
		Address addresses = addressRepository.findByAddressId(addressId);
		Customer customers = new Customer();
		BeanUtils.copyProperties(customer, customers, "address", "ssUser");
		customers.setAddress(addresses);
		customers.setSsUser(users);
		Customer savedCustomer = customerRepository.save(customers);
		Customer customersExist = customerRepository.findByCustomerId(savedCustomer.getCustomerId());
		if (customersExist != null)
			return ResponseEntity.ok("Customer Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add customer");

	}

	@Transactional
	public ResponseEntity<Object> updateCustomer(Customer customer, long userId, long addressId, long customerId)
			throws Exception {
		SsUser users = userRepository.findByUserId(userId);
		Address addresses = addressRepository.findByAddressId(addressId);
		Customer customers = customerRepository.findByCustomerId(customerId);

		if (users == null || addresses == null || customers == null) {
			return ResponseEntity.unprocessableEntity().body(" User or Address not found with this customer ID");
		} else {
			BeanUtils.copyProperties(customer, customers, "address", "ssUser");
			customers.setAddress(addresses);
			customers.setSsUser(users);
			customers.setCustomerId(customerId);
			Customer savedCustomer = customerRepository.save(customers);
			Customer customersExist = customerRepository.findByCustomerId(savedCustomer.getCustomerId());
			if (customersExist != null)
				return ResponseEntity.ok("Customer Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update customer");
		}

	}

	public ResponseEntity<?> deleteCustomer(long customerId) {

		Customer customers = customerRepository.findByCustomerId(customerId);
		if (customers == null) {
			return ResponseEntity.unprocessableEntity().body("No Customer found with this ID");
		} else {
			customerRepository.delete(customers);
			return ResponseEntity.ok("Customer Deleted");
		}
	}

}
