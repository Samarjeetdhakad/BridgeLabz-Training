package trafficmanager;

import java.util.LinkedList;
import java.util.Queue;

public class WaitingQueue {

    private Queue<String> queue;
    private int capacity;

     WaitingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    // Add vehicle 
    public void enqueue(String car) {
        if (queue.size() == capacity) {
            System.out.println(" Queue overflow Cannot add " + car);
            return;
        }
        queue.offer(car);
        System.out.println(" Waiting" + car);
    }

    // Remove vehicle from queue
    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println(" Queue underflow No vehicles waiting");
            return null;
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}