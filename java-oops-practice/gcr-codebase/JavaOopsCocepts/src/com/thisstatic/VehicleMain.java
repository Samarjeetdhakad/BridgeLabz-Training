package com.thisstatic;

public class VehicleMain {
	 public static void main(String[] args) {

	       Vehicle.updateRegistrationFee(150.0); 

	       Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
	       Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");
	       vehicle1.displayRegistrationDetails();
	       System.out.println();
	       vehicle2.displayRegistrationDetails();
	   }


}
