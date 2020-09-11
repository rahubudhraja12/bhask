package com.rubix.inventorymanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.Category;
import com.rubix.inventorymanagement.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public ResponseEntity<Object> addCategory(Category category) throws Exception {

		Category categorys = new Category();
		BeanUtils.copyProperties(category, categorys);
		Category savedCategory = categoryRepository.save(categorys);
		Category categoryExist = categoryRepository.findByCategoryId(savedCategory.getCategoryId());
		if (categoryExist != null)
			return ResponseEntity.ok("Category Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add Category");

	}
	@Transactional
	public ResponseEntity<Object> updateCategory(Category categorys, long categoryId) throws Exception {

		Category category = new Category();
		category = categoryRepository.findByCategoryId(categoryId);
		if (category == null) {
			return ResponseEntity.unprocessableEntity().body("No Category found with this ID");
		} else {
			BeanUtils.copyProperties(categorys, category, "categoryId", "product");
			category.setCategoryId(categoryId);
			Category savedCategory = categoryRepository.save(category);
			Category categoryExist = categoryRepository.findByCategoryId(savedCategory.getCategoryId());
			if (categoryExist != null)
				return ResponseEntity.ok("Category Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update category");
		}

	}

	public ResponseEntity<?> deleteCategory(long categoryId) {

		Category category = categoryRepository.findByCategoryId(categoryId);
		if (category == null) {
			return ResponseEntity.unprocessableEntity().body("No Category found with this ID");
		} else {
			categoryRepository.delete(category);
			return ResponseEntity.ok("Category Deleted");
		}
	}
}
