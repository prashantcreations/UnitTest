package com.example.springUnit;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SpringControllerTest.class)
public class SpringControllerTest {

	@Autowired
	MockMvc mocMvc;
	
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

	
	
}