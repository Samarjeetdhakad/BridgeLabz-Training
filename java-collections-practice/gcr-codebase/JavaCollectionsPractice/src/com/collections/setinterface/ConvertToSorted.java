package com.collections.setinterface;

import java.util.*;

public class ConvertToSorted {
	public static void main(String[]args) {
		Set<Integer>set = new HashSet<>(Arrays.asList(11,12,43,23,9));
		List<Integer>sorted = new LinkedList<>(set);
		Collections.sort(sorted);
		
		System.out.print(sorted);
	}

}
