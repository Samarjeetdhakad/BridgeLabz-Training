package com.searchingfilereaderstringbuffer.stringbuffer;

import java.util.*;
public class ConcatenateString {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String []arr= new String[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter line");
			arr[i]=sc.nextLine();
		}
		StringBuffer sb=new StringBuffer();
		for(String str:arr) {
			sb.append(str);
		}
		System.out.println("concatenated string :" + sb.toString());
	}

}