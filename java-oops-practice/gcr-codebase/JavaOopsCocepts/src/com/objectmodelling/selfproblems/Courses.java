package com.objectmodelling.selfproblems;

class Courses {
    String courseName;
    Students[] students;
    int studentCount = 0;
    Professor professor;

    Courses(String courseName, int maxStudents) {
        this.courseName = courseName;
        students = new Students[maxStudents];
    }

    void addStudent(Students student) {
        students[studentCount++] = student;
    }

    void setProfessor(Professor professor) {
        this.professor = professor;
    }

    void showCourseDetails() {
        System.out.println("Course: " + courseName);

        if (professor != null)
            System.out.println("Professor: " + professor.name);

        System.out.println("Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + students[i].name);
        }
    }
}