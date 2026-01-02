package com.objectmodelling.selfproblems;

class School {
    String schoolName;
    Student[] students;
    int studentCount = 0;

    School(String schoolName, int maxStudents) {
        this.schoolName = schoolName;
        students = new Student[maxStudents];
    }

    void addStudent(Student student) {
        students[studentCount++] = student;
    }

    void showStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + students[i].name);
        }
    }
}