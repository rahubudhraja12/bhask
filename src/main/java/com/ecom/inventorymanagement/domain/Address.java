package com.ecom.inventorymanagement.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "address", schema = "public")
@SequenceGenerator(name = "seq11", initialValue = 1001, allocationSize = 100)
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq11")
	@JsonFormat(shape = Shape.STRING)
	private long addressId;
	private String addLine1;
	private String addLine2;
	private String addLine3;
	private String addLine4;
	private String phoneNumber;
	private String cellNumber;
	private String faxNumber;
	private String city;
	private String state;
	private String zipcode;
	private Boolean isPrimary;
	private Boolean isMailing;
	private Boolean isBilling;
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private SsUser ssUser;
	private long updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;
	@JsonIgnore
	@OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
	private List<Customer> customer;
	public Address() {

	}

	public Address(long addressId, String addLine1, String addLine2, String addLine3, String addLine4,
			String phoneNumber, String cellNumber, String faxNumber, String city, String state, String zipcode,
			Boolean isPrimary, Boolean isMailing, Boolean isBilling, long updatedBy,Date lastUpdated) {
		super();
		this.addressId = addressId;
		this.addLine1 = addLine1;
		this.addLine2 = addLine2;
		this.addLine3 = addLine3;
		this.addLine4 = addLine4;
		this.phoneNumber = phoneNumber;
		this.cellNumber = cellNumber;
		this.faxNumber = faxNumber;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.isPrimary = isPrimary;
		this.isMailing = isMailing;
		this.isBilling = isBilling;
		this.updatedBy= updatedBy;
		this.lastUpdated = lastUpdated;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getAddLine3() {
		return addLine3;
	}

	public void setAddLine3(String addLine3) {
		this.addLine3 = addLine3;
	}

	public String getAddLine4() {
		return addLine4;
	}

	public void setAddLine4(String addLine4) {
		this.addLine4 = addLine4;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Boolean getIsMailing() {
		return isMailing;
	}

	public void setIsMailing(Boolean isMailing) {
		this.isMailing = isMailing;
	}

	public Boolean getIsBilling() {
		return isBilling;
	}

	public void setIsBilling(Boolean isBilling) {
		this.isBilling = isBilling;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public SsUser getSsUser() {
		return ssUser;
	}

	public void setSsUser(SsUser ssUser) {
		this.ssUser = ssUser;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

}
