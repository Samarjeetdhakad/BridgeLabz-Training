package com.bridgelabz.student_management.model;

import lombok.Data;

@Data
public class Student {
	    private int id;
	    private String name;
	    private int age;
	    
	    private Course course;
	    private Address address;

	    public Student(int id, String name, int age,  Course course,Address address) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.course = course;
	        this.address = address;

	        System.out.println("Student Object Created");

	    }

	    public void displayStudent() {
	        System.out.println("Student Id:" + id);
	        System.out.println("Student Name:" + name);
	        System.out.println("Student Age:" + age);
	        System.out.println();
	        course.displayCourse();
	        System.out.println();
	        address.displayAddress();
	    }

	}