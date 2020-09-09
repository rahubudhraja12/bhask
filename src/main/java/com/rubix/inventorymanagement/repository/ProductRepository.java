package com.rubix.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductId(Long productId);

	@Query(value = "SELECT * from Product  WHERE  Product_id=:id", nativeQuery = true)
	Product getAll(@Param("id") Long productId);

	@Query(value = "SELECT * from  Product  WHERE  Product_id=:id and category_id=:categoryId", nativeQuery = true)
	Product findByProductIdAndCategoryId(@Param("id") Long productId, @Param("categoryId") Long categoryId);
}
