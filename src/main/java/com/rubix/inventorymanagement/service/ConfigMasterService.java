package com.rubix.inventorymanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.ConfigMaster;
import com.rubix.inventorymanagement.repository.ConfigMasterRepository;

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
	public ResponseEntity<Object> updateConfig(ConfigMaster config, long masterId) throws Exception {
		ConfigMaster configs = new ConfigMaster();
		configs = configRepository.findByMasterId(masterId);
		if (configs == null) {
			return ResponseEntity.unprocessableEntity().body(" Configuration not found with this ID");
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

	public ResponseEntity<?> deleteConfig(long masterId) {

		ConfigMaster config = configRepository.findByMasterId(masterId);
		if (config == null) {
			return ResponseEntity.unprocessableEntity().body("No Configuration found with this ID");
		} else {
			configRepository.delete(config);
			return ResponseEntity.ok("Configuration Deleted");
		}
	}
}
