package com.javastreams.serialization;

import java.io.Serializable;
public class Employee implements Serializable{
	private int id;
	private String name;
	private String department;
	private double salary;	
	Employee(int id, String name, String department, double salary){
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}	
	public String toString(){
		return "Employee [ID=" + id + ", Name=" + name +", Department=" + department + ", Salary=" + salary + "]";
	}

}