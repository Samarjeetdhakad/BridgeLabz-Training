package com.inheritance.hybridinheritance.vehiclemanagementsystem;

public class Vehicle {
	int maxspeed;
	String model;
	
	Vehicle(int maxspeed , String model){
		this.maxspeed = maxspeed;
		this.model = model;
	}
	
	void displayDetails() {
		System.out.println("maxspeed :" + maxspeed );
		System.out.println("model :" + model );
		
	}

}
