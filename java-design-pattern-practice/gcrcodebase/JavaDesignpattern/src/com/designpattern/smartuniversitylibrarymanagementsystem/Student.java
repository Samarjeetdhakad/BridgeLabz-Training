package com.designpattern.smartuniversitylibrarymanagementsystem;

class Student implements User {
    public void getRole() {
        System.out.println("Student: Limited borrowing");
    }
}