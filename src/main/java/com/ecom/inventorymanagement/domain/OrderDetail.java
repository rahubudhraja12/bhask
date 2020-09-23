package com.ecom.inventorymanagement.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderId")
@Entity
@Table(name = "order_detail", schema = "public")
@SequenceGenerator(name = "seq5", initialValue = 401, allocationSize = 100)
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq5")
	@JsonFormat(shape = Shape.STRING)
	private long orderId;
	private int orderStatus;
	private double orderTotalAmount;
	private double orderBaseAmount;
	private double discountAmount;
	private double shippingAmount;
	private int userType;
	private String phone;
	private String email;
	private int paymentStatus;
	private int discountType;
	private String discountCode;
	private int busyFlag;
	private String busyVoucherId;
	private int notificationType;
	private int shippingMethod;
	private String shippingId;
	private long createdBy;
	private long updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;

	@OneToOne(mappedBy = "orderDetail", cascade = CascadeType.REMOVE)
	private OrderAddressDetail orderAddressDetail;

	public OrderDetail() {

	}

	public OrderDetail(long orderId, int orderStatus, double orderTotalAmount, double orderBaseAmount,
			double discountAmount, double shippingAmount, int userType, String phone, String email, int paymentStatus,
			int discountType, String discountCode, int busyFlag, String busyVoucherId, int notificationType,
			int shippingMethod, String shippingId, long createdBy, long updatedBy, Date createdDate, Date lastUpdated,
			OrderAddressDetail orderAddressDetail) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderTotalAmount = orderTotalAmount;
		this.orderBaseAmount = orderBaseAmount;
		this.discountAmount = discountAmount;
		this.shippingAmount = shippingAmount;
		this.userType = userType;
		this.phone = phone;
		this.email = email;
		this.paymentStatus = paymentStatus;
		this.discountType = discountType;
		this.discountCode = discountCode;
		this.busyFlag = busyFlag;
		this.busyVoucherId = busyVoucherId;
		this.notificationType = notificationType;
		this.shippingMethod = shippingMethod;
		this.shippingId = shippingId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.lastUpdated = lastUpdated;
		this.orderAddressDetail = orderAddressDetail;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public double getOrderBaseAmount() {
		return orderBaseAmount;
	}

	public void setOrderBaseAmount(double orderBaseAmount) {
		this.orderBaseAmount = orderBaseAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public int getBusyFlag() {
		return busyFlag;
	}

	public void setBusyFlag(int busyFlag) {
		this.busyFlag = busyFlag;
	}

	public String getBusyVoucherId() {
		return busyVoucherId;
	}

	public void setBusyVoucherId(String busyVoucherId) {
		this.busyVoucherId = busyVoucherId;
	}

	public int getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}

	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
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

	public OrderAddressDetail getOrderAddressDetail() {
		return orderAddressDetail;
	}

	public void setOrderAddressDetail(OrderAddressDetail orderAddressDetail) {
		this.orderAddressDetail = orderAddressDetail;
	}

}
