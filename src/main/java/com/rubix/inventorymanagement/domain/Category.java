package com.rubix.inventorymanagement.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "categoryId")
@Entity
@Table(name = "category", schema = "public")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long categoryId;
	private String categoryName;
	private String catagoryDescription;
	@JsonProperty
    @JsonSerialize(using=StringBooleanSerializer.class)
    @JsonDeserialize(using=StringBooleanDeserializer.class)
	private Boolean isPrimary;
	private float discount;
	private Boolean taxable;
	private double taxRate;
	private long updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;
	@JsonProperty
    @JsonSerialize(using=StringBooleanSerializer.class)
    @JsonDeserialize(using=StringBooleanDeserializer.class)
	private Boolean parentCategory;
	@JsonIgnore
	 @ManyToMany(targetEntity = Product.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
	private List<Product> product;

	public Category() {
	}

	public Category(long categoryId, String categoryName,String catagoryDescription, int parent_id,Boolean isPrimary, float discount, Boolean taxable,
			double taxRate, long updatedBy, Date lastUpdated, Boolean parentCategory, List<Product> product) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.catagoryDescription=catagoryDescription;
		this.isPrimary = isPrimary;
		this.discount = discount;
		this.taxable = taxable;
		this.taxRate = taxRate;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
		this.parentCategory = parentCategory;
		this.product = product;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	

	

	public String getCatagoryDescription() {
		return catagoryDescription;
	}

	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
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

	public Boolean getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Boolean parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public static class StringBooleanSerializer extends JsonSerializer<Boolean> {

	    @Override
	    public void serialize(Boolean bool, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
	        generator.writeString(bool ? "Y" : "N");
	    }   
	}

	public static class StringBooleanDeserializer extends JsonDeserializer<Boolean> {

	    @Override
	    public Boolean deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
	        return !"N".equals(parser.getText());
	    }       
	}
}
