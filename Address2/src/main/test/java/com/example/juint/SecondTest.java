package com.example.juint2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

import com.exp.address.domain.Address;
import com.exp.address.repo.AddressRepo;
import com.exp.address.service.AddressService;


// test class package name and controller packge name is not same then have to mention package name externally
@SpringBootTest(classes = com.exp.address.controller.AddressController.class )
public class SecondTest {

	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Address address;
	
	@Mock
	private AddressRepo addRepo;
	
	@InjectMocks
	private AddressService addService;// this willl inject for @mock annotated varible only
	
	@BeforeEach
	public void beforeEach() {
		address.setId(1);
		address.setCity("Pune");
	}
	@Test
	void testMethod() {
		
		addRepo.findById(1);
		
	}


}
