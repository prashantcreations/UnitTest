package com.example.testCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.example.juint.UnitTestApplication;

public class JunitTestClass {

	@Test
	void checkAdd() {
		
		UnitTestApplication test = new UnitTestApplication();
		assertEquals(6,test.add(3, 3),"3+3 must be 6");
		assertNotEquals(7,test.add(3, 3),"3+3 must be 6");
	}
	
	@Test
	void checkForNullTest() {
		String s1= null;
		String s2 = "Prashant";
		
		UnitTestApplication test = new UnitTestApplication();
		assertNull(test.checkForNull(s1), "object should be null");
		assertNotNull(test.checkForNull(s2),"object should not be null");
	}
}
