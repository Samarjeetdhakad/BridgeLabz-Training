package vehiclerentalapplication;

public class Vehicle {

    protected String vehicleId;
    protected String brand;
    protected double baseRate;

    Vehicle(String vehicleId, String brand, double baseRate) {
        this.vehicleId=vehicleId;
        this.brand=brand;
        this.baseRate=baseRate;
    }

    double calculateRent(int days) {
        return baseRate * days;
    }

    void displayInfo() {
        System.out.println("Vehicle ID: " +vehicleId);
        System.out.println("Brand  : " + brand);
        System.out.println("Base Rate:" + baseRate + "/day");
    }
}