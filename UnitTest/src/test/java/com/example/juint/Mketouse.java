package com.example.juint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class Mketouse {

	@BeforeEach
	public void Init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Mock
	List<String> mocList;
	
	@Test
	void justTest() {
		
		//mocList.add("one");
		
		//Mockito.verify(mocList).add("one");
		
		assertEquals(0,mocList.size());
		
		Mockito.when(mocList.size()).thenReturn(100);
		assertEquals(100,mocList.size());
		
		
	
	}
}
