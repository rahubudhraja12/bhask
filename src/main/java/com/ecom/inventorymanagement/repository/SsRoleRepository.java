package com.ecom.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.inventorymanagement.domain.SsRole;

@Repository
public interface SsRoleRepository extends JpaRepository<SsRole, Long> {

	SsRole findByRoleId(long roleId);
	

}
