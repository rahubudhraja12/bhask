package com.rubix.inventorymanagement.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.inventorymanagement.domain.CatalogItem;
import com.rubix.inventorymanagement.domain.Category;
import com.rubix.inventorymanagement.domain.Item;
import com.rubix.inventorymanagement.domain.ItemImages;
import com.rubix.inventorymanagement.domain.Product;
import com.rubix.inventorymanagement.service.CatalogItemService;
import com.rubix.inventorymanagement.service.CategoryService;
import com.rubix.inventorymanagement.service.ItemImageService;
import com.rubix.inventorymanagement.service.ItemService;
import com.rubix.inventorymanagement.service.ProductService;

/**
 * @author Administrator
 * @class ProductController
 */
@RestController
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemImageService itemImageService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CatalogItemService catalogService;

	@PostMapping("saveCatalog")
	public ResponseEntity<Object> addCatalog(@RequestBody CatalogItem catalogItem,
			@RequestParam(value = "productId", required = true) Long productId,
			@RequestParam(value = "itemId") Long itemId) throws Exception {
		return catalogService.addCatalog(catalogItem, productId, itemId);
	}

	@GetMapping("getCatalogAll")
	public List<CatalogItem> getAllCatalog() {
		return catalogService.getAllCatalog();
	}

	@PutMapping("updateCatalog")
	public ResponseEntity<Object> updateCatalog(@RequestBody CatalogItem catalogItem,
			@RequestParam(value = "productId", required = true) Long productId,
			@RequestParam(value = "itemId") Long itemId,
			@RequestParam(value = "catalogId", required = true) Long catalogId) throws Exception {
		return catalogService.updateCatalog(catalogItem, productId, itemId, catalogId);
	}

	@DeleteMapping("deleteCatalog/{catalogId}")
	public ResponseEntity<?> deleteCatalog(@PathVariable(value = "catalogId") Long catalogId) throws Exception {
		return catalogService.deleteCatalog(catalogId);

	}

	/**
	 * 
	 * @method addCategory
	 * @param Category
	 * @return ResponseEntity
	 */
	@PostMapping("saveCategory")
	public ResponseEntity<Object> addCategory(@RequestBody Category category) throws Exception {
		return categoryService.addCategory(category);
	}

	/**
	 * 
	 * @method getAllCategory
	 * @return List<Category>
	 */

	@GetMapping("getCategoryAll")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();

	}

	/**
	 * 
	 * @method updateCategory
	 * @param Category,categoryId
	 * @return ResponseEntity
	 */

	@PutMapping("updateCategory")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category,
			@RequestParam(value = "categoryId", required = true) Long categoryId) throws Exception {
		return categoryService.updateCategory(category, categoryId);
	}

	/**
	 * 
	 * @method deleteCategory
	 * @param categoryId
	 * @return ResponseEntity
	 */
	@DeleteMapping("deleteCategory/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable(value = "categoryId") Long categoryId) throws Exception {
		return categoryService.deleteCategory(categoryId);

	}

	/**
	 * 
	 * @method addProduct
	 * @param Product,categoryId
	 * @return ResponseEntity
	 */
	@PostMapping("saveProduct")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) throws Exception {
		return productService.addProduct(product);
	}

	/**
	 * 
	 * @method getAll
	 * @return List<Product>
	 */
	@GetMapping("getProductAll")
	public List<Product> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "100") Integer pageSize) {
		return productService.findAllProduct(pageNo, pageSize);

	}

	/**
	 * 
	 * @method getByProduct
	 * @param productId
	 * @return Product
	 */
	@GetMapping("getProductById")
	public Product getByProduct(@RequestParam(value = "productId", required = true) Long productId) {
		return productService.findByProductId(productId);
	}

	/**
	 * 
	 * @method updateProduct
	 * @param Product,productId,categoryId
	 * @return ResponseEntity
	 */
	@PutMapping("updateProduct")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product,
			@RequestParam(value = "productId", required = true) Long productId) throws Exception {
		return productService.updateProduct(product, productId);
	}

	/**
	 * 
	 * @method deleteProduct
	 * @param productId,categoryId
	 * @return ResponseEntity
	 */
	@DeleteMapping("deleteProduct/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "productId") Long productId) throws Exception {
		return productService.deleteProduct(productId);

	}

	@GetMapping("getItemAll")
	public List<Item> getAllItems() {
		return itemService.findAllItem();
	}

	@GetMapping("getItemByProductId")
	public List<Item> getItemByProductId(@RequestParam(value = "productId", required = true) Long productId) {
		return itemService.findItemByProductId(productId);
	}

	/**
	 * 
	 * @method addItem
	 * @param Item,productId
	 * @return ResponseEntity
	 */
	@PostMapping("saveItem")
	public ResponseEntity<Object> addItem(@RequestBody Item item,
			@RequestParam(value = "productId", required = true) Long productId) throws Exception {
		return itemService.addItem(item, productId);
	}

	/**
	 * 
	 * @method updateItem
	 * @param Item,productId,itemId
	 * @return ResponseEntity
	 */
	@PutMapping("updateItem")
	public ResponseEntity<Object> updateItem(@RequestBody Item item,
			@RequestParam(value = "productId", required = true) Long productId,
			@RequestParam(value = "itemId", required = true) Long itemId) throws Exception {
		return itemService.updateItem(item, productId, itemId);
	}

	/**
	 * 
	 * @method deleteItem
	 * @param productId,itemId
	 * @return ResponseEntity
	 */
	@DeleteMapping("deleteItem/{productId}/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "productId") Long productId,
			@PathVariable(value = "itemId") Long itemId) throws Exception {
		return itemService.deleteItem(productId, itemId);

	}

	@GetMapping("getItemImageAll")
	public List<ItemImages> getAllItemImages() {
		return itemImageService.getAllItemImages();
	}

	@PostMapping("saveItemImages")
	public ResponseEntity<Object> addItemImage(@RequestBody ItemImages image,
			@RequestParam(value = "itemId", required = true) Long itemId) throws Exception {
		return itemImageService.addItemImage(image, itemId);
	}

	@PutMapping("updateItemImages")
	public ResponseEntity<Object> updateItemImage(@RequestBody ItemImages image,
			@RequestParam(value = "itemId", required = true) Long itemId,
			@RequestParam(value = "itemImageId", required = true) Long itemImageId) throws Exception {
		return itemImageService.updateItemImage(image, itemId, itemImageId);
	}

	@DeleteMapping("deleteItemImage/{itemId}/{itemImageId}")
	public ResponseEntity<?> deleteItemImage(@PathVariable(value = "itemId") Long itemId,
			@PathVariable(value = "itemImageId") Long itemImageId) throws Exception {
		return itemImageService.deleteItemImage(itemId, itemImageId);

	}

}
