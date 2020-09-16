package com.rubix.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.SsGroup;
import com.rubix.inventorymanagement.domain.SsRole;
import com.rubix.inventorymanagement.exception.IdNotFoundException;
import com.rubix.inventorymanagement.repository.SsGroupRepository;
import com.rubix.inventorymanagement.repository.SsRoleRepository;

@Service
public class SsGroupService {
	@Autowired
	private SsRoleRepository roleRepository;
	@Autowired
	private SsGroupRepository groupRepository;

	public List<SsGroup> getGroups() {
		List<SsGroup> groups = groupRepository.findAll();
		return groups;
	}

	public ResponseEntity<Object> createGroup(SsGroup group, long roleId) throws Exception, IdNotFoundException {
		SsRole roles = roleRepository.findByRoleId(roleId);
		if (roles == null) {
			throw new IdNotFoundException("Role ID not Found");
		} else {
			SsGroup groups = new SsGroup();
			BeanUtils.copyProperties(group, groups, "ssRole", "ssUser");
			groups.setSsRole(roles);
			SsGroup savedgroup = groupRepository.save(groups);
			SsGroup groupExist = groupRepository.findByGroupId(savedgroup.getGroupId());
			if (groupExist != null)
				return ResponseEntity.ok("Group Created");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to create Group");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateGroup(SsGroup group, long roleId, long groupId)
			throws Exception, IdNotFoundException {
		SsRole roles = roleRepository.findByRoleId(roleId);
		SsGroup groups = groupRepository.findByGroupId(groupId);
		if (roles == null || groups == null) {
			throw new IdNotFoundException("No groups found with this ID");
		} else {

			BeanUtils.copyProperties(group, groups, "ssRole", "ssUser");
			groups.setSsRole(roles);
			groups.setGroupId(groupId);
			SsGroup savedgroup = groupRepository.save(groups);
			SsGroup groupExist = groupRepository.findByGroupId(savedgroup.getGroupId());
			if (groupExist != null)
				return ResponseEntity.ok("Group Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Group");
		}

	}

	public ResponseEntity<?> deleteGroup(long roleId, long groupId)throws Exception, IdNotFoundException  {

		SsGroup groups = groupRepository.findByRoleIdAndGroupId(roleId, groupId);
		if (groups == null) {
			throw new IdNotFoundException("No Group ID found with Role ID");
		} else {

			groupRepository.delete(groups);
			return ResponseEntity.ok("Group Deleted");
		}
	}

}
