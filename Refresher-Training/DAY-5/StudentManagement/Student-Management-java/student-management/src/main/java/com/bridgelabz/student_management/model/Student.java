package com.bridgelabz.student_management.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

    private int id;
    private String name;

    // Constructor Injection
    private Course course;

    // Setter Injection
    private Address address;

    // Field Injection
    @Autowired
    private Laptop laptop;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
        System.out.println("Constructor Injection Done");
    }

    public void setAddress(Address address) {
        this.address = address;
        System.out.println("Setter Injection Done");
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println();
        course.display();
        System.out.println();
        address.display();
        System.out.println();
        laptop.display();
    }

}