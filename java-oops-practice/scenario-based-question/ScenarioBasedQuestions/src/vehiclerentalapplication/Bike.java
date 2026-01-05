package vehiclerentalapplication;

public class Bike extends Vehicle {

    Bike(String vehicleId, String brand, double baseRate) {
        super(vehicleId, brand, baseRate);
    }

    @Override
    double calculateRent(int days) {
        return baseRate*days;  
    }
}