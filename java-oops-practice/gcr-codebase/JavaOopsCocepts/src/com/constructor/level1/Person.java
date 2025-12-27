package com.constructor.level1;

 class Person {
	private int age;
	private String name;
	private double salary;
	
	Person(int age, String name, double salary){
		this.age = age;
		this.name = name;
		this.salary = salary;
		
	}
	
	Person(Person other){
		this.name = other.name;
		this.age = other.age;
		this.salary = other.salary;	
	}
	
	void display () {
		System.out.println("name: " + name);
		System.out.println("Age: " + age);
	    System.out.println("salary: " + salary);
	    }
	

}
