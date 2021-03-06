package com.ecom.inventorymanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.inventorymanagement.domain.ConfigMaster;
import com.ecom.inventorymanagement.exception.IdNotFoundException;
import com.ecom.inventorymanagement.repository.ConfigMasterRepository;

@Service
public class ConfigMasterService {
	@Autowired
	private ConfigMasterRepository configRepository;

	public ResponseEntity<Object> addConfig(ConfigMaster config) throws Exception {

		ConfigMaster configs = new ConfigMaster();
		BeanUtils.copyProperties(config, configs);

		ConfigMaster savedConfig = configRepository.save(configs);
		ConfigMaster configExist = configRepository.findByMasterId(savedConfig.getMasterId());
		if (configExist != null)
			return ResponseEntity.ok("Configuration Added");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to add Configuration");

	}

	@Transactional
	public ResponseEntity<Object> updateConfig(ConfigMaster config, long masterId) throws Exception ,IdNotFoundException{
		ConfigMaster configs = new ConfigMaster();
		configs = configRepository.findByMasterId(masterId);
		if (configs == null) {
			throw new IdNotFoundException(" Configuration not found with this ID");
		} else {
			BeanUtils.copyProperties(config, configs);
			configs.setMasterId(masterId);
			ConfigMaster savedConfig = configRepository.save(configs);
			ConfigMaster configExist = configRepository.findByMasterId(savedConfig.getMasterId());
			if (configExist != null)
				return ResponseEntity.ok("Configuration Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Configuration");
		}

	}

	public ResponseEntity<?> deleteConfig(long masterId) throws Exception ,IdNotFoundException{

		ConfigMaster config = configRepository.findByMasterId(masterId);
		if (config == null) {
			throw new IdNotFoundException("No Configuration found with this ID");
		} else {
			configRepository.delete(config);
			return ResponseEntity.ok("Configuration Deleted");
		}
	}
}
