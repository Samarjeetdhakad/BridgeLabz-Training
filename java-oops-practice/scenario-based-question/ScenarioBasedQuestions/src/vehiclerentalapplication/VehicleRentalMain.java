package vehiclerentalapplication;

public class VehicleRentalMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer("Rohan");

        Vehicle bike  = new Bike("B101", "Honda", 300);
        Vehicle car   = new Car("C201", "Hyundai", 1500);
        Vehicle truck = new Truck("T301", "Tata", 2500);

        customer.rentVehicle(bike, 3);
        customer.rentVehicle(car, 2);
        customer.rentVehicle(truck, 1);

	}

}