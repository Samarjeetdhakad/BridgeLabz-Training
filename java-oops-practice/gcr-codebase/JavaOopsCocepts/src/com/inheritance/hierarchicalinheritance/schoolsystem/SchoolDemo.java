package com.inheritance.hierarchicalinheritance.schoolsystem;

public class SchoolDemo {
    public static void main(String[] args) {

        Teacher t = new Teacher();
        t.name = "Mr. Sharma";
        t.age = 40;
        t.subject = "Mathematics";

        t.displayRole();
        t.displayPersonDetails();
        System.out.println("Subject: " + t.subject);
        System.out.println();

        Student s = new Student();
        s.name = "Aarav";
        s.age = 16;
        s.grade = "10th";

        s.displayRole();
        s.displayPersonDetails();
        System.out.println("Grade: " + s.grade);
        System.out.println();

        Staff st = new Staff();
        st.name = "Mrs. Patel";
        st.age = 35;
        st.department = "Administration";

        st.displayRole();
        st.displayPersonDetails();
        System.out.println("Department: " + st.department);
    }
}

