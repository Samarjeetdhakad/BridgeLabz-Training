package com.json.carobject;

public class Car {
    private String brand;
    private String model;
    private int price;
    public Car(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    // Getters
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getPrice() {
        return price;
    }
}