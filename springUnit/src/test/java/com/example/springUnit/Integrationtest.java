package com.example.springUnit;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import org.assertj.core.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Iteam;
import com.example.springRest.repo.Repo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Integrationtest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@MockBean
	Repo repo;
	
	/*if wnat to mock then can add @mockBean 
	 * @mockBean
	 * Repo repo
	 * 
	 * 		when(repo.findAll()).thenReturn(Arrays.asList(new Iteam(1,"A",10,100)));//expected 

	 * */

	@Test
	public void conectLoad() throws JSONException {
		
		String response = this.testRestTemplate.getForObject("/fromdb", String.class);
		JSONAssert.assertEquals("[{id:1},{id:2}]",response,false);
	}
	
}

