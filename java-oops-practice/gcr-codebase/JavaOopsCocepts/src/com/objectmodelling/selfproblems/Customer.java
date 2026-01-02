package com.objectmodelling.selfproblems;
class Customer {
    String customerName;
    Order[] orders;
    int orderCount = 0;

    Customer(String customerName, int maxOrders) {
        this.customerName=customerName;
        orders=new Order[maxOrders];
    }

    void placeOrder(Order order) {
        orders[orderCount++]=order;
    }

    void showOrders() {
        System.out.println("Orders placed by " + customerName + ":");
        for (int i = 0; i < orderCount; i++) {
            orders[i].showOrderDetails();
            System.out.println();
        }
    }
}