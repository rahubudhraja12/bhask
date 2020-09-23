package com.ecom.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecom.inventorymanagement.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findByAddressId(long addressId);

	@Query(value = "SELECT * from Address  WHERE  user_id=:id and address_id=:addressId", nativeQuery = true)
	Address findByUserIdAndAddressId(@Param("id") long userId, @Param("addressId") long addressId);

}
