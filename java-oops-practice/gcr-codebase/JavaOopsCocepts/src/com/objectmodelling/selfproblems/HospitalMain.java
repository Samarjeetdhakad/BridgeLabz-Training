package com.objectmodelling.selfproblems;


public class HospitalMain {
    public static void main(String[] args) {

        Hospital hospital=new Hospital("City Hospital", 5, 5);

        Doctor d1=new Doctor("Sharma", 5);
        Doctor d2=new Doctor("Khan", 5);

        Patient p1=new Patient("Aman", 3);
        Patient p2=new Patient("Riya", 3);

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Consultations (Association + Communication)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        System.out.println();
        d1.showPatients();
        System.out.println();
        p1.showDoctors();
    }
}