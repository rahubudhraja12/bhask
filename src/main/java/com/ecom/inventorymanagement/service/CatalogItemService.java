package com.ecom.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.inventorymanagement.domain.*;
import com.ecom.inventorymanagement.exception.IdNotFoundException;
import com.ecom.inventorymanagement.repository.*;

@Service
public class CatalogItemService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CatalogItemRepository catalogItemRepository;

	public List<CatalogItem> getAllCatalog() {
		return catalogItemRepository.findAll();
	}

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
			throws Exception, IdNotFoundException {
		Product product = productRepository.findByProductId(productId);
		Item item = itemRepository.findByItemId(itemId);
		CatalogItem catalog = catalogItemRepository.findByCatalogId(catalogId);

		if (product == null || item == null || catalog == null) {
			throw new IdNotFoundException(" Catalog or product not found with this ID");
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

	public ResponseEntity<?> deleteCatalog(long catalogId) throws Exception,IdNotFoundException {

		CatalogItem catalog = catalogItemRepository.findByCatalogId(catalogId);
		if (catalog == null) {
			throw new IdNotFoundException("No Catalog found with this ID");
		} else {
			catalogItemRepository.delete(catalog);
			return ResponseEntity.ok("Catalog Deleted");
		}
	}

}
