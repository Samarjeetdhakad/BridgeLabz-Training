package com.collections.setinterface;

import java.util.*;

public class CompareSets {
	public static void main(String[]args) {
		Set<Integer> set1 = new HashSet<>(Arrays.asList(11,12,13,14));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(12,13,14,11));
		 boolean isEqual = set1.equals(set2);
		 System.out.println(isEqual);
	}
}
