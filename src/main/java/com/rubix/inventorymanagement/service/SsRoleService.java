package com.rubix.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.SsRole;
import com.rubix.inventorymanagement.repository.SsRoleRepository;

@Service
public class SsRoleService {
	@Autowired
	private SsRoleRepository ssRoleRepository;
	
	public List<SsRole> getRoles() {
		 List<SsRole> roles = ssRoleRepository.findAll();
		 return roles;
	}

	public ResponseEntity<Object> createRole(SsRole role) throws Exception {

		SsRole roles = new SsRole();
		BeanUtils.copyProperties(role, roles);

		SsRole savedrole = ssRoleRepository.save(roles);
		SsRole roleExist = ssRoleRepository.findByRoleId(savedrole.getRoleId());
		if (roleExist != null)
			return ResponseEntity.ok("Role Created");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to create Role");

	}

	@Transactional
	public ResponseEntity<Object> updateRole(SsRole role, long roleId) throws Exception {
		SsRole roles = new SsRole();
		roles = ssRoleRepository.findByRoleId(roleId);
		if (roles == null) {
			return ResponseEntity.unprocessableEntity().body(" Role  not found with this ID");
		} else {
			BeanUtils.copyProperties(role, roles);
			roles.setRoleId(roleId);
			SsRole savedrole = ssRoleRepository.save(roles);
			SsRole roleExist = ssRoleRepository.findByRoleId(savedrole.getRoleId());
			if (roleExist != null)
				return ResponseEntity.ok("Role Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Role");

		}

	}

	public ResponseEntity<?> deleteRole(long roleId) {

		SsRole roles = ssRoleRepository.findByRoleId(roleId);
		if (roles == null) {
			return ResponseEntity.unprocessableEntity().body("No Roles found with this ID");
		} else {
			ssRoleRepository.delete(roles);
			return ResponseEntity.ok("Role removed");
		}
	}

}
