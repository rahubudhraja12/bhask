package com.rubix.inventorymanagement.domain;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
@Entity
@Table(name = "ss_group", schema = "public")
public class SsGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long groupId;
	private String name;
	private String description;
	private String updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date lastUpdated;
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "role_id", referencedColumnName = "roleId")
	private SsRole ssRole;
	@JsonManagedReference
	@OneToMany(mappedBy = "ssGroup", cascade = CascadeType.REMOVE)
	private List<SsUser> ssUser;
	public SsGroup() {

	}

	public SsGroup(long groupId, String name, String description, String updatedBy, Date lastUpdated) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.description = description;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
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

	public SsRole getSsRole() {
		return ssRole;
	}

	public void setSsRole(SsRole ssRole) {
		this.ssRole = ssRole;
	}

	public List<SsUser> getSsUser() {
		return ssUser;
	}

	public void setSsUser(List<SsUser> ssUser) {
		this.ssUser = ssUser;
	}

}
