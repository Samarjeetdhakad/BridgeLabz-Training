package com.searchingfilereaderstringbuffer.linearsearch;

import java.util.*;
public class SearchWord {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
	    sc.nextLine();
		String s[]=new String[n];

		for(int i=0;i<n;i++) {
			s[i]=sc.nextLine();
		}
		String word=sc.nextLine();
		String index=" ";
		for(int i=0;i<s.length;i++) {
			if(s[i].contains(word)) {
				index=s[i];
				break;
		}
		}
		if(index !=" ") {
			System.out.println(index);
		}
		else {
			System.out.println("not found");
		}
		
	}

}