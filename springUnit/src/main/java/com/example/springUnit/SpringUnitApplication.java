package com.example.springUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.springRest.Business.BusinessService;

@EntityScan("com.example.model")
@SpringBootApplication()
@ComponentScan("com.example.springRest")
@EnableJpaRepositories("com.example.springRest.repo")
public class SpringUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUnitApplication.class, args);
	}

}
