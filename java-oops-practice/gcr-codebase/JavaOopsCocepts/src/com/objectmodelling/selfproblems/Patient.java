package com.objectmodelling.selfproblems;

class Patient {
    String name;
    Doctor[] doctors;
    int doctorCount = 0;

    Patient(String name, int maxDoctors) {
        this.name = name;
        doctors = new Doctor[maxDoctors];
    }

    void addDoctor(Doctor doctor) {
        doctors[doctorCount++] = doctor;
    }

    void showDoctors() {
        System.out.println(name + " consulted doctors:");
        for (int i = 0; i < doctorCount; i++) {
            System.out.println("- Dr. " + doctors[i].name);
        }
    }
}