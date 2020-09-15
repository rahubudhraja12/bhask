package com.rubix.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomerId(long customerId);
	@Query(value = "SELECT * from Customer  WHERE  customer_id=:id and address_id=:addressId", nativeQuery = true)
	Customer findByCustomerIdAndAddressId(@Param("id")long customerId, @Param("addressId")long addressId);
	
	

}
