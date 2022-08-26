package com.example.springRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Iteam;

@RestController
public class SpringRestController {


	@GetMapping("/hello")
	public String hellpWord() {
		return "hello world";
	}
	
	@GetMapping("/dummyJSAON")
	public Iteam dummyJSON() {
		return new Iteam(1,"prashant",10,100);
	}
	
}
