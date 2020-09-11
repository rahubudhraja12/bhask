package com.rubix.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.ConfigMaster;

@Repository
public interface ConfigMasterRepository extends JpaRepository<ConfigMaster, Long> {

	ConfigMaster findByMasterId(long masterId);

}
