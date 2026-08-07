package com.bridgelabz.student_management.model;

public class Course {
    private String courseName;
    private int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
        System.out.println("Course Bean Created");
    }

    public void display() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + "Months");

    }

}