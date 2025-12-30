package com.thisstatic;

public class CompanyMain {
	 public static void main(String[] args) {

	       Company.setCompanyName("Tech Solutions Inc.");
	       Company emp1 = new Company("Thamarai", 101, "Software Engineer");
	      Company emp2 = new Company("Rohan", 102, "Project Manager");

	       Company.displayTotalEmployees();

	       emp1.displayEmployeeDetails();
	       emp2.displayEmployeeDetails();
	   }
	}


}
