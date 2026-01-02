package com.objectmodelling.assistedproblem;

class Company {
    String companyName;
    Department[] departments;
    int deptCount = 0;

    Company(String companyName, int maxDepartments) {
        this.companyName = companyName;
        departments = new Department[maxDepartments];
    }

    // Departments created inside Company (Composition)
    void addDepartment(String deptName, int maxEmployees) {
        departments[deptCount++] = new Department(deptName, maxEmployees);
    }

    Department getDepartment(int index) {
        return departments[index];
    }

    void showCompany() {
        System.out.println("Company: " + companyName);
        for (int i = 0; i < deptCount; i++) {
            departments[i].showDepartment();
        }
    }

    // Simulating deletion of Company
    void deleteCompany() {
        System.out.println("Company deleted!");
        departments = null; // All departments & employees destroyed
    }
}
