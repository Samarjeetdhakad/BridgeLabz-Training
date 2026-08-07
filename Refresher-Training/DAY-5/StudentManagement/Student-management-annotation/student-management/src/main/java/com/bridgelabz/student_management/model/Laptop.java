package com.bridgelabz.student_management.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private String brand = "Dell";
    private int ram = 16;

    public Laptop() {
        System.out.println("Laptop Bean Created");
    }

    public void display() {

        System.out.println("Brand : " + brand);
        System.out.println("RAM : " + ram + " GB");

    }

}