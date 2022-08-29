package com.example.springUnit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.model.Iteam;
import com.example.springRest.SpringRestController;
import com.example.springRest.Business.BusinessService;
import com.example.springRest.repo.Repo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SpringRestController.class)
public class SpringControllerTest {

	@Autowired
	MockMvc mocMvc;
	
	@MockBean
	BusinessService businessService;
	
	@MockBean
	Repo repo;
	
	@Test
	public void helloWordTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result= mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("hello world"))
				.andReturn();
		
		assertEquals("hello world", result.getResponse().getContentAsString());
	}
	
	@Test
	public void jsonTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummyJSAON")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result= mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"prashant\",\"prize\":10,\"quantity\":100}"))
				.andReturn();
		
		//assertEquals("hello world", result.getResponse().getContentAsString());
	}

	
	@Test
	void jsonAssetExp() throws JSONException {
		String expectedRes = "{\"id\":1,\"name\":\"prashant\",\"prize\":10,\"quantity\":100}";
		String actualRes = "{\"id\":1,  \"name\":\"prashant\",\"prize\":10,\"quantity\":100}";
		//JSONAssert.assertEquals(expectedRes, actualRes, false);// false it will not excat match 
		//JSONAssert.assertEquals(expectedRes, actualRes, true);// true it will do excat match
		JSONAssert.assertEquals(expectedRes, actualRes, true);
		
	}
	
	@Test
	void FromBusnieesLayesWitEscapChar() throws Exception {
	
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/business")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result= mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1,name:prashant,prize:10,quantity:100}"))
				.andReturn();
		
		//assertEquals("hello world", result.getResponse().getContentAsString());
	}
	
	@Test
	void retiveFromDB() throws Exception {
		
		when(businessService.reteriveAll()).thenReturn(Arrays.asList(new Iteam(1,"A",10,100)));
	
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/fromdb")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result= mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"name\":\"A\",\"prize\":10,\"quantity\":100,\"value\":0}]"))
				.andReturn();
		
		//assertEquals("hello world", result.getResponse().getContentAsString());
	}
	
	
	
	
}