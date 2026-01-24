package com.collections.reverse;

//reverse list by implementing Linked List 

import java.util.LinkedList;
import java.util.Arrays;


public class ReverseLinkedList {
		
	public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list){
		LinkedList<Integer> reversed = new LinkedList<>();
		
		for(Integer x: list) {
			reversed.addFirst(x);
		}
		return reversed;
		
	}
	
	public static void main(String[]args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> result = reverseLinkedList(list);
        System.out.println("reversed list is: "+ result);
	}

}
