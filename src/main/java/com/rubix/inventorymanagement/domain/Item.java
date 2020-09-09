package com.rubix.inventorymanagement.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "itemId")*/
@Entity
@Table(name = "item", schema = "public")
//@JsonIgnoreProperties("catalogItem")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long itemId;
	private String itemName;
	private String itemColor;
	private String itemSize;
	private long quantity;
	private String sku;
	private long busyItemCode;
	private String longName;
	private String description;	
	private double price;
	private long updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;
	@OneToOne(mappedBy = "item", cascade = CascadeType.REMOVE)
	private ItemImages itemImages;
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;
	@JsonIgnore
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
	private List<CatalogItem> catalog;

	public Item() {

	}

	public Item(long itemId, String itemName, String itemColor, String itemSize, long quantity, String sku,
			long busyItemCode, String longName, String description, double price, long updatedBy, Date lastUpdated,
			ItemImages itemImages, Product product, List<CatalogItem> catalog) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemColor = itemColor;
		this.itemSize = itemSize;
		this.quantity = quantity;
		this.sku = sku;
		this.busyItemCode = busyItemCode;
		this.longName = longName;
		this.description = description;
		this.price = price;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
		this.itemImages = itemImages;
		this.product = product;
		this.catalog = catalog;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
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

	public long getBusyItemCode() {
		return busyItemCode;
	}

	public void setBusyItemCode(long busyItemCode) {
		this.busyItemCode = busyItemCode;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public ItemImages getItemImages() {
		return itemImages;
	}

	public void setItemImages(ItemImages itemImages) {
		this.itemImages = itemImages;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<CatalogItem> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<CatalogItem> catalog) {
		this.catalog = catalog;
	}

	
}
