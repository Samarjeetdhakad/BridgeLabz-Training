package com.functionalinterface.cloningprototypeobject;
public class Employee implements Cloneable {
    int id;
    String name;
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // cloning logic
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}