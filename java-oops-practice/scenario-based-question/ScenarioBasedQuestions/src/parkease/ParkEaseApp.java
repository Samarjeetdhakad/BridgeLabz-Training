package parkease;

public class ParkEaseApp {

    public static void main(String[] args) {

        Vehicle car = new Car("MP04NP3004");
        Vehicle bike = new Bike("MH14XY5678");

        ParkingSlot slot1 = new ParkingSlot(101, "Zone A", "Car");
        ParkingSlot slot2 = new ParkingSlot(102, "Zone B", "Bike");

        if (slot1.assignSlot(car)) {
            System.out.println("Car parked successfully");
            System.out.println("Charges:" + car.calculateCharges(6));
            System.out.println(slot1.getBookingLog());
        }

        if (slot2.assignSlot(bike)) {
            System.out.println("Bike parked successfully");
            System.out.println("Charges:" + bike.calculateCharges(4));
            System.out.println(slot2.getBookingLog());
        }

        slot1.releaseSlot();
        System.out.println(slot1.getBookingLog());
    }
}
