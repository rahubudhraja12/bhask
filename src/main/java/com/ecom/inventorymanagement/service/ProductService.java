package com.ecom.inventorymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.inventorymanagement.domain.Item;
import com.ecom.inventorymanagement.domain.ItemImages;
import com.ecom.inventorymanagement.domain.Product;
import com.ecom.inventorymanagement.exception.IdNotFoundException;
import com.ecom.inventorymanagement.exception.NameAlreadyExistsException;
import com.ecom.inventorymanagement.repository.ItemImagesRepository;
import com.ecom.inventorymanagement.repository.ItemRepository;
import com.ecom.inventorymanagement.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemImagesRepository itemImagesRepository;

	public List<Product> findAllProduct(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pagedResult = productRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Product>();
		}
	}

	public Product findByProductId(Long productId) {
		Product product = new Product();
		product = productRepository.getAll(productId);
		return product;
	}

	public ResponseEntity<Object> addProduct(Product products) throws Exception{

		Product product = new Product();
		BeanUtils.copyProperties(products, product, "items", "catalog");
		if(productRepository.findByProductName(product.getProductName()).isPresent()) {
			throw new IdNotFoundException("Product Name already exists"); 
		}else {
		Product savedProduct = productRepository.save(product);
		List<Item> item = products.getItems();

		for (Item items : item) {
			BeanUtils.copyProperties(item, items, "itemImages", "product");
			items.setProduct(savedProduct);
			if(itemRepository.findByItemName(items.getItemName()).isPresent()) 
				throw new NameAlreadyExistsException("Item Name already exists"); 
			else {
			Item savedItems = itemRepository.save(items);
			List<ItemImages> images = items.getItemImages();
			for (ItemImages img : images) {
				BeanUtils.copyProperties(images, img, "item");
				img.setItem(savedItems);
				itemImagesRepository.save(img);
			}
			}
		}
		Product productExist = productRepository.findByProductId(savedProduct.getProductId());
		if (productExist != null)
			return ResponseEntity.ok("product Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add product");

	}
	}

	@Transactional
	public ResponseEntity<Object> updateProduct(Product products, long productId)
			throws Exception{
		Product product = new Product();
		product = productRepository.findByProductId(productId);
		if (product == null) {
			throw new IdNotFoundException("  product not found with this ID");
		} else {
			BeanUtils.copyProperties(products, product, "items", "productId", "catalog");
			product.setProductId(productId);
			Product savedProduct = productRepository.save(product);
			List<Item> item = products.getItems();

			for (Item items : item) {
				BeanUtils.copyProperties(item, items, "itemImages", "product");
				items.setProduct(savedProduct);
				Item savedItems = itemRepository.save(items);
				List<ItemImages> images = items.getItemImages();
				for (ItemImages img : images) {
					BeanUtils.copyProperties(images, img, "item");
					img.setItem(savedItems);
					itemImagesRepository.save(img);
				}
			}
			Product productExist = productRepository.findByProductId(savedProduct.getProductId());
			if (productExist != null)
				return ResponseEntity.ok("product Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update product");
		}

	}

	public ResponseEntity<?> deleteProduct(long productId) throws Exception {

		Product product = productRepository.findByProductId(productId);
		if (product == null) {
			throw new IdNotFoundException("No Product found with this ID");
		} else {
			productRepository.delete(product);
			return ResponseEntity.ok("product Deleted");
		}
	}

}
