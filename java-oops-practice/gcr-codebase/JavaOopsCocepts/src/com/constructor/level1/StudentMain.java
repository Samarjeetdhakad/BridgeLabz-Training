package com.constructor.level1;

public class StudentMain {
	    public static void main(String[] args) {
	        PostgraduateStudent pg=new PostgraduateStudent(101, "Samarjeet", 8.5, "Computer Science" );
	        pg.displayDetails();
	        pg.setCGPA(9.1);
	        System.out.println("Updated CGPA: " + pg.getCGPA());
	    }
	}


