package com.json.carobject;

import org.json.JSONObject;

public class CarToJSONPractice {

    public static void main(String[] args) {

        // Create Java object
        Car car = new Car("Toyota", "Fortuner", 3500000);

        //Convert Java object to JSON
        JSONObject carJSON = new JSONObject();
        carJSON.put("brand", car.getBrand());
        carJSON.put("model", car.getModel());
        carJSON.put("price", car.getPrice());

        //Print JSON
        System.out.println(carJSON.toString(4));
    }
}