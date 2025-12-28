package com.constructor.level1;

public class EmployeeMain {
	
	    public static void main(String[] args) {
	        Manager mgr = new Manager(1001,"IT",75000,"Project Manager");
	        mgr.displayDetails();
	        mgr.setSalary(85000);

	        System.out.println("Updated Salary: ₹" + mgr.getSalary());
	    }
	}



