package com.annotations.custom.beginnerlevel.important;

public class Service {
    @ImportantMethod
    public void processData() {
        System.out.println("Processing data");
    }

    @ImportantMethod(level = "LOW")
    public void logData() {
        System.out.println("Logging data");
    }
    public void helperMethod() {
        System.out.println("Helper method");
    }
}