package com.rubix.inventorymanagement.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Definitions {

	@Embedded
	private VariantValue variantValue;
	@Embedded
	private ProductAttributeValue productAttributeValue;

	public Definitions() {

	}

	public Definitions(VariantValue variantValue, ProductAttributeValue productAttributeValue) {
		super();
		this.variantValue = variantValue;
		this.productAttributeValue = productAttributeValue;
	}

	public VariantValue getVariantValue() {
		return variantValue;
	}

	public void setVariantValue(VariantValue variantValue) {
		this.variantValue = variantValue;
	}

	public ProductAttributeValue getProductAttributeValue() {
		return productAttributeValue;
	}

	public void setProductAttributeValue(ProductAttributeValue productAttributeValue) {
		this.productAttributeValue = productAttributeValue;
	}

}
