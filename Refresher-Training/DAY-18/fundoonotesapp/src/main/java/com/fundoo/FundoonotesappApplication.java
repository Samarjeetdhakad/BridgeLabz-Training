package com.fundoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FundoonotesappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundoonotesappApplication.class, args);
	}

}
