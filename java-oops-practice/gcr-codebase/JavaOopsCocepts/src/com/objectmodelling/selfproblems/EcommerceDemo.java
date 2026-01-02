package com.objectmodelling.selfproblems;

public class EcommerceDemo {
    public static void main(String[] args) {

        Customer customer = new Customer("Aman", 3);

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1200);

        Order o1 = new Order(101, 5);

        // Order aggregates products
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p3);

        // Customer places order
        customer.placeOrder(o1);

        // Display
        customer.showOrders();
    }
}