package com.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class RemoveDuplicates {
	public static void main(String[]args) {
		List<Integer> list = Arrays.asList(3,4,3,2,2,6,4);
		
		Set<Integer> remover = new LinkedHashSet<>(list);
		List<Integer> result = new ArrayList<>(remover);
		System.out.println("after removing duplicates list is  : " + result);
	}

}
