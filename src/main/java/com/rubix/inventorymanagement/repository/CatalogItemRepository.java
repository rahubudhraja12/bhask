package com.rubix.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.CatalogItem;

@Repository
public interface CatalogItemRepository extends JpaRepository<CatalogItem, Long> {

	CatalogItem findByCatalogId(long catalogId);

	@Query(value = "SELECT * from CatalogItem  WHERE  Product_id=:id, Item_id=:itemId and Catalog_id=:catalogId", nativeQuery = true)
	CatalogItem findByCatalogIdProductIdAndItemId(@Param("catalogId") Long catalogId, @Param("id") Long productId,
			@Param("itemId") Long itemId);
}