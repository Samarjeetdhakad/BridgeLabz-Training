package com.encapsulationpolymorphisminterfaceandabstract.employeemanagementsystem;

abstract class Employee implements Department {

    private int employeeId;
    private String name;
    protected double baseSalary;   
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId=employeeId;
        this.name=name;
        this.baseSalary=baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID :"+ employeeId);
        System.out.println("Name        :"+ name);
        System.out.println("Department  :"+ department);
        System.out.println("Salary      :" + calculateSalary());
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}