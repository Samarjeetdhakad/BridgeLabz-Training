package com.lambdaexpression.notificationfiltering; 
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

	public class HospitalApp {
	    public static void main(String[] args) {
	        List<Alert> alerts = new ArrayList<>();
	        alerts.add(new Alert("EMERGENCY","Heart rate critical"));
	        alerts.add(new Alert("MEDICATION","Take insulin at 8 PM"));
	        alerts.add(new Alert("APPOINTMENT","Doctor visit tomorrow"));
	        alerts.add(new Alert("INFO", "Hospital closed on Sunday"));
	        
	        Predicate<Alert> userPreference =alert -> alert.getType().equals("EMERGENCY")|| alert.getType().equals("MEDICATION");
            for (Alert alert : alerts) {
	            if (userPreference.test(alert)) {
	                System.out.println(alert);
	            }
	        }
	    }
	}