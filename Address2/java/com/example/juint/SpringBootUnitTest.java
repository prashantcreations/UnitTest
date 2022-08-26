package com.example.juint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SpringBootUnitTest {
	
	@Autowired
	Student student;
	
	@Autowired
	ApplicationContext context;
	
	@BeforeEach
	void intialValueforEach(){
		student.address="Pune Guna";
		student.name="Prashant";
		student.id=2034695;
	}

	@DisplayName("Check for student equal")	
	@Test
	void basicTest(){
		
		assertEquals("Prashant",student.getName(),"name must be prashant ");
	}
	
	// same ca ndo assertrye assertfalse and assertnitnull
	
	void addSecStudentandCheck() {
		Student sTwo= context.getBean(Student.class);
		sTwo.setAddress("guna indre");
		sTwo.setName("RAM");
		sTwo.setId(473001);
		
		
		
		//assertNotSame(student,sTwo);
		//assertSame(test.checkRef(), test.checkRef2(),"both are same");
	
		assertNotSame(student,sTwo,"both are not same ");

		
		
	}
	

}
