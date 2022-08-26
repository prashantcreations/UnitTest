package com.example.springUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.example.springRest")
public class SpringUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUnitApplication.class, args);
	}

}
