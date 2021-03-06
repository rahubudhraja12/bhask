package com.ecom.inventorymanagement.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
@Entity
@Table(name = "product", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "product_name" }))
@SequenceGenerator(name = "seq1", initialValue = 1, allocationSize = 100)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	@JsonFormat(shape = Shape.STRING)
	private long productId;
	@Column(name = "product_name")
	private String productName;
	private String productLongName;
	private String productDescription;
	private long quantity;
	private String productSku;
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
	@Embedded
	private Definitions definitions;
	@Embedded
	private Specifications specifications;
	private long updatedBy;
	private long starRating;
	@ManyToMany(targetEntity = Category.class, fetch = FetchType.EAGER, cascade = { CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "product_category", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "productId") }, inverseJoinColumns = {
					@JoinColumn(name = "category_id", referencedColumnName = "categoryId") })
	private List<Category> category;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;

	@JsonManagedReference
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<Item> items;
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<CatalogItem> catalog;

	public Product() {

	}

	public Product(long productId, String productName, String productLongName, String productDescription, long quantity,
			String productSku, double purchasePrice, double salePrice, double comparePrice, float discount,
			Boolean taxable, double taxRate, boolean inStock, Boolean isActive, Boolean isFeature, Boolean isLatest,
			float productWeight, float productLength, float productWidth, float productHeight,
			String fabricmaterial_type1, String fabricmaterial_type2, long updatedBy, long starRating,
			List<Category> category, String lastNoProductAdded, Date lastUpdated, List<Item> items,
			List<CatalogItem> catalog) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productLongName = productLongName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.productSku = productSku;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.comparePrice = comparePrice;
		this.discount = discount;
		this.taxable = taxable;
		this.taxRate = taxRate;
		this.inStock = inStock;
		this.isActive = isActive;
		this.isFeature = isFeature;
		this.isLatest = isLatest;
		this.productWeight = productWeight;
		this.productLength = productLength;
		this.productWidth = productWidth;
		this.productHeight = productHeight;
		this.fabricmaterial_type1 = fabricmaterial_type1;
		this.fabricmaterial_type2 = fabricmaterial_type2;
		this.updatedBy = updatedBy;
		this.starRating = starRating;
		this.category = category;
		this.lastUpdated = lastUpdated;
		this.items = items;
		this.catalog = catalog;
	}

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

	public String getProductLongName() {
		return productLongName;
	}

	public void setProductLongName(String productLongName) {
		this.productLongName = productLongName;
	}

	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
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

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<CatalogItem> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<CatalogItem> catalog) {
		this.catalog = catalog;
	}

	public Specifications getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Specifications specifications) {
		this.specifications = specifications;
	}

	public Definitions getDefinitions() {
		return definitions;
	}

	public void setDefinitions(Definitions definitions) {
		this.definitions = definitions;
	}

}
