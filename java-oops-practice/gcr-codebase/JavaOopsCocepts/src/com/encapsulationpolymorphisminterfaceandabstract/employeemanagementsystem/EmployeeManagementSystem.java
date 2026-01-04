package com.encapsulationpolymorphisminterfaceandabstract.employeemanagementsystem;

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Employee e1=new FullTimeEmployee(101, "Rahul", 50000);
        Employee e2=new PartTimeEmployee(102, "Aman", 80, 300);

        e1.assignDepartment("IT");
        e2.assignDepartment("HR");

        Employee[] employees={ e1, e2 };

        for (Employee emp :employees) {
            emp.displayDetails();
        }
    }
}