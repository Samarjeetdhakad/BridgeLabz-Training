package fleetmanager;

public class Main {

    public static void main(String[] args) {

        Vehicle[] vehicles = { new Vehicle("DL-101", 45000),  new Vehicle("MH-201", 12000), new Vehicle("KA-301", 30000), new Vehicle("DL-102", 60000), new Vehicle("MH-202", 20000)};

        FleetManager.mergeSort(vehicles, 0, vehicles.length - 1);

        System.out.println("Master Maintenance Schedule (Sorted by Mileage):");
        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleId + "-" + v.mileage + " km");
        }
    }
}
