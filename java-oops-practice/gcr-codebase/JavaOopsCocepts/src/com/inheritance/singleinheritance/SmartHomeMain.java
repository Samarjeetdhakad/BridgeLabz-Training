package com.inheritance.singleinheritance;

public class SmartHomeMain {

	public static void main(String[] args) {
		Device d = new Thermostat("TH-101", true, 24);
        d.displayStatus();   
	}

}