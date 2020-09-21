package com.rubix.inventorymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.Item;
import com.rubix.inventorymanagement.domain.ItemImages;
import com.rubix.inventorymanagement.domain.Product;
import com.rubix.inventorymanagement.exception.IdNotFoundException;
import com.rubix.inventorymanagement.repository.ItemImagesRepository;
import com.rubix.inventorymanagement.repository.ItemRepository;
import com.rubix.inventorymanagement.repository.ProductRepository;

@Service
public class ItemService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemImagesRepository itemImagesRepository;

	public List<Item> findAllItem() {
		return itemRepository.findAll();
	}

	public List<Item> findItemByProductId(Long productId) {
		List<Item> item = new ArrayList<>();
		item = itemRepository.findByProductId(productId);
		return item;
	}

	public ResponseEntity<Object> addItem(Item items, long productId) throws Exception, IdNotFoundException {
		Product product = productRepository.findByProductId(productId);
		if (product == null) {
			throw new IdNotFoundException("Product ID not Found");
		} else {
			Item item = new Item();
			BeanUtils.copyProperties(items, item, "itemImages", "product");
			item.setProduct(product);
			Item savedItems = itemRepository.save(item);
			List<ItemImages> images = items.getItemImages();
			for (ItemImages img : images) {
				BeanUtils.copyProperties(images, img, "item");
				img.setItem(savedItems);
				itemImagesRepository.save(img);
			}

			if (savedItems != null)
				return ResponseEntity.ok("Item Added");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to add item");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateItem(Item items, long productId, long itemId)
			throws Exception, IdNotFoundException {
		Product product = productRepository.findByProductId(productId);
		Item item = itemRepository.findByItemId(itemId);
		if (product == null || item == null) {
			throw new IdNotFoundException(" Product or Item not found with this ID");
		} else {

			BeanUtils.copyProperties(items, item, "itemImages", "product", "itemId");
			item.setItemId(itemId);
			item.setProduct(product);
			Item savedItems = itemRepository.save(item);
			List<ItemImages> images = items.getItemImages();
			for (ItemImages img : images) {
				BeanUtils.copyProperties(images, img, "item");
				img.setItem(savedItems);
				itemImagesRepository.save(img);
			}

			if (savedItems != null)
				return ResponseEntity.ok("Item Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Item");
		}

	}

	public ResponseEntity<?> deleteItem(long productId, long itemId) throws Exception, IdNotFoundException {

		Item item = itemRepository.findByProductIdAndItemId(productId, itemId);
		if (item == null) {
			throw new IdNotFoundException("No Product ID found with Item ID");
		} else {

			itemRepository.delete(item);
			return ResponseEntity.ok("Item Deleted");
		}
	}

}
