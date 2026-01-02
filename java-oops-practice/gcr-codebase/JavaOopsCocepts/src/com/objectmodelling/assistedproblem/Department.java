package com.objectmodelling.assistedproblem;

class Department {
    String deptName;
    Employee[] employees;
    int empCount = 0;

    Department(String deptName, int maxEmployees) {
        this.deptName =deptName;
        employees =new Employee[maxEmployees];
    }

    void addEmployee(String empName) {
        employees[empCount++]=new Employee(empName);
    }

    void showDepartment() {
        System.out.println("Department: "+deptName);
        for (int i=0;i<empCount; i++) {
            employees[i].showEmployee();
        }
    }
}
