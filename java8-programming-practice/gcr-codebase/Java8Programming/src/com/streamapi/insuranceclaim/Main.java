package com.streamapi.insuranceclaim;
import java.util.*;
import java.util.stream.*;
public class Main {
	    public static void main(String[] args) {
	        List<InsuranceClaim> claims=Arrays.asList(
	            new InsuranceClaim("Health", 50000),
	            new InsuranceClaim("Vehicle", 30000),
	            new InsuranceClaim("Health", 70000),
	            new InsuranceClaim("Property", 120000),
	            new InsuranceClaim("Vehicle", 45000),
	            new InsuranceClaim("Health", 60000)
	        );    
	        Map<String, Double> avgClaimByType = claims.stream().collect(Collectors.groupingBy(InsuranceClaim::getClaimType, 
	        		Collectors.averagingDouble(InsuranceClaim::getClaimAmount) ));
	        avgClaimByType.forEach((type, avg ) -> System.out.println(type+ " average claim " + avg))  ;
	        		
	    }
	}
