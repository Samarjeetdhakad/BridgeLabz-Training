package com.functionalinterface.vehicledashboard;

class PetrolCar implements Vehicle{
    @Override
    public void displaySpeed() {
        System.out.println("Petrol Car speed: 80 km/h");
    }
}