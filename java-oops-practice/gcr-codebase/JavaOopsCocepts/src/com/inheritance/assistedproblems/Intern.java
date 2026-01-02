package com.inheritance.assistedproblems;

public class Intern extends Employee {
	
	Intern(String name, int id, int salary) {
        super(name, id, salary);
       
    }
	
	void displayDetails(){
		super.displayDetails();
	}
}