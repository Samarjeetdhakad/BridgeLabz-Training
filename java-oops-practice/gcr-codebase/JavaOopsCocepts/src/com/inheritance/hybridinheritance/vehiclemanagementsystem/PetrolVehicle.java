package com.inheritance.hybridinheritance.vehiclemanagementsystem;

public class PetrolVehicle extends Vehicle implements Refuelable{
	PetrolVehicle(int maxspeed, String model  ){
		super(maxspeed, model);
	}
	
	@Override
	public void refuel() {
		System.out.println("fueling the petrol vehicle");
	}
	

}
