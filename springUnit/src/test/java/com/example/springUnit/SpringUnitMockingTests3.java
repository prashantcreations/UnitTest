package com.example.springUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


// sub hard to maintaian for diffrent data that why mocking cam in picture





// all below mthod need to make three diffrent sub so diffent data

// some time need to add @RunWith
@SpringBootTest
class SpringUnitMockingTests3 {

//	DataService dataServiceMoc = mock(DataService.class);
// replace by 
	
	@Mock
	DataService dataServiceMoc;

//this ca nbe replcae by
	/*
	BusinessImpl bi = new BusinessImpl();
	@BeforeEach
	void setObject() {
		bi.setDataService(dataServiceMoc);

	}*/
	@InjectMocks
	BusinessImpl bi;
	
//that meansd in busees servcie we are adding data service moc
	
	
	

	@DisplayName("calcute sum")
	@Test
	void calcuteSumTest() {
		// set values as we did int[] {1,2,3}
		// when moc class method (i.e reteriveAllData) called thne return new int[] {1,2,3}
		when(dataServiceMoc.reteriveAllData()).thenReturn(new int[] {1,2,3});
		int actual= bi.calculatSumFromAnotherClass();
		int expected = 6;
		assertEquals(expected,actual);
	
	}
	@DisplayName("calcute empty")
	@Test
	void calcuteSumEmpy() {
		when(dataServiceMoc.reteriveAllData()).thenReturn(new int[] {});
		bi.setDataService(dataServiceMoc);
		int actual= bi.calculatSumFromAnotherClass();
		int expected = 0;
		assertEquals(expected,actual);
	
	}
	@DisplayName("calcute single")
	@Test
	void calcuteSumSingle() {
		when(dataServiceMoc.reteriveAllData()).thenReturn(new int[] {5});
		bi.setDataService(dataServiceMoc);
		int actual= bi.calculatSumFromAnotherClass();
		int expected = 5;
		assertEquals(expected,actual);
	
	}

}
