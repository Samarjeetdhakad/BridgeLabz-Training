package com.collections;
import java.util.*;

public class FindNthElement {
	public static void main(String[]args) {
        LinkedList<String> list=new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
         int n = 2;
          String result = findNth(list, n);	
          System.out.println(result);
	}
	
	 public static String findNth(LinkedList<String> list, int n){
		 
		 ListIterator<String> fast = list.listIterator();
		 ListIterator<String> slow = list.listIterator();
		 
		 for (int i=0; i <n; i++) {
			 if(!fast.hasNext()) {
				 throw new IllegalArgumentException("N is larger than the size of list");
			 }
			 fast.next();
		 }
		 
		 while(fast.hasNext()) {
			 fast.next();
			 slow.next();
		 }

		return slow.next();
		 
		 
		
	 }

}
