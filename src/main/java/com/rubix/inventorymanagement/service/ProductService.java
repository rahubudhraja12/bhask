package com.rubix.inventorymanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.Product;
import com.rubix.inventorymanagement.exception.IdNotFoundException;
import com.rubix.inventorymanagement.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ResponseEntity<Object> addProduct(Product products) throws Exception {

		Product product = new Product();
		BeanUtils.copyProperties(products, product, "items", "catalog");

		Product savedProduct = productRepository.save(product);
		Product productExist = productRepository.findByProductId(savedProduct.getProductId());
		if (productExist != null)
			return ResponseEntity.ok("product Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add product");

	}

	@Transactional
	public ResponseEntity<Object> updateProduct(Product products, long productId) throws Exception,IdNotFoundException {
		Product product = new Product();
		product = productRepository.findByProductId(productId);
		if (product == null) {
			throw new IdNotFoundException("  product not found with this ID");
		} else {
			BeanUtils.copyProperties(products, product, "items", "productId", "catalog");
			product.setProductId(productId);
			Product savedProduct = productRepository.save(product);
			Product productExist = productRepository.findByProductId(savedProduct.getProductId());
			if (productExist != null)
				return ResponseEntity.ok("product Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update product");
		}

	}

	public ResponseEntity<?> deleteProduct(long productId)throws Exception,IdNotFoundException {

		Product product = productRepository.findByProductId(productId);
		if (product == null) {
			throw new IdNotFoundException("No Product found with this ID");
		} else {
			productRepository.delete(product);
			return ResponseEntity.ok("product Deleted");
		}
	}

}
