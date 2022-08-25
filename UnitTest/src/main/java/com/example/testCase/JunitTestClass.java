package com.example.testCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.juint.UnitTestApplication;

public class JunitTestClass {
	
	/*life cycle methods
	 * 
	 * @BeforeEach : common setup call before each method 
	 * 
	 * @AfterEach : common clenup after each method
	 * 
	 * @BeforeAll : execute only once before all method
	 * 
	 * @AfterAll : execute only once after all method
	 * 
	 * 
	 * 
	 * 
	 * */
	
	UnitTestApplication test;
	
	@BeforeAll
	static void intiForAll() {
		System.out.println("in before all");
			
	}
	@AfterAll
	static void cleanForAll(){
		System.out.println("in after all");
		
	}
	
	@BeforeEach
	void intitValueEach() {
		
		System.out.println("in beforeeach");
		test = new UnitTestApplication();
	}
	
	@AfterEach
	void cleanForEach(){
		System.out.println("in after each");
		
	}
	

	@Test
	@DisplayName("checkAdd :integer equals or not equals")
	void checkAdd() {
		
		
		assertEquals(6,test.add(3, 3),"3+3 must be 6");
		assertNotEquals(7,test.add(3, 3),"3+3 must be 6");
	}
	
	@Test
	@DisplayName("checkForNullTest :string is not or not null")
	void checkForNullTest() {
		String s1= null;
		String s2 = "Prashant";
		
		UnitTestApplication test = new UnitTestApplication();
		assertNull(test.checkForNull(s1), "object should be null");
		assertNotNull(test.checkForNull(s2),"object should not be null");
	}
	
	@Test
	@DisplayName("checkRefrencesOfObject: check object refrecen is same ")
	void checkRefrencesOfObject(){
		
		assertSame(test.checkRef(), test.checkRef2(),"both are same");
		assertNotSame(test.checkRef(), test.diffStr(),"Refrences are not equals");
	}
	
	@Test
	@DisplayName("check for value")
	void checkForValue() {
		assertTrue(test.checkForValue(10, 10),"both are euqlas");
		assertFalse(test.checkForValue(10, 11),"both are not euqlas");
	}
	
}
