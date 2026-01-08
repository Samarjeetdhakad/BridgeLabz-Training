package com.stackqueuehashmapandhashingfunction.stackandqueues;

import java.util.Stack;

class QueueUsingTwoStacks {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void enqueue(int data) {
        inStack.push(data);
    }

    public int dequeue() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    // Peek front element
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return outStack.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
