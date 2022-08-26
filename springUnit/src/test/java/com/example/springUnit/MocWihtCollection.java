package com.example.springUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * mokito limition
 * 1)cant mock static method , constructor , for this we have to add powermock dependancy and can do
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */


@SpringBootTest
public class MocWihtCollection {
	
//	List list= mock(List.class);
	
	@Mock
	List<String> listMoc;
	
	@Test
	void testList() {
		when(listMoc.size()).thenReturn(5);
		assertEquals(5,listMoc.size());;
	}
	@Test
	void returnMultipuleValue() {
		when(listMoc.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,listMoc.size());
		assertEquals(10,listMoc.size());
		
	}
	
	@Test
	void returnWithParam() {
		when(listMoc.get(0)).thenReturn("TCS");
		assertEquals("TCS",listMoc.get(0));
		
		// get(0) can mention specific index like get(1) get(2)
		
		when(listMoc.get(1)).thenReturn("PUNE");
		assertEquals("PUNE", listMoc.get(1));
	}
	
	@Test
	void passValue() {
		when(listMoc.get(anyInt())).thenReturn("TCS"); //anyInt(), AnyString ... decidethe type of param of method 
		assertEquals("TCS",listMoc.get(0));
		
		// get(0) can mention specific index like get(1) get(2)
		
		when(listMoc.get(1)).thenReturn("PUNE");
		assertEquals("PUNE", listMoc.get(1));
	}

	
	// specifc method get called ?
	@Test
	void methodWithCalled() {
		
		String value = listMoc.get(0);
		listMoc.size();
		
		//this will check the mock and see mentioned method get called or not  
		verify(listMoc).get(0); 
		verify(listMoc).size(); //size method called or not 
		
		verify(listMoc).get(anyInt());
		verify(listMoc,times(1)).get(anyInt());
		verify(listMoc,atLeast(1)).get(anyInt());
		verify(listMoc,atMost(2)).get(anyInt());
	}
	// specifc method with specific value  ?
	@Test
	void methodWithCalledWithValue() {
		
		listMoc.add("TCS");
		
		ArgumentCaptor<String> ac = ArgumentCaptor.forClass(String.class);
		
		verify(listMoc).add(ac.capture());
		assertEquals("TCS",ac.getValue());
		
		
		
	}
	
	// specifc method with specific value  ?
	@Test
	void methodWithCalledWithValueMulti() {
		
		listMoc.add("TCS");
		listMoc.add("Yash");
		
		ArgumentCaptor<String> ac = ArgumentCaptor.forClass(String.class);
		
		verify(listMoc,times(2)).add(ac.capture());
		//getAllValue 
		List<String> listofValue = ac.getAllValues(); /// <<<<<<<<===============
		
		assertEquals("TCS",listofValue.get(0)); 
		assertEquals("Yash",listofValue.get(1)); 
		
		
		
	}
	
	@Test
	public void spying() {
		
		List l = mock(ArrayList.class);
		l.add(1);
		l.add(1);
		l.add(1);
		System.out.println(l);
		System.out.println("size in mock "+l.size());
		
		// moc dont work on actual object that why after adding so many values still list size is 0
		
		List l2= spy(ArrayList.class);
		
		l2.add(1);
		l2.add(1);
		l2.add(1);
		System.out.println("size in mock "+l2.size());
		
		// varify will work same for spy
		
		
		
	}
	

}
