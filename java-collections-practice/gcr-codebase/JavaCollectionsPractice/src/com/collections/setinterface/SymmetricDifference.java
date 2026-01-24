package com.collections.setinterface;

import java.util.*;

public class SymmetricDifference {
	public static void main(String[]args) {

		Set<Integer>set1 = new HashSet<>(Arrays.asList(11,12,13));
		Set<Integer>set2 = new HashSet<>(Arrays.asList(11,13,15,17));
		
		Set<Integer> result = new LinkedHashSet<>(set1);
		result.addAll(set2);
		
		Set<Integer> intersection = new LinkedHashSet<>(set1);
		intersection.retainAll(set2);
		
		result.removeAll(intersection);
		
		System.out.println(result);
		
		

		
		
		
	}

}
