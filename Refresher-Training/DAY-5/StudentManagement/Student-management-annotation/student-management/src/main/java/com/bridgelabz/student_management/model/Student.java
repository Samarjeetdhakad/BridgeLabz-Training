package com.bridgelabz.student_management.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

	  private int id = 101;
	  private String name = "Samar";
	  
	    // Constructor Injection
	    private Course course;

	    // Setter Injection
	    private Address address;

	    // Field Injection
	    @Autowired
	    private Laptop laptop;

	  @Autowired
	  public Student(Course course) {
		  this.course = course;	  
	  }
	  
	  @Autowired
	  public void setAddress(Address address) {
		  this.address = address;
		  address.setCity("Bhopal");
	      address.setState("Madhya Pradesh");
	        System.out.println("Setter Injection Executed");
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
