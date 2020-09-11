package com.rubix.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.SsGroup;
import com.rubix.inventorymanagement.domain.SsUser;
import com.rubix.inventorymanagement.exception.ProductException;
import com.rubix.inventorymanagement.repository.SsGroupRepository;
import com.rubix.inventorymanagement.repository.SsUserRepository;

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

	public ResponseEntity<Object> createUser(SsUser user, long groupId) throws Exception, ProductException {
		SsGroup groups = groupRepository.findByGroupId(groupId);
		if (groups == null) {
			throw new ProductException("Group ID not Found");
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
			throws Exception, ProductException {
		SsGroup groups = groupRepository.findByGroupId(groupId);
		SsUser users = userRepository.findByUserId(userId);
		if (groups == null || users == null) {
			throw new ProductException("No Users  found with this ID");
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

	public ResponseEntity<?> deleteUser(long groupId, long userId) {

		SsUser users = userRepository.findByGroupIdAndUserId(groupId, userId);
		if (users == null) {
			return ResponseEntity.unprocessableEntity().body("No Group ID found with User ID");
		} else {

			userRepository.delete(users);
			return ResponseEntity.ok("User Deleted");
		}
	}

}
