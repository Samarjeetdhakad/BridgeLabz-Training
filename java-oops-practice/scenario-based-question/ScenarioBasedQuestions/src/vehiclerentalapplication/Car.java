package vehiclerentalapplication;

public class Car extends Vehicle {

    double luxuryCharge = 500;

    Car(String vehicleId, String brand, double baseRate) {
        super(vehicleId, brand, baseRate);
    }

    @Override
    double calculateRent(int days) {
        return (baseRate * days)+luxuryCharge;
    }
}