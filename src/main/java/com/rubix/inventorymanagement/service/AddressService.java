package com.rubix.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.inventorymanagement.domain.Address;
import com.rubix.inventorymanagement.domain.SsUser;
import com.rubix.inventorymanagement.exception.IdNotFoundException;
import com.rubix.inventorymanagement.repository.AddressRepository;
import com.rubix.inventorymanagement.repository.SsUserRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private SsUserRepository userRepository;

	public List<Address> getAddress() {
		List<Address> address = addressRepository.findAll();
		return address;
	}

	public ResponseEntity<Object> createAddress(Address address, long userId) throws Exception, IdNotFoundException {
		SsUser users = userRepository.findByUserId(userId);
		if (users == null) {
			throw new IdNotFoundException("User ID not Found");
		} else {
			Address addresses = new Address();
			BeanUtils.copyProperties(address, addresses, "ssUser", "customer");
			addresses.setSsUser(users);
			Address savedAddress = addressRepository.save(addresses);
			Address addressExist = addressRepository.findByAddressId(savedAddress.getAddressId());
			if (addressExist != null)
				return ResponseEntity.ok("Address Added");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to create Address");
		}
	}

	@Transactional
	public ResponseEntity<Object> updateAddress(Address address, long userId, long addressId)
			throws Exception, IdNotFoundException {
		SsUser users = userRepository.findByUserId(userId);
		Address addresses = addressRepository.findByAddressId(addressId);
		if (users == null || addresses == null) {
			throw new IdNotFoundException("No Address  found with this ID");
		} else {
			BeanUtils.copyProperties(address, addresses, "ssUser", "customer");
			addresses.setSsUser(users);
			addresses.setAddressId(addressId);
			Address savedAddress = addressRepository.save(addresses);
			Address addressExist = addressRepository.findByAddressId(savedAddress.getAddressId());
			if (addressExist != null)
				return ResponseEntity.ok("Address Updated");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update Address");
		}

	}

	public ResponseEntity<?> deleteAddress(long userId, long addressId)throws Exception, IdNotFoundException {

		Address address = addressRepository.findByUserIdAndAddressId(userId, addressId);
		if (address == null) {
			throw new IdNotFoundException("No Address ID found with User ID");
		} else {

			addressRepository.delete(address);
			return ResponseEntity.ok("Address Deleted");
		}
	}

}
