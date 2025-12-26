package com.classandobject.levelone;

public class Employeedetail {
	//non-static variables
		String name;
		int id;
		double salary;
		
		//Constructor
		Employeedetail(String name, int id,double salary){
			this.name=name;
			this.id=id;
			this.salary=salary;
		}
		
		//creating method to display employee details
		public  void displayEmployeedetail() {
			System.out.println("Employee Name: "+name);
			System.out.println("Employee id: "+id);
			System.out.println("Employee Salary: "+salary);
		}


	public static void main(String[] args) {
		
		Employeedetail emp=new Employeedetail("Rohan",1,500000);
		emp.displayEmployeedetail();


	}

}
