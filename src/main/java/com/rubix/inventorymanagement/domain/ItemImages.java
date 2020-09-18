package com.rubix.inventorymanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_images", schema = "public")

public class ItemImages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long imageID;
	private String imageURL;
	private String imageSequence;
	private String imagePrimaryColor;
	private String imageType;
	private String imageMetadata;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "item_id", referencedColumnName = "itemId")
	private Item item;

	public ItemImages() {

	}

	public ItemImages(long imageID, String imageURL, String imageSequence, String imagePrimaryColor, String imageType,
			String imageMetadata) {
		super();
		this.imageID = imageID;
		this.imageURL = imageURL;
		this.imageSequence = imageSequence;
		this.imagePrimaryColor = imagePrimaryColor;
		this.imageType = imageType;
		this.imageMetadata = imageMetadata;
	}

	public long getImageID() {
		return imageID;
	}

	public void setImageID(long imageID) {
		this.imageID = imageID;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getImageSequence() {
		return imageSequence;
	}

	public void setImageSequence(String imageSequence) {
		this.imageSequence = imageSequence;
	}

	public String getImagePrimaryColor() {
		return imagePrimaryColor;
	}

	public void setImagePrimaryColor(String imagePrimaryColor) {
		this.imagePrimaryColor = imagePrimaryColor;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageMetadata() {
		return imageMetadata;
	}

	public void setImageMetadata(String imageMetadata) {
		this.imageMetadata = imageMetadata;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
