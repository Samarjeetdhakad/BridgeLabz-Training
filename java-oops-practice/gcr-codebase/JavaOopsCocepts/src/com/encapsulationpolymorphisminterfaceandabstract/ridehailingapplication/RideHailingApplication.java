package com.encapsulationpolymorphisminterfaceandabstract.ridehailingapplication;

public class RideHailingApplication {

    public static void calculateRideFare(Vehicle vehicle, double distance) {

        vehicle.getVehicleDetails();
        double fare = vehicle.calculateFare(distance);

        if (vehicle instanceof GPS) {
            GPS gps=(GPS) vehicle;
            gps.updateLocation("Bhopal City Center");
            System.out.println("Current Location: "+gps.getCurrentLocation());
        }

        System.out.println("Distance :"+distance+"km");
        System.out.println("Total Fare"+fare);
    }

    public static void main(String[] args) {

        Vehicle v1=new Car(1, "Amit", 15);
        Vehicle v2= new Bike(2, "Rohit", 10);
        Vehicle v3 =new Auto(3, "Suresh", 12);

        Vehicle[] rides={ v1, v2, v3 };

        for (Vehicle v : rides) {
            calculateRideFare(v, 10);
        }
    }
}