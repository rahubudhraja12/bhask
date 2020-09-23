package com.ecom.inventorymanagement.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
@Entity
@Table(name = "ss_role", schema = "public")
@SequenceGenerator(name = "seq8", initialValue = 701, allocationSize = 100)
public class SsRole {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq8")
	@JsonFormat(shape = Shape.STRING)
	private long roleId;
	private String name;
	private String description;
	private String updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;
	@JsonManagedReference
	@OneToMany(mappedBy = "ssRole", cascade = CascadeType.REMOVE)
	private List<SsGroup> ssGroup;
	public SsRole() {

	}

	public SsRole(long roleId, String name, String description, String updatedBy, Date lastUpdated) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.description = description;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<SsGroup> getSsGroup() {
		return ssGroup;
	}

	public void setSsGroup(List<SsGroup> ssGroup) {
		this.ssGroup = ssGroup;
	}

}
