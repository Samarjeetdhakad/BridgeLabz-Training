package com.bridgelabz.student_management.model;

import lombok.Data;

@Data
public class Course {
	private String courseName;
    private int duration;
    

    public Course() {
        System.out.println("Course Object Created");
    }
    
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
        System.out.println("Course Object Created");
    }
    
    public void displayCourse() {
        System.out.println("Course Name:" + courseName);
        System.out.println("Duration:" + duration + " Months");

    }
    
}
