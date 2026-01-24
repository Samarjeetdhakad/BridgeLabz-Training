package com.collections;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
public class Frequency {

	public static void main(String[]args) {
		List<String> fruit = Arrays.asList("Apple","Banana","Apple","Mango","Mango");
		
		HashMap<String, Integer> frequencyMap = new HashMap<>();
		
		for(String fruits: fruit) {
			frequencyMap.put(fruits, frequencyMap.getOrDefault(fruits,0)+1);
			
		}
		
		System.out.println("frequncies of fruits: " + frequencyMap);
		
		
	}
}
