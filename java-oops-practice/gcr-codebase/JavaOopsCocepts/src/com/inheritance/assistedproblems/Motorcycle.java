package com.inheritance.assistedproblems;

public class Motorcycle extends Vehicle {
	int seatCapacity;
	
	Motorcycle(int maxSpeed, String fuelType, int seatCapacity){
		super(maxSpeed, fuelType);
		this.seatCapacity = seatCapacity;
	}
	
	void displayInfo() {
		super.displayInfo();
		System.out.println(seatCapacity);
		
	}
}