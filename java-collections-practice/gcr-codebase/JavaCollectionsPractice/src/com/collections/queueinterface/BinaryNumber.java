package com.collections.queueinterface;

//generate binary number using queue

import java.util.*;

public class BinaryNumber {
	public static void main(String[]args) {
	int n=10;
	
	List<String> result = generateBinary(n);
	System.out.println(result);
	}
	
	public static List<String> generateBinary(int n ){
		List<String> result = new ArrayList<>();
		
		if(n<=0) return result;
		
		Queue<String> queue = new LinkedList<>();
		queue.add("1");
		
		for (int i=0; i <n; i++) {
			String current = queue.remove();
			result.add(current);
			queue.add(current + "0");
			queue.add(current + "1");
		}
		return result;	
	}
	

}
