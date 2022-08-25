package com.example.juint;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestApplication {

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

}
