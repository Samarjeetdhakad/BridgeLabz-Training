package com.inheritance.assistedproblems;


public class Employee {
	String name ;
	int id ;
	int salary ;
	
	Employee(String name, int id, int salary )
	{
		this.name = name;
		this.id = id;
		this.salary = salary;
	}	
	
	void displayDetails(){
		System.out.println(name);
		System.out.println(id);
		System.out.println(salary);
	}
}