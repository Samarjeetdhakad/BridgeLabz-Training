package com.functionalinterface.smartdevicecontrol;

public class Light implements SmartDevice {

	public void turnOn() {
		System.out.println("light is turned on");
		}
    public void turnOff() {
        System.out.println("Light is turned off");
}
}