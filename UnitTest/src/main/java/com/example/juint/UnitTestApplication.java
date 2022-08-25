package com.example.juint;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestApplication {
	
	String checkRef = "Prashant";
	
	String checkRef2= checkRef;

	String diffStr = "Ram";
	
	public static void main(String[] args) {
		SpringApplication.run(UnitTestApplication.class, args);
	}
	
	
	public int add(int a , int b) {
		return a+b;
	}
	
	public Object checkForNull(String testStr) {
		
		Optional<String> str = Optional.ofNullable(testStr);
		if(str.isPresent())
			return testStr;
		else
			return null;
	}
	
	public String checkRef() {
		return checkRef;
		
	}

	
	public String checkRef2() {
		return checkRef2;
	}
	
	public String diffStr() {
		return diffStr;
	}
	
	
	public boolean checkForValue(int a , int b){
		
	
		if(a == b) {
			return true;
		}
		
		return false ;
	}
	
}
