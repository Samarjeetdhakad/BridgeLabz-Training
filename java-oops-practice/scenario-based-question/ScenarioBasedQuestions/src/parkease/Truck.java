package parkease;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber) {
        super(vehicleNumber, 100);
    }

    @Override
    public double calculateCharges(int hours) {
        return (baseRate * hours) + (hours > 4 ? 200 : 0);
    }
}
