package com.reflection.basiclevel.dynamicallyobject;
public class Student {
    private int id;
    private String name;
    public Student() {
        this.id = 0;
        this.name = "unknown";
    }
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void display() {
        System.out.println("Id: " + id + ", Name: " + name);
    }
}