package com.bridgelabz.student_management.model;

import lombok.Data;

@Data
public class Address {
	private String city;
    private String state;

    public Address() {}
    
    public Address(String city, String state) {
        this.city = city;
        this.state = state;
        System.out.println("Address Object Created");
    }

    public void displayAddress() {
        System.out.println("City:" + city);
        System.out.println("State:" + state);
    }

}
