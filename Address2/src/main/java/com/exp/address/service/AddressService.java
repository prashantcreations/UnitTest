package com.exp.address.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.address.domain.Address;
import com.exp.address.repo.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	AddressRepo addressRepo;

	public Optional<Address> findById(int id) {
		// TODO Auto-generated method stub
		
		return addressRepo.findById(id);
		
	}

}
