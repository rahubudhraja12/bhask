package com.ecom.inventorymanagement.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "item_name" }))
@SequenceGenerator(name = "seq2", initialValue = 101, allocationSize = 100)
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	@JsonFormat(shape = Shape.STRING)
	private long itemId;
	@Column(name = "item_name")
	private String itemName;
	private String itemColor;
	private String itemSize;
	private long quantity;
	private String itemSku;
	private double price;
	private long updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
	private List<ItemImages> itemImages;
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;
	@JsonIgnore
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE)
	private List<CatalogItem> catalog;

	public Item() {

	}

	public Item(long itemId, String itemName, String itemColor, String itemSize, long quantity, String itemSku,
			double price, long updatedBy, Date lastUpdated, List<ItemImages> itemImages, Product product,
			List<CatalogItem> catalog) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemColor = itemColor;
		this.itemSize = itemSize;
		this.quantity = quantity;
		this.itemSku = itemSku;
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

	public String getItemSku() {
		return itemSku;
	}

	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
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

	public List<ItemImages> getItemImages() {
		return itemImages;
	}

	public void setItemImages(List<ItemImages> itemImages) {
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
