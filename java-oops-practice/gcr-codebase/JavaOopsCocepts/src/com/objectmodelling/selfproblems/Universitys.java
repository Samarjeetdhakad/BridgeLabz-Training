package com.objectmodelling.selfproblems;

class Universitys {
    String name;
    Students[] students;
    Professor[] professors;
    int studentCount = 0, professorCount = 0;

    Universitys(String name, int maxStudents, int maxProfessors) {
        this.name = name;
        students = new Students[maxStudents];
        professors = new Professor[maxProfessors];
    }

    void addStudent(Students student) {
        students[studentCount++] = student;
    }

    void addProfessor(Professor professor) {
        professors[professorCount++] = professor;
    }
}