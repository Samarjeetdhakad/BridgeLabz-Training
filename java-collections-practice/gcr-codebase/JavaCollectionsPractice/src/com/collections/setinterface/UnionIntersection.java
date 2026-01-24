package com.collections.setinterface;

import java.util.*;

public class UnionIntersection {
	public static void main(String[]args) {
		Set<Integer>set1 = new HashSet<>(Arrays.asList(11,12,13));
		Set<Integer>set2 = new HashSet<>(Arrays.asList(11,13,15,17));
		
		Set<Integer> union = new LinkedHashSet<>(set1);
		union.addAll(set2);
		
		Set<Integer> intersection = new LinkedHashSet<>(set1);
		intersection.retainAll(set2);
		
		System.out.println(union);
		System.out.println(intersection);

		
		
	}

}
