package com.functionalinterface.smartdevicecontrol;

public class AC implements SmartDevice{
    public void turnOn() {
        System.out.println("AC is turned on");
    }
    public void turnOff() {
        System.out.println("AC is turned off");
    }
}

