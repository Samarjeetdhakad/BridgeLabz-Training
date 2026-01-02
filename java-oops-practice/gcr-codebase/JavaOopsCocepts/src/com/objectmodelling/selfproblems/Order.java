package com.objectmodelling.selfproblems;


class Order {
    int orderId;
    Product[] products;
    int productCount = 0;

    Order(int orderId, int maxProducts) {
        this.orderId = orderId;
        products = new Product[maxProducts];
    }

    // Adding product to order (Aggregation)
    void addProduct(Product product) {
        products[productCount++] = product;
    }

    void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products in Order:");
        for (int i = 0; i < productCount; i++) {
            products[i].showProduct();
        }
    }
}