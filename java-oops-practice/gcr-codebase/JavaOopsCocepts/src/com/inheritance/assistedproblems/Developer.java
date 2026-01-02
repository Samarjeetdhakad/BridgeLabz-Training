package com.inheritance.assistedproblems;


public class Developer extends Employee {
	String programmingLanguage ;

	Developer(String name, int id, int salary,String lang) {
        super(name, id, salary);
        this.programmingLanguage = lang;
    }
	
	void displayDetails(){
		super.displayDetails();
		System.out.println("Programming Language: " + programmingLanguage);
	}

}