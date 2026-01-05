package vehiclerentalapplication;

public class Truck extends Vehicle {

    double loadCharge=1000;

    Truck(String vehicleId, String brand, double baseRate) {
        super(vehicleId, brand, baseRate);
    }

    @Override
    double calculateRent(int days) {
        return (baseRate * days)+loadCharge;
    }
}