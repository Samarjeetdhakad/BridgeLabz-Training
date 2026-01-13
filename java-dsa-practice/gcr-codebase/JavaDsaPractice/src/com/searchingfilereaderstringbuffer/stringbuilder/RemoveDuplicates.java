package com.searchingfilereaderstringbuffer.stringbuilder;

import java.util.*;

public class RemoveDuplicates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(!set.contains(ch)) {
				set.add(ch);
				sb.append(ch);
			}
		}

		System.out.println(sb.toString());
	}
}