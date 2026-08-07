package com.bridgelabz.student_management.model;
import lombok.Data;

import org.springframework.stereotype.Component;


@Component
public class Course {

    private String courseName = "Spring Framework";
    private int duration = 6;

    public Course() {
        System.out.println("Course Bean Created");
    }

    public void display() {
        System.out.println("Course Name:" + courseName);
        System.out.println("Duration" + duration + " Months");

    }

}