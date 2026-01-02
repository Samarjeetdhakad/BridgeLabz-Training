package com.objectmodelling.selfproblems;


class Faculty {
    String facultyName;

    Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    void showFaculty() {
        System.out.println("Faculty Name: " + facultyName);
    }
}