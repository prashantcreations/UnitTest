package com.example.springUnit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.autoconfigure.condition.ConditionMessage.ItemsBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.Iteam;
import com.example.springRest.Business.BusinessService;
import com.example.springRest.repo.Repo;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestService {
	
	@InjectMocks
	BusinessService businessService;
	
	@Mock
	Repo repository;
	
	@Test
	public void sumData() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Iteam(1,"A",10,100)));//expected 
		List<Iteam> list= businessService.reteriveAll(); // getting 
		assertEquals(1000, list.get(0).getValue());
	}

}
