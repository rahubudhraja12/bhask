package com.rubix.inventorymanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.*;
import com.rubix.inventorymanagement.repository.*;
import com.rubix.inventorymanagement.repository.ProductRepository;

@Service
public class CatalogItemService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CatalogItemRepository catalogItemRepository;

	public ResponseEntity<Object> addCatalog(CatalogItem catalogs, long productId, long itemId) throws Exception {

		Product product = productRepository.findByProductId(productId);
		Item item = itemRepository.findByItemId(itemId);
		CatalogItem catalog = new CatalogItem();
		BeanUtils.copyProperties(catalogs, catalog, "item", "product");
		catalog.setProduct(product);
		catalog.setItem(item);
		CatalogItem savedCatalog = catalogItemRepository.save(catalog);
		CatalogItem catalogItemExist = catalogItemRepository.findByCatalogId(savedCatalog.getCatalogId());
		if (catalogItemExist != null)
			return ResponseEntity.ok("Catalog Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add catalog");

	}

	@Transactional
	public ResponseEntity<Object> updateCatalog(CatalogItem catalogs, long productId, long itemId, long catalogId)
			throws Exception {
		Product product = productRepository.findByProductId(productId);
		Item item = itemRepository.findByItemId(itemId);
		CatalogItem catalog = catalogItemRepository.findByCatalogId(catalogId);

		if (product == null || item == null || catalog == null) {
			return ResponseEntity.unprocessableEntity().body(" Category or product not found with this ID");
		} else {
			BeanUtils.copyProperties(catalogs, catalog, "item", "product", "catalogId");
			catalog.setProduct(product);
			catalog.setItem(item);
			catalog.setCatalogId(catalogId);
			CatalogItem savedCatalog = catalogItemRepository.save(catalog);
			CatalogItem catalogExist = catalogItemRepository.findByCatalogId(savedCatalog.getCatalogId());
			if (catalogExist != null)
				return ResponseEntity.ok("Catalog Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update catalog");
		}

	}

	public ResponseEntity<?> deleteCatalog(long catalogId) {

		CatalogItem catalog = catalogItemRepository.findByCatalogId(catalogId);
		if (catalog == null) {
			return ResponseEntity.unprocessableEntity().body("No Catalog found with this ID");
		} else {
			catalogItemRepository.delete(catalog);
			return ResponseEntity.ok("Catalog Deleted");
		}
	}
}
