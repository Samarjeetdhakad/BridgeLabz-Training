package com.inheritance.multilevelinheritance.educationalcoursehierarchy;

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    void displayOnlineCourse() {
        displayCourse();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}
