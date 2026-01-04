package com.encapsulationpolymorphisminterfaceandabstract.ridehailingapplication;

class Bike extends Vehicle implements GPS {

    private String location;

    public Bike(int id, String driver, double rate) {
        super(id,driver,rate);
    }

    @Override
    public double calculateFare(double distance) {
        return (ratePerKm*distance)*0.9; 
    }

    @Override
    public void updateLocation(String location) {
        this.location=location;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }
}