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
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ss_user", schema = "public")
@SequenceGenerator(name = "seq10", initialValue = 901, allocationSize = 100)
public class SsUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq10")
	@JsonFormat(shape = Shape.STRING)
	private long userId;
	private String name;
	private String description;
	private Boolean isAdmin;
	private long updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "group_id", referencedColumnName = "groupId")
	private SsGroup ssGroup;
	@JsonManagedReference
	@OneToMany(mappedBy = "ssUser", cascade = CascadeType.REMOVE)
	private List<Address> address;

	public SsUser() {
	}

	public SsUser(long userId, String name, String description, Boolean isAdmin, long updatedBy, Date lastUpdated) {
		super();
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.isAdmin = isAdmin;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
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

	public SsGroup getSsGroup() {
		return ssGroup;
	}

	public void setSsGroup(SsGroup ssGroup) {
		this.ssGroup = ssGroup;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
