package com.ecom.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.inventorymanagement.domain.SsGroup;
import com.ecom.inventorymanagement.domain.SsUser;
import com.ecom.inventorymanagement.exception.IdNotFoundException;
import com.ecom.inventorymanagement.repository.SsGroupRepository;
import com.ecom.inventorymanagement.repository.SsUserRepository;

@Service
public class SsUserService {

	@Autowired
	private SsGroupRepository groupRepository;
	@Autowired
	private SsUserRepository userRepository;

	public List<SsUser> getUser() {
		List<SsUser> users = userRepository.findAll();
		return users;
	}

	public ResponseEntity<Object> createUser(SsUser user, long groupId) throws Exception, IdNotFoundException {
		SsGroup groups = groupRepository.findByGroupId(groupId);
		if (groups == null) {
			throw new IdNotFoundException("Group ID not Found");
		} else {
			SsUser users = new SsUser();
			BeanUtils.copyProperties(user, users, "ssGroup", "address", "customer");
			users.setSsGroup(groups);
			SsUser savedusers = userRepository.save(users);
			SsUser usersExist = userRepository.findByUserId(savedusers.getUserId());
			if (usersExist != null)
				return ResponseEntity.ok("User Created");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to create User");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateUser(SsUser user, long groupId, long userId)
			throws Exception, IdNotFoundException{
		SsGroup groups = groupRepository.findByGroupId(groupId);
		SsUser users = userRepository.findByUserId(userId);
		if (groups == null || users == null) {
			throw new IdNotFoundException("No Users  found with this ID");
		} else {
			BeanUtils.copyProperties(user, users, "ssGroup", "address", "customer");
			users.setSsGroup(groups);
			users.setUserId(userId);
			SsUser savedusers = userRepository.save(users);
			SsUser usersExist = userRepository.findByUserId(savedusers.getUserId());
			if (usersExist != null)
				return ResponseEntity.ok("User Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update User");
		}

	}

	public ResponseEntity<?> deleteUser(long groupId, long userId)throws Exception, IdNotFoundException{

		SsUser users = userRepository.findByGroupIdAndUserId(groupId, userId);
		if (users == null) {
			throw new IdNotFoundException("No Group ID found with User ID");
		} else {

			userRepository.delete(users);
			return ResponseEntity.ok("User Deleted");
		}
	}

}
