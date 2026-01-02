package com.inheritance.assistedproblems;


public class Manager extends Employee {
	int teamSize;
	
	Manager(String name, int id, int salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
	
	void displayDetails(){
		super.displayDetails();
		System.out.println("team Size : " + teamSize);
	}
}