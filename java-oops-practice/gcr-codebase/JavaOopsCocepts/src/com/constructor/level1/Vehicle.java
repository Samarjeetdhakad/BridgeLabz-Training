package com.constructor.level1;

class Vehicle {

    String ownerName;
    String vehicleType;

    static double registrationFee = 5000;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName=ownerName;
        this.vehicleType=vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println("Owner Name: "+ownerName);
        System.out.println("Vehicle Type: "+vehicleType);
        System.out.println("Registration Fee: ₹"+ registrationFee);
    }
    static void updateRegistrationFee(double newFee) {
        registrationFee=newFee;
    }
}
