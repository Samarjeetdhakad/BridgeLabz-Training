package com.constructor.level1;

class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;

    private static final double COST_PER_DAY = 1200.0;

    CarRental() {
        this.customerName="Customer";
        this.carModel="Standard";
        this.rentalDays =1;
        calculateTotalCost();
    }

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName= customerName;
        this.carModel =carModel;
        this.rentalDays =rentalDays;
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        totalCost=rentalDays*COST_PER_DAY;
    }

    void displayRental() {
        System.out.println("Customer Name: "+customerName);
        System.out.println("Car Model: "+carModel);
        System.out.println("Rental Days: "+rentalDays);
        System.out.println("Total Cost: ₹"+totalCost);
    }

   
}
