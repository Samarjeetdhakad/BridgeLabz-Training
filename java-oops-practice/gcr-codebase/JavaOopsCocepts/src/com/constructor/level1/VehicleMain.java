package com.constructor.level1;

public class VehicleMain {
	    public static void main(String[] args) {

	        Vehicle v1=new Vehicle("Rahul", "Car");
	        Vehicle v2=new Vehicle("Anita", "Bike");

	        v1.displayVehicleDetails();
	        v2.displayVehicleDetails();
            Vehicle.updateRegistrationFee(6500);
	        v1.displayVehicleDetails();
	        v2.displayVehicleDetails();
	    }
	}



