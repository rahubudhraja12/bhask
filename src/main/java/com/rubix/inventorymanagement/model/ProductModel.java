package com.rubix.inventorymanagement.model;

import java.util.List;

import com.rubix.inventorymanagement.domain.Item;

public class ProductModel {
	private long productId;
	private String productName;
	private String productDescription;
	private long quantity;
	private String sku;
	private double purchasePrice;
	private double salePrice;
	private double comparePrice;
	private float discount;
	private Boolean taxable;
	private double taxRate;
	private boolean inStock;
	private Boolean isActive;
	private Boolean isFeature;
	private Boolean isLatest;
	private float productWeight;
	private float productLength;
	private float productWidth;
	private float productHeight;
	private String fabricmaterial_type1;
	private String fabricmaterial_type2;
	private String productStyle;
	private String workType;
	private long updatedBy;
	private long starRating;
	private List<CategoryModel> category;
	private String lastNoProductAdded;
	private List<Item> items;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getComparePrice() {
		return comparePrice;
	}

	public void setComparePrice(double comparePrice) {
		this.comparePrice = comparePrice;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Boolean getTaxable() {
		return taxable;
	}

	public void setTaxable(Boolean taxable) {
		this.taxable = taxable;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsFeature() {
		return isFeature;
	}

	public void setIsFeature(Boolean isFeature) {
		this.isFeature = isFeature;
	}

	public Boolean getIsLatest() {
		return isLatest;
	}

	public void setIsLatest(Boolean isLatest) {
		this.isLatest = isLatest;
	}

	public float getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(float productWeight) {
		this.productWeight = productWeight;
	}

	public float getProductLength() {
		return productLength;
	}

	public void setProductLength(float productLength) {
		this.productLength = productLength;
	}

	public float getProductWidth() {
		return productWidth;
	}

	public void setProductWidth(float productWidth) {
		this.productWidth = productWidth;
	}

	public float getProductHeight() {
		return productHeight;
	}

	public void setProductHeight(float productHeight) {
		this.productHeight = productHeight;
	}

	public String getFabricmaterial_type1() {
		return fabricmaterial_type1;
	}

	public void setFabricmaterial_type1(String fabricmaterial_type1) {
		this.fabricmaterial_type1 = fabricmaterial_type1;
	}

	public String getFabricmaterial_type2() {
		return fabricmaterial_type2;
	}

	public void setFabricmaterial_type2(String fabricmaterial_type2) {
		this.fabricmaterial_type2 = fabricmaterial_type2;
	}

	public String getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public long getStarRating() {
		return starRating;
	}

	public void setStarRating(long starRating) {
		this.starRating = starRating;
	}

	public List<CategoryModel> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryModel> category) {
		this.category = category;
	}

	public String getLastNoProductAdded() {
		return lastNoProductAdded;
	}

	public void setLastNoProductAdded(String lastNoProductAdded) {
		this.lastNoProductAdded = lastNoProductAdded;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
