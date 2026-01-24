package com.collections.reverse;
// reversing the list by implementing arraylist 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayList {
	
	public static void reverseList(List<Integer> list) {
		int left = 0 ;
		int right = list.size()-1;
		
		while(left<right) {
			int temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			left++;
			right--;
		}
		
	}

	public static void main(String[] args) {
		
		List<Integer> arrayList = new ArrayList<>(Arrays.asList(3,5,2,6,4));
		
		reverseList(arrayList);
		System.out.println("reverse list using arraylist: " + arrayList);		
	}
}
