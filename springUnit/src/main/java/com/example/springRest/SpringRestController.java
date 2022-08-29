package com.example.springRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Iteam;
import com.example.springRest.Business.BusinessService;

@RestController
public class SpringRestController {

	@Autowired
	BusinessService businessService;

	@GetMapping("/hello")
	public String hellpWord() {
		return "hello world";
	}
	
	@GetMapping("/dummyJSAON")
	public Iteam dummyJSON() {
		return new Iteam(1,"prashant",10,100);
	}
	
	@GetMapping("/business")
	public Iteam iteamFromBusinessSerivces() {
		Iteam item =businessService.retiveIteam();
		return item;
	}

	@GetMapping("/fromdb")
	public List<Iteam> iteamFromDb() {
		List<Iteam> itemList =businessService.reteriveAll();
		return itemList;
	}
	
}
