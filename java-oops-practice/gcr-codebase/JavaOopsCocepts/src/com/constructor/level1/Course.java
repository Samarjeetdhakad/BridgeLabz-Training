package com.constructor.level1;

class Course {

    String courseName;
    int duration;        
    double fee;
    static String instituteName="BridgeLabz";

    Course(String courseName, int duration, double fee) {
        this.courseName=courseName;
        this.duration=duration;
        this.fee=fee;
    }

    void displayCourseDetails() {
        System.out.println("Course Name: "+courseName);
        System.out.println("Duration: "+duration+" months");
        System.out.println("Fee: ₹"+fee);
        System.out.println("Institute: "+instituteName);
    }
    static void updateInstituteName(String newInstituteName) {
        instituteName=newInstituteName;
    }
}
