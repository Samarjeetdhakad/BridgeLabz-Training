package com.objectmodelling.selfproblems;

class Professor {
    String name;
    Courses[] courses;
    int courseCount = 0;

    Professor(String name, int maxCourses) {
        this.name = name;
        courses = new Courses[maxCourses];
    }

    // Professor teaches course
    void assignProfessor(Courses course) {
        courses[courseCount++] = course;
        course.setProfessor(this);
    }

    void showCourses() {
        System.out.println(name + " teaches:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("- " + courses[i].courseName);
        }
    }
}