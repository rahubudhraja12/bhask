package com.rubix.inventorymanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.Product;
import com.rubix.inventorymanagement.repository.ProductRepository;
import com.rubix.inventorymanagement.domain.Item;
import com.rubix.inventorymanagement.repository.ItemRepository;
import com.rubix.inventorymanagement.domain.ItemImages;
import com.rubix.inventorymanagement.repository.ItemImagesRepository;
import com.rubix.inventorymanagement.exception.*;

@Service
public class ItemService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemImagesRepository itemImagesRepository;

	public ResponseEntity<Object> addItem(Item items, long productId) throws Exception, IdNotFoundException {
		Product product = productRepository.findByProductId(productId);
		if (product == null) {
			throw new IdNotFoundException("Product ID not Found");
		} else {
			Item item = new Item();
			BeanUtils.copyProperties(items, item, "itemImages", "product");
			item.setProduct(product);
			Item savedItems = itemRepository.save(item);
			ItemImages img = new ItemImages();
			img = items.getItemImages();
			img.setItem(savedItems);
			itemImagesRepository.save(img);

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
		if (product == null||item==null) {
			throw new IdNotFoundException(" Product or Item not found with this ID");
		} else {
			
			BeanUtils.copyProperties(item, items, "itemImages", "product", "itemId");
			item.setItemId(itemId);
			item.setProduct(product);
			Item savedItems = itemRepository.save(item);
			ItemImages img = new ItemImages();
			long itemImgId = itemImagesRepository.findItemImageIdByItemId(itemId);
			img = items.getItemImages();
			img.setItem(savedItems);
			img.setImageID(itemImgId);
			itemImagesRepository.save(img);
			if (savedItems != null)
				return ResponseEntity.ok("Item Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Item");
		}

	}

	public ResponseEntity<?> deleteItem(long productId, long itemId)throws Exception, IdNotFoundException {

		Item item = itemRepository.findByProductIdAndItemId(productId, itemId);
		if (item == null) {
			throw new IdNotFoundException("No Product ID found with Item ID");
		} else {

			itemRepository.delete(item);
			return ResponseEntity.ok("Item Deleted");
		}
	}

}
