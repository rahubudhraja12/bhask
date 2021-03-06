package com.ecom.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.inventorymanagement.domain.*;
import com.ecom.inventorymanagement.exception.IdNotFoundException;
import com.ecom.inventorymanagement.repository.*;

@Service
public class CustomerService {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getCustomer() {
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

	public ResponseEntity<Object> addCustomer(Customer customer,long addressId)  throws Exception, IdNotFoundException {

		Address addresses = addressRepository.findByAddressId(addressId);
		Customer customers = new Customer();
		if ( addresses == null ) {
			throw new IdNotFoundException("  Address ID doesn't Exit");
		} else {
		BeanUtils.copyProperties(customer, customers, "address");
		customers.setAddress(addresses);
		Customer savedCustomer = customerRepository.save(customers);
		Customer customersExist = customerRepository.findByCustomerId(savedCustomer.getCustomerId());
		if (customersExist != null)
			return ResponseEntity.ok("Customer Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add customer");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateCustomer(Customer customer,long addressId, long customerId)
			 throws Exception, IdNotFoundException {

		Address addresses = addressRepository.findByAddressId(addressId);
		Customer customers = customerRepository.findByCustomerId(customerId);

		if (addresses == null || customers == null) {
			throw new IdNotFoundException("  Address ID or customer ID doesnt exist");
		} else {
			BeanUtils.copyProperties(customer, customers, "address");
			customers.setAddress(addresses);
			customers.setCustomerId(customerId);
			Customer savedCustomer = customerRepository.save(customers);
			Customer customersExist = customerRepository.findByCustomerId(savedCustomer.getCustomerId());
			if (customersExist != null)
				return ResponseEntity.ok("Customer Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update customer");
		}

	}

	public ResponseEntity<?> deleteCustomer(long addressId,long customerId) throws Exception,IdNotFoundException {

		Customer customers = customerRepository.findByCustomerIdAndAddressId(customerId,addressId);
		if (customers == null) {
			throw new IdNotFoundException("No Customer found with this ID");
		} else {
			customerRepository.delete(customers);
			return ResponseEntity.ok("Customer Deleted");
		}
	}

}
