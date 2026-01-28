package com.reflection.advancedlevel.dependencyinjection;
public class TestDI {
    public static void main(String[] args) {
        SimpleDIContainer container = new SimpleDIContainer();
        Car car = container.getBean(Car.class);
        car.drive();
    }
}