package com.objectmodelling.assistedproblem;

public class CompanyMain{
    public static void main(String[] args) {

        Company company=new Company("TechSoft Pvt Ltd",3);

        company.addDepartment("IT", 3);
        company.addDepartment("HR", 2);

        company.getDepartment(0).addEmployee("Aman");
        company.getDepartment(0).addEmployee("Riya");

        company.getDepartment(1).addEmployee("Rahul");

        company.showCompany();
        company.deleteCompany();
    }
}
