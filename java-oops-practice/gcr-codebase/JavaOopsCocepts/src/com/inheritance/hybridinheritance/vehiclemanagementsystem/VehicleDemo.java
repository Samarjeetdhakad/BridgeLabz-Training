package com.inheritance.hybridinheritance.vehiclemanagementsystem;

public class VehicleDemo {
	public static void main(String[]args) {
		ElectricVehicle ev = new ElectricVehicle(230, "hp2026");
		ev.displayDetails();
		ev.charge();
		
		PetrolVehicle pv = new PetrolVehicle(340 , "TESLA 2023");
		pv.displayDetails();
		pv.refuel();
		
	}

}
