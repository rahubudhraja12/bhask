package com.rubix.inventorymanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Specifications {

	private String stitchingType;
	private String productStyle;
	private String workType;
	public Specifications() {
		
	}
	public Specifications(String stitchingType, String productStyle, String workType) {
		super();
		this.stitchingType = stitchingType;
		this.productStyle = productStyle;
		this.workType = workType;
	}

	public String getStitchingType() {
		return stitchingType;
	}

	public void setStitchingType(String stitchingType) {
		this.stitchingType = stitchingType;
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

}
