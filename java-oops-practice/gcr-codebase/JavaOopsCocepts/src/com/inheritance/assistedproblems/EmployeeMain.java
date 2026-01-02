package com.inheritance.assistedproblems;

public class EmployeeMain {
	public static void main(String[] args) {
		Employee e1 = new Manager("Rohan", 101, 80000, 10);
        Employee e2 = new Developer("Amit", 102, 60000, "Java");
        Employee e3 = new Intern("Neha", 103, 15000);
        
        e1.displayDetails();
        e2.displayDetails();

        e3.displayDetails();
	}
}