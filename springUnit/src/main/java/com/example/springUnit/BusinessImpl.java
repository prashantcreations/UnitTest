package com.example.springUnit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessImpl {
	
	private DataService dataService;
	
	public int calculatSum(int[] data) {
		List<Integer> listInt= Arrays.stream(data).boxed().collect(Collectors.toList());
		int num = listInt.stream().reduce(0,(sum,ele)->sum+ele);
		return num;
	}
	
	public int calculatSumFromAnotherClass() {
		int[] data= dataService.reteriveAllData();
		List<Integer> listInt= Arrays.stream(data).boxed().collect(Collectors.toList());
		int num = listInt.stream().reduce(0,(sum,ele)->sum+ele);
		return num;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	

}
