package com.inheritance.assistedproblems;


public class Vehicle {
	int maxSpeed;
	String fuelType;
	
	Vehicle(int maxSpeed, String fuelType){
		this.maxSpeed = maxSpeed;
		this.fuelType = fuelType;
	}
	
	
	void displayInfo() {
		System.out.println("Maax Speed is : " + maxSpeed);
		System.out.println("Fuel type : "+ fuelType);
		
	}

}