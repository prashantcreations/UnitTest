package com.exp.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.address.domain.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{

}
