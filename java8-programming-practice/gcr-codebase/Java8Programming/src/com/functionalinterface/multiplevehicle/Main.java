package com.functionalinterface.multiplevehicle;

public class Main {
	    public static void main(String[] args) {
	        RentalVehicle car=new Car();
	        RentalVehicle bike=new Bike();
	        car.rent();
	        bike.rent();
	        car.returnVehicle();
	        bike.returnVehicle();  
	    }
	}

