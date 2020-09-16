package com.rubix.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.inventorymanagement.domain.ConfigMaster;
import com.rubix.inventorymanagement.repository.ConfigMasterRepository;
import com.rubix.inventorymanagement.service.ConfigMasterService;

@RestController
@RequestMapping("/")

public class ConfigMasterController {
	@Autowired
	private ConfigMasterService configService;
	@Autowired
	private ConfigMasterRepository configRepository;

	@GetMapping("getConfigAll")
	public List<ConfigMaster> getAllConfig() {
		return configRepository.findAll();

	}

	@PostMapping("saveConfig")
	public ResponseEntity<Object> addConfig(@RequestBody ConfigMaster config) throws Exception {
		return configService.addConfig(config);
	}

	@PutMapping("updateConfig")
	public ResponseEntity<Object> updateConfig(@RequestBody ConfigMaster config,
			@RequestParam(value = "masterId",required=true) long masterId) throws Exception {
		return configService.updateConfig(config, masterId);
	}

	@DeleteMapping("deleteConfig/{masterId}")
	public ResponseEntity<?> deleteConfig(@PathVariable(value = "masterId") long masterId)throws Exception {
		return configService.deleteConfig(masterId);

	}

}
