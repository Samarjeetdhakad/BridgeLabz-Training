package parkease;

public class ParkingSlot {

    private int slotId;
    private boolean isOccupied;
    private String vehicleTypeAllowed;
    private String location;

   
    private String bookingLog;

    public ParkingSlot(int slotId, String location, String vehicleTypeAllowed) {
        this.slotId = slotId;
        this.location = location;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.isOccupied = false;
    }

    
    public boolean assignSlot(Vehicle vehicle) {
        if (!isOccupied && vehicle.getClass().getSimpleName().equals(vehicleTypeAllowed)) {
            isOccupied = true;
            bookingLog = "Slot " + slotId + " booked for " + vehicle.getVehicleNumber();
            return true;
        }
        return false;
    }

    public void releaseSlot() {
        isOccupied = false;
        bookingLog = "Slot " + slotId + " released";
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

   
    public String getBookingLog() {
        return bookingLog;
    }
}
