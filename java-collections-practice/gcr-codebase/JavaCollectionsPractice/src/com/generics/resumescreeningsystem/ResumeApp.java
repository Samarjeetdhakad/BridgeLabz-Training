package com.generics.resumescreeningsystem;
import java.util.Arrays;
import java.util.List;

public class ResumeApp {

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
                new Resume<>("Amit", 3, new SoftwareEngineer());

        Resume<DataScientist> r2 =
                new Resume<>("Neha", 2, new DataScientist());

        Resume<ProductManager> r3 =
                new Resume<>("Rahul", 5, new ProductManager());

        ResumeScreeningService.screenResume(r1);
        ResumeScreeningService.screenResume(r2);
        ResumeScreeningService.screenResume(r3);

        List<JobRole> roles = Arrays.asList(
                new SoftwareEngineer(),
                new DataScientist(),
                new ProductManager()
        );

        ScreeningPipeline.processRoles(roles);
    }
}
