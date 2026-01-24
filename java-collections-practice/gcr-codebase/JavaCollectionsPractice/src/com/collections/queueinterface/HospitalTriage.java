package com.collections.queueinterface;

import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return other.severity - this.severity;
    }
}

public class HospitalTriage{ 
    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>();
        queue.add(new Patient("samar", 3));
        queue.add(new Patient("hariom", 5));
        queue.add(new Patient("kartik", 2));

        System.out.print("Treatment Order:");
        while (!queue.isEmpty()) {
            System.out.print(" " +queue.poll().name);
        }
    }
}
