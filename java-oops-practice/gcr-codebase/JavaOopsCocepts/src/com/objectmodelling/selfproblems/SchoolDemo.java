package com.objectmodelling.selfproblems;

public class SchoolDemo {
    public static void main(String[] args) {

        School school = new School("Green Valley School", 5);

        Student s1 = new Student("Aman", 3);
        Student s2 = new Student("Riya", 3);

        Course c1 = new Course("Java", 5);
        Course c2 = new Course("DBMS", 5);

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c1);

        s1.showCourses();
        System.out.println();
        s2.showCourses();
        System.out.println();

        c1.showStudents();
        System.out.println();
        c2.showStudents();
    }
}
