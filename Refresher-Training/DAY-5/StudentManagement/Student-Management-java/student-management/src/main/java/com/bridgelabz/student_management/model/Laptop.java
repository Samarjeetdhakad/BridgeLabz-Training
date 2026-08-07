package com.bridgelabz.student_management.model;

public class Laptop {
    private String brand;
    private int ram;
  
    public Laptop() {
     System.out.println("Laptop Bean Created");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("RAM: " + ram + " GB");
    }

}