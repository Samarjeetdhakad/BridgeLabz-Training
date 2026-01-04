package com.encapsulationpolymorphisminterfaceandabstract.ridehailingapplication;

abstract class Vehicle {

    private int vehicleId;
    private String driverName;
    protected double ratePerKm;

    public Vehicle(int vehicleId,String driverName,double ratePerKm) {
        this.vehicleId=vehicleId;
        this.driverName=driverName;
        this.ratePerKm=ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID : "+vehicleId);
        System.out.println("Driver: "+driverName);
        System.out.println("Rate/Km:"+ratePerKm);
    }
}
