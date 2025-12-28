package com.constructor.level1;

class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int rollNumber, String name, double cgpa,String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    void displayDetails() {
        System.out.println("Roll Number: "+rollNumber);  
        System.out.println("Name: "+name);               
        System.out.println("CGPA: "+getCGPA());          
        System.out.println("Specialization: "+specialization);
    }
}
