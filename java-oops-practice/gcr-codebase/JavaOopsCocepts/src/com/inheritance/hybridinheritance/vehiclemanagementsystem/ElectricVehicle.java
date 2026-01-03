package com.inheritance.hybridinheritance.vehiclemanagementsystem;

public class ElectricVehicle extends Vehicle {
	ElectricVehicle(int maxspeed, String model){
		super(maxspeed , model);
		
	}
	
	void charge(){
        System.out.println("Charging the electric vehicle");

		
	}

}
