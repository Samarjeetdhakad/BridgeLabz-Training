package com.inheritance.multilevelinheritance.educationalcoursehierarchy;

class Course {
    String courseName;
    int duration; 
    
    void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}
