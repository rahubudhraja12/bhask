package com.ecom.inventorymanagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "catalogId")
@Entity
@Table(name = "catalog_item", schema = "public")
public class CatalogItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long catalogId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;

	@ManyToOne(optional = false)
	@JoinColumn(name = "item_id", referencedColumnName = "itemId")
	private Item item;

	private long createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date createdDate;

	private long updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;

	public CatalogItem() {
	}

	public CatalogItem(long catalogId, Product product, Item item, long createdBy, Date createdDate, long updatedBy,
			Date lastUpdated) {
		super();
		this.catalogId = catalogId;
		this.product = product;
		this.item = item;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	public long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

}
