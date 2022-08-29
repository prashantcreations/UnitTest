package com.example.springUnit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Iteam;
import com.example.springRest.repo.Repo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	Repo repository;
	
	@Test
	public void sumData() {
		List<Iteam> iteamList = repository.findAll();
		System.out.println("====== "+iteamList);
		assertEquals(2,iteamList.size());
	}

}