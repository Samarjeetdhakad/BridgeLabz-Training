package com.functionalinterface.vehicledashboard;

public class Main {
	    public static void main(String[] args) {
	        Vehicle petrolCar = new PetrolCar();
	        Vehicle electricCar = new ElectricCar();
	        petrolCar.displaySpeed();
	        petrolCar.displayBattery();
	        System.out.println();

	        electricCar.displaySpeed();
	        electricCar.displayBattery();
	    }
	}

