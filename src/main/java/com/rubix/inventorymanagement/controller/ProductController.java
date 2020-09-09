package com.rubix.inventorymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.inventorymanagement.domain.CatalogItem;
import com.rubix.inventorymanagement.domain.Category;
import com.rubix.inventorymanagement.domain.Item;
import com.rubix.inventorymanagement.domain.Product;
import com.rubix.inventorymanagement.repository.CatalogItemRepository;
import com.rubix.inventorymanagement.repository.CategoryRepository;
import com.rubix.inventorymanagement.repository.ItemRepository;
import com.rubix.inventorymanagement.repository.ProductRepository;
import com.rubix.inventorymanagement.service.CatalogItemService;
import com.rubix.inventorymanagement.service.CategoryService;
import com.rubix.inventorymanagement.service.ItemService;
import com.rubix.inventorymanagement.service.ProductService;

/**
 * @author Administrator
 * @class ProductController 
 */
@RestController
@RequestMapping("inventory")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CatalogItemService catalogService;
	@Autowired
	private CatalogItemRepository catalogRepository;
	
	
	
	@PostMapping("/product/{productId}/item/{itemId}/catalog")
	public ResponseEntity<Object> addCatalog(@RequestBody  CatalogItem  catalogItem,@PathVariable(value = "productId") Long productId,
			@PathVariable(value = "itemId") Long itemId) throws Exception {
		return catalogService.addCatalog(catalogItem,productId,itemId);
	}
	@GetMapping("/getCatalog")
	public List<CatalogItem> getAllCatalog() {
		return catalogRepository.findAll();

	}
	@PutMapping("/product/{productId}/item/{itemId}/catalog/{catalogId}")
	public ResponseEntity<Object> updateCatalog(@RequestBody  CatalogItem  catalogItem,@PathVariable(value = "productId") Long productId,
			@PathVariable(value = "itemId") Long itemId,@PathVariable(value = "catalogId") Long catalogId) throws Exception {
		return  catalogService.updateCatalog(catalogItem,productId,itemId,catalogId);
	}
	@DeleteMapping("/product/item/catalog/{catalogId}")
	public ResponseEntity<?> deleteCatalog(@PathVariable(value = "catalogId") Long catalogId) {
		return catalogService.deleteCatalog(catalogId);

	}
	/**
	 * 
	 * @method addCategory
	 * @param Category
	 * @return ResponseEntity
	 */
	@PostMapping("/category")
	public ResponseEntity<Object> addCategory(@RequestBody Category category) throws Exception {
		return categoryService.addCategory(category);
	}
	/**
	 * 
	 * @method getAllCategory
	 * @return List<Category>
	 */

	@GetMapping("/getCategory")
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();

	}
	/**
	 * 
	 * @method updateCategory
	 * @param Category,categoryId
	 * @return ResponseEntity
	 */

	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category,
			@PathVariable(value = "categoryId") Long categoryId) throws Exception {
		return categoryService.updateCategory(category, categoryId);
	}
	/**
	 * 
	 * @method deleteCategory
	 * @param categoryId
	 * @return ResponseEntity
	 */
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
		return categoryService.deleteCategory(categoryId);

	}
	/**
	 * 
	 * @method addProduct
	 * @param Product,categoryId
	 * @return ResponseEntity
	 */
	@PostMapping("/product")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) throws Exception {
		return productService.addProduct(product);
	}
	/**
	 * 
	 * @method  getAll
	 * @return List<Product>
	 */
	@GetMapping("/getProducts")
	public List<Product> getAll() {
		return productRepository.findAll();

	}
	/**
	 * 
	 * @method getByProduct
	 * @param productId
	 * @return Product
	 */
	@GetMapping("/getProductById/{productId}")
	public Product getByProduct(@PathVariable(value = "productId") Long productId) {
		Product product = new Product();
		product = productRepository.getAll(productId);
		return product;
	}
	/**
	 * 
	 * @method updateProduct
	 * @param Product,productId,categoryId
	 * @return ResponseEntity
	 */
	@PutMapping("/product/{productId}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product,
			@PathVariable(value = "productId") Long productId)
			throws Exception {
		return productService.updateProduct(product, productId);
	}
	/**
	 * 
	 * @method deleteProduct
	 * @param productId,categoryId
	 * @return ResponseEntity
	 */
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "productId") Long productId) {
		return productService.deleteProduct(productId);

	}
	/**
	 * 
	 * @method addItem
	 * @param Item,productId 
	 * @return ResponseEntity
	 */
	@GetMapping("/getItemByProductId/{productId}")
	public List<Item> getItemByProductId(@PathVariable(value = "productId") Long productId) {
		List<Item> item=new ArrayList<>();
		item = itemRepository.findByProductId(productId);
		return item;
	}
	@PostMapping("/product/{productId}/item")
	public ResponseEntity<Object> addItem(@RequestBody Item item, @PathVariable(value = "productId") Long productId)
			throws Exception {
		return itemService.addItem(item, productId);
	}
	/**
	 * 
	 * @method updateItem
	 * @param Item,productId,itemId
	 * @return ResponseEntity
	 */
	@PutMapping("/product/{productId}/item/{itemId}")
	public ResponseEntity<Object> updateItem(@RequestBody Item item, @PathVariable(value = "productId") Long productId,
			@PathVariable(value = "itemId") Long itemId) throws Exception {
		return itemService.updateItem(item, productId, itemId);
	}
	/**
	 * 
	 * @method deleteItem
	 * @param productId,itemId
	 * @return ResponseEntity
	 */
	@DeleteMapping("/product/{productId}/item/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "productId") Long productId,
			@PathVariable(value = "itemId") Long itemId) {
		return itemService.deleteItem(productId, itemId);

	}

}
