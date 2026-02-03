package com.streamapi.hospital;
import java.util.*;
import java.util.stream.*;
public class Main {
	    public static void main(String[] args) {
	        List<Doctor> doctors = Arrays.asList(
	            new Doctor("Dr. Sharma", "Cardiology", true),
	            new Doctor("Dr. Mehta", "Neurology", false),
	            new Doctor("Dr. Singh", "Orthopedics", true),
	            new Doctor("Dr. Rao", "Dermatology", true),
	            new Doctor("Dr. Verma", "Cardiology", false)
	        );
	        List<Doctor> weekendDoctors=doctors.stream()
	            .filter(Doctor::isAvailableOnWeekend)
	            .sorted(Comparator.comparing(Doctor::getSpecialty))
	            .collect(Collectors.toList());
	        weekendDoctors.forEach(System.out::println);
	    }
	}

