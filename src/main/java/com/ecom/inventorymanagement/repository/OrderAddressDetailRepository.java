package com.ecom.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecom.inventorymanagement.domain.OrderAddressDetail;
@Repository
public interface OrderAddressDetailRepository  extends JpaRepository<OrderAddressDetail, Long> {
	@Query(value = "SELECT order_address_detail_id from Order_address_detail  WHERE  order_id=:id", nativeQuery = true)
	Long findAddressIdByOrderId(@Param("id") Long orderId);
}