package com.streamapi.loggingtransactions;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
public class Transaction {
	
	public static void main(String[] args) {
		List<Integer> ids  = Arrays.asList(282718, 37822, 238 );
		ids.stream().forEach(id -> System.out.println( LocalDateTime.now()+ " transaction "+ id));
	}

}
