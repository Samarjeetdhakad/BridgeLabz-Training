package com.collectors.employeesalary;


public class Employee {
	
		private String name;
		private Double salary;
		private String department;
		
		public Employee(String name, String department, Double salary) {
			this.name=name;
			this.salary = salary;
			this.department = department;
		}
		
		public String getDepartment() {
			return department;
			}
		
		public String getName() {
			return name ;
			}
		
		public Double getSalary() {
			return salary;
			}
		
		@Override
		public String toString() {
			return name + " " + salary;
			
		}

}
