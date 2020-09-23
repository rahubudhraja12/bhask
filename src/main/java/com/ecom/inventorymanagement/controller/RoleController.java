package com.ecom.inventorymanagement.controller;

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

import com.ecom.inventorymanagement.domain.Address;
import com.ecom.inventorymanagement.domain.Customer;
import com.ecom.inventorymanagement.domain.SsGroup;
import com.ecom.inventorymanagement.domain.SsRole;
import com.ecom.inventorymanagement.domain.SsUser;
import com.ecom.inventorymanagement.service.AddressService;
import com.ecom.inventorymanagement.service.CustomerService;
import com.ecom.inventorymanagement.service.SsGroupService;
import com.ecom.inventorymanagement.service.SsRoleService;
import com.ecom.inventorymanagement.service.SsUserService;

@RestController
@RequestMapping("/")
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

	@PostMapping("saveRole")
	public ResponseEntity<Object> addRoles(@RequestBody SsRole role) throws Exception {
		return roleService.createRole(role);
	}

	@PutMapping("updateRole")
	public ResponseEntity<Object> updateRoles(@RequestBody SsRole role,
			@RequestParam(value = "roleId", required = true) Long roleId) throws Exception {
		return roleService.updateRole(role, roleId);
	}

	@DeleteMapping("deleteRole/{roleId}")
	public ResponseEntity<?> deleteRoles(@PathVariable(value = "roleId") Long roleId)throws Exception {
		return roleService.deleteRole(roleId);
	}

	@GetMapping("getRoleAll")
	public List<SsRole> getAllRoles() {
		return roleService.getRoles();
	}

	@PostMapping("saveGroup")
	public ResponseEntity<Object> addGroups(@RequestBody SsGroup group,
			@RequestParam(value = "roleId", required = true) Long roleId) throws Exception {
		return groupService.createGroup(group, roleId);
	}

	@PutMapping("updateGroup")
	public ResponseEntity<Object> updateGroups(@RequestBody SsGroup group,
			@RequestParam(value = "roleId", required = true) Long roleId, @RequestParam(value = "groupId") Long groupId)
			throws Exception {
		return groupService.updateGroup(group, roleId, groupId);
	}

	@DeleteMapping("deleteGroup/{roleId}/{groupId}")
	public ResponseEntity<?> deleteGroups(@PathVariable(value = "roleId") Long roleId,
			@PathVariable(value = "groupId") Long groupId)throws Exception {
		return groupService.deleteGroup(roleId, groupId);
	}

	@GetMapping("getGroupAll")
	public List<SsGroup> getAllGroups() {
		return groupService.getGroups();
	}

	@PostMapping("saveUser")
	public ResponseEntity<Object> addUser(@RequestBody SsUser user,
			@RequestParam(value = "groupId", required = true) Long groupId) throws Exception {
		return userService.createUser(user, groupId);
	}

	@PutMapping("updateUser")
	public ResponseEntity<Object> updateUsers(@RequestBody SsUser user,
			@RequestParam(value = "groupId", required = true) Long groupId, @RequestParam(value = "userId") Long userId)
			throws Exception {
		return userService.updateUser(user, groupId, userId);
	}

	@DeleteMapping("deleteUser/{groupId}/{userId}")
	public ResponseEntity<?> deleteUsers(@PathVariable(value = "groupId") Long groupId,
			@PathVariable(value = "userId") Long userId) throws Exception{
		return userService.deleteUser(groupId, userId);
	}

	@GetMapping("/getUserAll")
	public List<SsUser> getAllUsers() {
		return userService.getUser();
	}

	@PostMapping("saveAddress")
	public ResponseEntity<Object> addAddress(@RequestBody Address address,
			@RequestParam(value = "userId", required = true) Long userId) throws Exception {
		return addressService.createAddress(address, userId);
	}

	@PutMapping("updateAddress")
	public ResponseEntity<Object> updateAddress(@RequestBody Address address,
			@RequestParam(value = "userId") Long userId,
			@RequestParam(value = "addressId", required = true) Long addressId) throws Exception {
		return addressService.updateAddress(address, userId, addressId);
	}

	@DeleteMapping("deleteAddress/{userId}/{addressId}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "addressId") Long addressId)throws Exception {
		return addressService.deleteAddress(userId, addressId);
	}

	@GetMapping("getAddressAll")
	public List<Address> getAllAddress() {
		return addressService.getAddress();
	}

	@PostMapping("saveCustomer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer,
			@RequestParam(value = "addressId", required = true) Long addressId) throws Exception {
		return customerService.addCustomer(customer, addressId);
	}

	@PutMapping("updateCustomer")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,
			@RequestParam(value = "addressId", required = true) Long addressId,
			@RequestParam(value = "customerId", required = true) Long customerId) throws Exception {
		return customerService.updateCustomer(customer, addressId, customerId);
	}

	@DeleteMapping("deleteCustomer/{addressId}/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "customerId") Long customerId,
			@RequestParam(value = "addressId", required = true) Long addressId)throws Exception {
		return customerService.deleteCustomer(addressId, customerId);
	}

	@GetMapping("getCustomersAll")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomer();
	}

}
