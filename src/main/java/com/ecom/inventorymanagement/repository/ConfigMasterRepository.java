package com.ecom.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.inventorymanagement.domain.ConfigMaster;

@Repository
public interface ConfigMasterRepository extends JpaRepository<ConfigMaster, Long> {

	ConfigMaster findByMasterId(long masterId);

}
