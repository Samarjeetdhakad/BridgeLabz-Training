package com.constructor.level1;

class Employee {

    public int employeeID;         
    protected String department;  
    private double salary;         

    Employee(int employeeID,String department,double salary) {
        this.employeeID=employeeID;
        this.department=department;
        this.salary=salary;
    }

    public void setSalary(double salary) {
        if (salary>0) {
            this.salary=salary;
        } else {
            System.out.println("Salary must be positive!");
        }
    }

    public double getSalary() {
        return salary;
    }
}
