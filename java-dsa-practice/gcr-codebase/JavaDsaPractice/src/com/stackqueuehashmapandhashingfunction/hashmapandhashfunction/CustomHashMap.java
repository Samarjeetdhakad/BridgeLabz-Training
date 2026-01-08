package com.stackqueuehashmapandhashingfunction.hashmapandhashfunction;

class CustomHashMap {

    // Node for Linked List
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity = 10;
    private Node[] buckets;

    // Constructor
    public CustomHashMap() {
        buckets = new Node[capacity];
    }

    // Hash function
    private int getIndex(int key) {
        return Math.abs(key) % capacity;
    }

    // INSERT / UPDATE
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {     
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        // insert at beginning
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // RETRIEVE
    public Integer get(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key)
                return curr.value;
            curr = curr.next;
        }
        return null;
    }

    // DELETE
    public void remove(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null)
                    buckets[index] = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // DISPLAY HASH MAP
    public void display() {
        for (int i = 0; i < capacity; i++) {
            Node curr = buckets[i];
            if (curr != null) {
                System.out.print("Bucket " + i + ":");
                while (curr != null) {
                    System.out.print("[" + curr.key + "=" + curr.value + "] ");
                    curr = curr.next;
                }
                System.out.println();
            }
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        CustomHashMap map = new CustomHashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(1, 40); 

        System.out.println("Get key 1:" + map.get(1));
        System.out.println("Get key 2:" + map.get(2));

        map.remove(2);
        System.out.println("Get key 2 after removal:" + map.get(2));

        System.out.println("\nHash Map Structure:");
        map.display();
    }
}