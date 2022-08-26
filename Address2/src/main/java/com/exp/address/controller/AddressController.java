package com.exp.address.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exp.address.domain.Address;
import com.exp.address.repo.AddressRepo;
import com.exp.address.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	AddressService addressService;
	
	
	@GetMapping("/address/{id}")
	ResponseEntity<Address> getAddress(@PathVariable("id") int id){
		System.out.println("in second instance");
		
		//Optional<Address> address= 
		Optional<Address> address= addressService.findById(id);
		
		if(address.isPresent()) {
		return new ResponseEntity<Address>(address.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Address>(new Address(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addAddress")
	ResponseEntity<Address> addAddress(@RequestBody Address address){
		return new ResponseEntity<Address>(addressRepo.save(address),HttpStatus.OK);
		
	}

}
