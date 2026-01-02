package com.objectmodelling.selfproblems;


public class UniversityDemo {
    public static void main(String[] args) {
        Faculty f1=new Faculty("Dr. Sharma");
        Faculty f2=new Faculty("Dr. Khan");

        University uni=new University("ABC University", 3, 3);

        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showUniversityDetails();

        System.out.println("\nDeleting University \n");
        uni.deleteUniversity();

        System.out.println("Faculty still exists:");
        f1.showFaculty();
        f2.showFaculty();
    }
}