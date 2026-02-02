package com.lambdaexpression.hospitalprinting;

import java.util.List;
import java.util.ArrayList;

public class HospitalAdmin {
    public static void printPatientId(Patient p) {
        System.out.println(p.getId());
    }
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(101, "samarjeet"));
        patients.add(new Patient(102, "sunny"));
        patients.add(new Patient(103, "Suresh"));

        patients.forEach(HospitalAdmin::printPatientId);
    }
}