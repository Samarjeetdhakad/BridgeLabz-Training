package com.searchingfilereaderstringbuffer.stringbuilder;

import java.util.*;
public class ReverseString {
	public static void main(String[]args) {
Scanner sc=new Scanner(System.in);

String s=sc.nextLine();
StringBuilder sb=new StringBuilder();
sb.append(s);
sb.reverse();
String reversedString = sb.toString();

System.out.println("Reversed String: " + reversedString);
}
}