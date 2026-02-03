package com.collectors.employeesalary;
import java.util.*;
import java.util.stream.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = List.of(
			    new Employee("Samarjeet", "IT", 75000.0),
			    new Employee("Neha", "HR", 55000.0),
			    new Employee("Rahul", "IT", 85000.0),
			    new Employee("Sneha", "Finance", 650000.0),
			    new Employee("Karan", "HR", 60000.0)
			);
		Map<String, Double>avgSalaryByDept=employees.stream()
				.collect(Collectors.groupingBy(Employee::getName,
				Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalaryByDept);
	}

}