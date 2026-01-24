package com.collections.queueinterface;

import java.util.*;

// reverse the queue

public class Reverse {
	public static void main(String[]args) {
	Queue<Integer> queue = new LinkedList<>(Arrays.asList(11,12,13,14));
	Stack<Integer> stack = new  Stack<>();
	
	while(!queue.isEmpty()) {
		stack.push(queue.remove());
	}
	
	while(!stack.isEmpty()) {
		queue.add(stack.pop());
	}
	
	System.out.println(queue);
	
  }
}
