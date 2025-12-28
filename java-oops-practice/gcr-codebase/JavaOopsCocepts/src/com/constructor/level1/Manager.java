package com.constructor.level1;

class Manager extends Employee {
    String role;
    Manager(int employeeID, String department, double salary, String role) {
        super(employeeID, department, salary);
        this.role=role;
    }

    void displayDetails() {
        System.out.println("Employee ID:" + employeeID);   
        System.out.println("Department:" + department);  
        System.out.println("Salary:" + getSalary());      
        System.out.println("Role:" + role);
    }
}
