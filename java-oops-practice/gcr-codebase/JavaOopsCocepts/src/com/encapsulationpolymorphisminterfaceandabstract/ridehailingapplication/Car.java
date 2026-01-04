package com.encapsulationpolymorphisminterfaceandabstract.ridehailingapplication;

class Car extends Vehicle implements GPS {

    private String location;

    public Car(int id, String driver, double rate) {
        super(id,driver,rate);
    }

    @Override
    public double calculateFare(double distance) {
        return ratePerKm*distance;
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
