//write a program with the use of instance and class variable
package com.constructor.level1;

class Product {
    String productName;
    double price;
    static int totalProducts=0;

    Product(String productName, double price) {
        this.productName=productName;
        this.price=price;
        totalProducts++; 
        }

    void displayProductDetails() {
        System.out.println("Product Name: "+productName);
        System.out.println("Price: ₹"+price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products Created: "+totalProducts);
    }
}
