package com.functionalinterface.temperaturealertsystem;
import java.util.function.Predicate;
public class TemperatureAlertSystem {

	    public static void main(String[] args) {
	        double threshold=37.5;
	        Predicate<Double> temperatureAlert=temp -> temp > threshold;
	        double[] temperatures={36.2, 37.0, 37.8, 38.5};
	        for (double temp : temperatures) {
	            if (temperatureAlert.test(temp)) {
	                System.out.println("Temperature crossed threshold: " + temp);
	            } else {
	                System.out.println("Temperature normal: " + temp);
	            }
	        }
	    }
	

}
