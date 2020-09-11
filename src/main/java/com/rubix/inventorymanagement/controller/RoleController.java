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
import org.springframework.web.bind.annotation.RestController;

import com.rubix.inventorymanagement.domain.Address;
import com.rubix.inventorymanagement.domain.Customer;
import com.rubix.inventorymanagement.domain.SsGroup;
import com.rubix.inventorymanagement.domain.SsRole;
import com.rubix.inventorymanagement.domain.SsUser;
import com.rubix.inventorymanagement.service.AddressService;
import com.rubix.inventorymanagement.service.CustomerService;
import com.rubix.inventorymanagement.service.SsGroupService;
import com.rubix.inventorymanagement.service.SsRoleService;
import com.rubix.inventorymanagement.service.SsUserService;

@RestController
@RequestMapping("inventory")
public class RoleController {
	@Autowired
	private SsRoleService roleService;
	@Autowired
	private SsGroupService groupService;
	@Autowired
	private SsUserService userService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CustomerService customerService;

	@PostMapping("/role")
	public ResponseEntity<Object> addRoles(@RequestBody SsRole role) throws Exception {
		return roleService.createRole(role);
	}

	@PutMapping("/role/{roleId}")
	public ResponseEntity<Object> updateRoles(@RequestBody SsRole role, @PathVariable(value = "roleId") Long roleId)
			throws Exception {
		return roleService.updateRole(role, roleId);
	}

	@DeleteMapping("/role/{roleId}")
	public ResponseEntity<?> deleteRoles(@PathVariable(value = "roleId") Long roleId) {
		return roleService.deleteRole(roleId);
	}

	@GetMapping("/getRoles")
	public List<SsRole> getAllRoles() {
		return roleService.getRoles();
	}

	@PostMapping("/role/{roleId}/group")
	public ResponseEntity<Object> addGroups(@RequestBody SsGroup group, @PathVariable(value = "roleId") Long roleId)
			throws Exception {
		return groupService.createGroup(group, roleId);
	}

	@PutMapping("/role/{roleId}/group/{groupId}")
	public ResponseEntity<Object> updateGroups(@RequestBody SsGroup group, @PathVariable(value = "roleId") Long roleId,
			@PathVariable(value = "groupId") Long groupId) throws Exception {
		return groupService.updateGroup(group, roleId, groupId);
	}

	@DeleteMapping("/role/{roleId}/group/{groupId}")
	public ResponseEntity<?> deleteGroups(@PathVariable(value = "roleId") Long roleId,
			@PathVariable(value = "groupId") Long groupId) {
		return groupService.deleteGroup(roleId, groupId);
	}

	@GetMapping("/getGroups")
	public List<SsGroup> getAllGroups() {
		return groupService.getGroups();
	}

	@PostMapping("/group/{groupId}/user")
	public ResponseEntity<Object> addUser(@RequestBody SsUser user, @PathVariable(value = "groupId") Long groupId)
			throws Exception {
		return userService.createUser(user, groupId);
	}

	@PutMapping("/group/{groupId}/user/{userId}")
	public ResponseEntity<Object> updateUsers(@RequestBody SsUser user, @PathVariable(value = "groupId") Long groupId,
			@PathVariable(value = "userId") Long userId) throws Exception {
		return userService.updateUser(user, groupId, userId);
	}

	@DeleteMapping("/group/{groupId}/user/{userId}")
	public ResponseEntity<?> deleteUsers(@PathVariable(value = "groupId") Long groupId,
			@PathVariable(value = "userId") Long userId) {
		return userService.deleteUser(groupId, userId);
	}

	@GetMapping("/getUsers")
	public List<SsUser> getAllUsers() {
		return userService.getUser();
	}

	@PostMapping("/user/{userId}/address")
	public ResponseEntity<Object> addAddress(@RequestBody Address address, @PathVariable(value = "userId") Long userId)
			throws Exception {
		return addressService.createAddress(address, userId);
	}

	@PutMapping("/user/{userId}/address/{addressId}")
	public ResponseEntity<Object> updateAddress(@RequestBody Address address,
			@PathVariable(value = "userId") Long userId, @PathVariable(value = "addressId") Long addressId)
			throws Exception {
		return addressService.updateAddress(address, userId, addressId);
	}

	@DeleteMapping("/user/{userId}/address/{addressId}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "addressId") Long addressId) {
		return addressService.deleteAddress(userId, addressId);
	}

	@GetMapping("/getAddress")
	public List<Address> getAllAddress() {
		return addressService.getAddress();
	}

	@PostMapping("/user/{userId}/address/{addressId}/customer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer,
			@PathVariable(value = "userId") Long userId, @PathVariable(value = "addressId") Long addressId)
			throws Exception {
		return customerService.addCustomer(customer, userId, addressId);
	}

	@PutMapping("/user/{userId}/address/{addressId}/customer/{customerId}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,
			@PathVariable(value = "userId") Long userId, @PathVariable(value = "addressId") Long addressId,
			@PathVariable(value = "customerId") Long customerId) throws Exception {
		return customerService.updateCustomer(customer, userId, addressId, customerId);
	}

	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "customerId") Long customerId) {
		return customerService.deleteCustomer(customerId);
	}

	@GetMapping("/getCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomer();
	}

}
