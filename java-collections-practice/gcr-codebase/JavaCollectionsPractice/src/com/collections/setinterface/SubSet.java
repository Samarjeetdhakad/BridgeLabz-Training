package com.collections.setinterface;

import java.util.*;

public class SubSet {
	public static void main(String[]args) {
		Set<Integer>set1 = new HashSet<>(Arrays.asList(11,12));
		Set<Integer>set2 = new HashSet<>(Arrays.asList(11,12,15,17));

		boolean isSubset = set2.containsAll(set1);
		
		System.out.println(isSubset);
	}

}
