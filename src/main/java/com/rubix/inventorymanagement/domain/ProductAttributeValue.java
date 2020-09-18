package com.rubix.inventorymanagement.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class ProductAttributeValue {
	@ElementCollection
	private List<String> workType;
	@ElementCollection
	private List<String> style;
	@ElementCollection
	private List<String> material;
	@ElementCollection
	private List<String> stitching;

	public ProductAttributeValue() {

	}

	public ProductAttributeValue(List<String> workType, List<String> style, List<String> material,
			List<String> stitching) {
		super();
		this.workType = workType;
		this.style = style;
		this.material = material;
		this.stitching = stitching;
	}

	public List<String> getWorkType() {
		return workType;
	}

	public void setWorkType(List<String> workType) {
		this.workType = workType;
	}

	public List<String> getStyle() {
		return style;
	}

	public void setStyle(List<String> style) {
		this.style = style;
	}

	public List<String> getMaterial() {
		return material;
	}

	public void setMaterial(List<String> material) {
		this.material = material;
	}

	public List<String> getStitching() {
		return stitching;
	}

	public void setStitching(List<String> stitching) {
		this.stitching = stitching;
	}

}
