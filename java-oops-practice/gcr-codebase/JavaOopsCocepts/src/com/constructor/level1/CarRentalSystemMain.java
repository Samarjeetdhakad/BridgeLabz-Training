package com.constructor.level1;

public class CarRentalSystemMain {
	 public static void main(String[] args) {

	        CarRental r1=new CarRental();
	        CarRental r2=new CarRental("Samar", "Hyundai Creta", 4);

	        r1.displayRental();

	        r2.displayRental();
	    }

}
