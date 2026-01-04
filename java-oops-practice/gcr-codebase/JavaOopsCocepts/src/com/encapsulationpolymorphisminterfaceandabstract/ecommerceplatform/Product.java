package com.encapsulationpolymorphisminterfaceandabstract.ecommerceplatform;

abstract class Product {

    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId=productId;
        this.name=name;
        this.price=price;
    }

    public abstract double calculateDiscount();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void displayProduct() {
        System.out.println("Product ID : "+productId);
        System.out.println("Name: "+name);
        System.out.println("Price: "+price);
    }
}