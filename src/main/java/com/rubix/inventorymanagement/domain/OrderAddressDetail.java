package com.rubix.inventorymanagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderAddressDetailId")
@Entity
@Table(name = "order_address_detail", schema = "public")
public class OrderAddressDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long orderAddressDetailId;
	private String shipToFirstName;
	private String shipToMiddleName;
	private String shipToLastName;
	private String shipToAddLine1;
	private String shipToAddLine2;
	private String shipToCity;
	private String shipToZipcode;
	private String shipToState;
	private String shipToCountry;
	private Boolean shipToBillToSameFlag;
	private String billToFirstName;
	private String billToMiddleName;
	private String billToLastName;
	private String billToAddLine1;
	private String billToAddLine2;
	private String billToCity;
	private String billToZipcode;
	private String billToState;
	private String billToCountry;
	private long createdBy;
	private long updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;

	@OneToOne(optional = false)
	@JoinColumn(name = "order_id", referencedColumnName = "orderId")
	private OrderDetail orderDetail;

	public OrderAddressDetail() {

	}

	public OrderAddressDetail(long orderAddressDetailId, String shipToFirstName, String shipToMiddleName,
			String shipToLastName, String shipToAddLine1, String shipToAddLine2, String shipToCity,
			String shipToZipcode, String shipToState, String shipToCountry, Boolean shipToBillToSameFlag,
			String billToFirstName, String billToMiddleName, String billToLastName, String billToAddLine1,
			String billToAddLine2, String billToCity, String billToZipcode, String billToState, String billToCountry,
			long createdBy, long updatedBy, Date createdDate, Date lastUpdated) {
		super();
		this.orderAddressDetailId = orderAddressDetailId;
		this.shipToFirstName = shipToFirstName;
		this.shipToMiddleName = shipToMiddleName;
		this.shipToLastName = shipToLastName;
		this.shipToAddLine1 = shipToAddLine1;
		this.shipToAddLine2 = shipToAddLine2;
		this.shipToCity = shipToCity;
		this.shipToZipcode = shipToZipcode;
		this.shipToState = shipToState;
		this.shipToCountry = shipToCountry;
		this.shipToBillToSameFlag = shipToBillToSameFlag;
		this.billToFirstName = billToFirstName;
		this.billToMiddleName = billToMiddleName;
		this.billToLastName = billToLastName;
		this.billToAddLine1 = billToAddLine1;
		this.billToAddLine2 = billToAddLine2;
		this.billToCity = billToCity;
		this.billToZipcode = billToZipcode;
		this.billToState = billToState;
		this.billToCountry = billToCountry;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.lastUpdated = lastUpdated;

	}

	public long getOrderAddressDetailId() {
		return orderAddressDetailId;
	}

	public void setOrderAddressDetailId(long orderAddressDetailId) {
		this.orderAddressDetailId = orderAddressDetailId;
	}

	public String getShipToFirstName() {
		return shipToFirstName;
	}

	public void setShipToFirstName(String shipToFirstName) {
		this.shipToFirstName = shipToFirstName;
	}

	public String getShipToMiddleName() {
		return shipToMiddleName;
	}

	public void setShipToMiddleName(String shipToMiddleName) {
		this.shipToMiddleName = shipToMiddleName;
	}

	public String getShipToLastName() {
		return shipToLastName;
	}

	public void setShipToLastName(String shipToLastName) {
		this.shipToLastName = shipToLastName;
	}

	public String getShipToAddLine1() {
		return shipToAddLine1;
	}

	public void setShipToAddLine1(String shipToAddLine1) {
		this.shipToAddLine1 = shipToAddLine1;
	}

	public String getShipToAddLine2() {
		return shipToAddLine2;
	}

	public void setShipToAddLine2(String shipToAddLine2) {
		this.shipToAddLine2 = shipToAddLine2;
	}

	public String getShipToCity() {
		return shipToCity;
	}

	public void setShipToCity(String shipToCity) {
		this.shipToCity = shipToCity;
	}

	public String getShipToZipcode() {
		return shipToZipcode;
	}

	public void setShipToZipcode(String shipToZipcode) {
		this.shipToZipcode = shipToZipcode;
	}

	public String getShipToState() {
		return shipToState;
	}

	public void setShipToState(String shipToState) {
		this.shipToState = shipToState;
	}

	public String getShipToCountry() {
		return shipToCountry;
	}

	public void setShipToCountry(String shipToCountry) {
		this.shipToCountry = shipToCountry;
	}

	public Boolean getShipToBillToSameFlag() {
		return shipToBillToSameFlag;
	}

	public void setShipToBillToSameFlag(Boolean shipToBillToSameFlag) {
		this.shipToBillToSameFlag = shipToBillToSameFlag;
	}

	public String getBillToFirstName() {
		return billToFirstName;
	}

	public void setBillToFirstName(String billToFirstName) {
		this.billToFirstName = billToFirstName;
	}

	public String getBillToMiddleName() {
		return billToMiddleName;
	}

	public void setBillToMiddleName(String billToMiddleName) {
		this.billToMiddleName = billToMiddleName;
	}

	public String getBillToLastName() {
		return billToLastName;
	}

	public void setBillToLastName(String billToLastName) {
		this.billToLastName = billToLastName;
	}

	public String getBillToAddLine1() {
		return billToAddLine1;
	}

	public void setBillToAddLine1(String billToAddLine1) {
		this.billToAddLine1 = billToAddLine1;
	}

	public String getBillToAddLine2() {
		return billToAddLine2;
	}

	public void setBillToAddLine2(String billToAddLine2) {
		this.billToAddLine2 = billToAddLine2;
	}

	public String getBillToCity() {
		return billToCity;
	}

	public void setBillToCity(String billToCity) {
		this.billToCity = billToCity;
	}

	public String getBillToZipcode() {
		return billToZipcode;
	}

	public void setBillToZipcode(String billToZipcode) {
		this.billToZipcode = billToZipcode;
	}

	public String getBillToState() {
		return billToState;
	}

	public void setBillToState(String billToState) {
		this.billToState = billToState;
	}

	public String getBillToCountry() {
		return billToCountry;
	}

	public void setBillToCountry(String billToCountry) {
		this.billToCountry = billToCountry;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public OrderDetail getOrder() {
		return orderDetail;
	}

	public void setOrder(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

}
