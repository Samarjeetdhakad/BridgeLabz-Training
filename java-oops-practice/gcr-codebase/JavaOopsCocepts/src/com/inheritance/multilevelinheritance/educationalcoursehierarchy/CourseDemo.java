package com.inheritance.multilevelinheritance.educationalcoursehierarchy;

public class CourseDemo {
    public static void main(String[] args) {

        PaidOnlineCourse course = new PaidOnlineCourse();

        course.courseName = "Java Full Stack";
        course.duration = 120;
        course.platform = "Udemy";
        course.isRecorded = true;
        course.fee = 5000;
        course.discount = 20;

        course.displayPaidCourse();
    }
}
