package com.ecom.inventorymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.inventorymanagement.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByCategoryId(long categoryId);

	Optional<Category> findByCategoryName(String categoryName);

}
