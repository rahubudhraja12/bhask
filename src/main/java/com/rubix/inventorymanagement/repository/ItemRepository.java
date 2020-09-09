package com.rubix.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findByItemId(Long itemId);

	@Query(value = "SELECT * from Item  WHERE  Product_id=:id and item_id=:itemId", nativeQuery = true)
	Item findByProductIdAndItemId(@Param("id") Long productId, @Param("itemId") Long itemId);
	
	@Query(value = "SELECT * from Item  WHERE  Product_id=:id", nativeQuery = true)
	List<Item> findByProductId(@Param("id") Long productId);

}
