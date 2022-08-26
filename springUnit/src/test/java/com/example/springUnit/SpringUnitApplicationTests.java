package com.example.springUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringUnitApplicationTests {

	@DisplayName("calcute sum")
	@Test
	void calcuteSumTest() {
		BusinessImpl bi = new BusinessImpl();
		int actual= bi.calculatSum(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected,actual);
	
	}
	
	@DisplayName("emply array sum")
	@Test
	void calcuteEmpty() {
		BusinessImpl bi = new BusinessImpl();
		int actual= bi.calculatSum(new int[] {});
		int expected = 0;
		assertEquals(expected,actual);
	
	}
	
	@DisplayName("single element in array")
	@Test
	void calcuteSingleEle() {
		BusinessImpl bi = new BusinessImpl();
		int actual= bi.calculatSum(new int[] {5});
		int expected = 5;
		assertEquals(expected,actual);
	
	}

}
