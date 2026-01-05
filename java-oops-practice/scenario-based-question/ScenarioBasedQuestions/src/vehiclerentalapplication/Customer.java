package vehiclerentalapplication;

public class Customer {

    private String name;

    Customer(String name) {
        this.name =name;
    }

    void rentVehicle(Vehicle v, int days) {
        System.out.println("\nCustomer: " + name);
        v.displayInfo();
        System.out.println("Days Rented:"+days);
        System.out.println("Total Rent :"+v.calculateRent(days));
    }
}