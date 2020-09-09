package com.rubix.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.ItemImages;

@Repository
public interface ItemImagesRepository extends JpaRepository<ItemImages, Long> {
	@Query(value = "SELECT imageid from Item_images  WHERE  item_id=:id", nativeQuery = true)
	Long findItemImageIdByItemId(@Param("id") Long productId);

}
