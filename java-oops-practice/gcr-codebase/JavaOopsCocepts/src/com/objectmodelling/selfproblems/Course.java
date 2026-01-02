package com.objectmodelling.selfproblems;

class Course {
    String courseName;
    Students[] students;
    int studentCount = 0;
    
    Course(String courseName, int maxStudents) {
        this.courseName=courseName;
        students=new Students[maxStudents];
    }

    void addStudent(Students student) {
        students[studentCount++]=student;
    }

    void showStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (int i=0;i<studentCount; i++) {
            System.out.println("- "+students[i].name);
        }
    }
}