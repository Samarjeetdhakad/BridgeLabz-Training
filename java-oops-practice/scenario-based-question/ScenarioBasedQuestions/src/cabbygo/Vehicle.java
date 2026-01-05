package cabbygo;

public class Vehicle{
	protected String vehicleNumber;
	protected int capacity; 
	protected String type;
	protected double ratePerKm;
	
	
	 public Vehicle(String vehicleNumber, int capacity, String type, double ratePerKm) {
	        this.vehicleNumber = vehicleNumber;
	        this.capacity = capacity;
	        this.type = type;
	        this.ratePerKm = ratePerKm;
	    }
	public double calculateFare(double distance) {
		double baseFare = 30;
		return baseFare + (distance * ratePerKm);
	}
	
	 public String getType() {
	        return type;
	    } 
}