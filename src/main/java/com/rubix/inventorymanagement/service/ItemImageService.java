package com.rubix.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.Item;
import com.rubix.inventorymanagement.domain.ItemImages;
import com.rubix.inventorymanagement.exception.IdNotFoundException;
import com.rubix.inventorymanagement.repository.ItemImagesRepository;
import com.rubix.inventorymanagement.repository.ItemRepository;
@Service
public class ItemImageService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemImagesRepository itemImagesRepository;

	public List<ItemImages> getAllItemImages() {
		return itemImagesRepository.findAll();
	}

	public ResponseEntity<Object> addItemImage(ItemImages img, long itemId) throws Exception, IdNotFoundException {
		Item item = itemRepository.findByItemId(itemId);
		if (item == null) {
			throw new IdNotFoundException("Item ID not Found");
		} else {
			ItemImages image = new ItemImages();
			BeanUtils.copyProperties(img, image, "item");
			image.setItem(item);
			ItemImages savedItemImages = itemImagesRepository.save(image);
			if (savedItemImages != null)
				return ResponseEntity.ok("ItemImage Added");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to add itemImage");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateItemImage(ItemImages img, long itemId, long itemImageId)
			throws Exception, IdNotFoundException {
		Item item = itemRepository.findByItemId(itemId);
		ItemImages image = itemImagesRepository.findByItemImageId(itemImageId);
		if (item == null || image == null) {
			throw new IdNotFoundException("Item ID or Item image ID not Found");
		} else {
			BeanUtils.copyProperties(img, image, "item", "imageID");
			image.setItem(item);
			ItemImages savedItemImages = itemImagesRepository.save(image);
			if (savedItemImages != null)
				return ResponseEntity.ok("ItemImage Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update itemImage");
		}
	}

	public ResponseEntity<?> deleteItemImage(long itemId, long itemImageId) throws Exception, IdNotFoundException {

		ItemImages image = itemImagesRepository.findByItemIdAndItemImageId(itemId, itemImageId);
		if (image == null) {
			throw new IdNotFoundException("No Product ID found with Item ID");
		} else {

			itemImagesRepository.delete(image);
			return ResponseEntity.ok("ItemImage  Deleted");
		}
	}

}
