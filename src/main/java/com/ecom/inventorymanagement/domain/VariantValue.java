package com.ecom.inventorymanagement.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class VariantValue {
	@ElementCollection
	private List<String> size;
	@ElementCollection
	private List<String> color;

	public VariantValue() {

	}

	public VariantValue(List<String> size, List<String> color) {
		super();
		this.size = size;
		this.color = color;
	}

	public List<String> getSize() {
		return size;
	}

	public void setSize(List<String> size) {
		this.size = size;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	

}
