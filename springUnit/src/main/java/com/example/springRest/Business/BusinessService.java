package com.example.springRest.Business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.Iteam;
import com.example.springRest.repo.Repo;

@Service
public class BusinessService {
	
	@Autowired
	Repo repo;

	public Iteam retiveIteam() {
		// TODO Auto-generated method stub
		return new Iteam(1,"prashant",10,100);
	}
	
	public List<Iteam> reteriveAll(){
		List<Iteam> iteam = repo.findAll();
		
		for(Iteam iteamI : iteam) {
			iteamI.setValue(iteamI.getPrize()*iteamI.getQuantity());
		}
				
		return repo.findAll();
		
	}

}
