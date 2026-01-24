package com.collections;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class RotateList {
	public static void main(String[]args) {
		List<Integer> list =Arrays.asList(12,13,14,15,16);
		List<Integer> rotatedList = new ArrayList<>();
		int k =2;
		
		rotatedList.addAll(list.subList(k, list.size()));
		rotatedList.addAll(list.subList(0, k));
		
		// Collections.rotate(list, -2); can use this also
		
		System.out.println("rotated lists by 2: "+ rotatedList);
		
		
	
	}

}
