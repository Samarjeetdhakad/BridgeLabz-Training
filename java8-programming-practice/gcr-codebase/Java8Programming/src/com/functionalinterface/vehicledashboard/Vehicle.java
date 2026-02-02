package com.functionalinterface.vehicledashboard;

interface Vehicle {
    void displaySpeed();
    default void displayBattery() {
        System.out.println("Battery information not available");
    }
}