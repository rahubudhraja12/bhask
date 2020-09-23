package com.ecom.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecom.inventorymanagement.domain.ItemImages;

@Repository
public interface ItemImagesRepository extends JpaRepository<ItemImages, Long> {
	@Query(value = "SELECT imageid from Item_images  WHERE  item_id=:id", nativeQuery = true)
	Long findItemImageIdByItemId(@Param("id") Long itemId);

	@Query(value = "SELECT * from Item_images WHERE  imageid=:id", nativeQuery = true)
	ItemImages findByItemImageId(@Param("id") long itemImageId);

	@Query(value = "SELECT * from Item_images  WHERE   item_id=:id and imageid=:imageId", nativeQuery = true)
	ItemImages findByItemIdAndItemImageId(@Param("id") long itemId, @Param("imageId") long itemImageId);
}
