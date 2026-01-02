package com.objectmodelling.selfproblems;

class Student {
    String name;
    Course[] courses;
    int courseCount = 0;

    Student(String name, int maxCourses) {
        this.name = name;
        courses = new Course[maxCourses];
    }

    void enrollCourse(Course course) {
        courses[courseCount++] = course;
        course.addStudent(this); 
    }

    void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("- " + courses[i].courseName);
        }
    }
}