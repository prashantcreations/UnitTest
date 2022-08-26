package com.example.springUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;


// sub hard to maintaian for diffrent data that why mocking cam in picture


class DataServiceStub implements DataService{

	@Override
	public int[] reteriveAllData() {
		return new int[] {1,2,3};
	}
	
}class DataServiceStub2 implements DataService{

	@Override
	public int[] reteriveAllData() {
		return new int[] {};
	}
	
}class DataServiceStub3 implements DataService{

	@Override
	public int[] reteriveAllData() {
		return new int[] {5};
	}
	
}


// all below mthod need to make three diffrent sub so diffent data


@SpringBootTest
class SpringUnitStubTests2 {

	@DisplayName("calcute sum")
	@Test
	void calcuteSumTest() {
		BusinessImpl bi = new BusinessImpl();
		bi.setDataService(new DataServiceStub());
		int actual= bi.calculatSumFromAnotherClass();
		int expected = 6;
		assertEquals(expected,actual);
	
	}
	@DisplayName("calcute empty")
	@Test
	void calcuteSumEmpy() {
		BusinessImpl bi = new BusinessImpl();
		bi.setDataService(new DataServiceStub2());
		int actual= bi.calculatSumFromAnotherClass();
		int expected = 0;
		assertEquals(expected,actual);
	
	}
	@DisplayName("calcute single")
	@Test
	void calcuteSumSingle() {
		BusinessImpl bi = new BusinessImpl();
		bi.setDataService(new DataServiceStub3());
		int actual= bi.calculatSumFromAnotherClass();
		int expected = 5;
		assertEquals(expected,actual);
	
	}

}
