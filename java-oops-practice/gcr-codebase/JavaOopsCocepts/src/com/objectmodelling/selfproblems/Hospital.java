package com.objectmodelling.selfproblems;

class Hospital {
    String hospitalName;
    Doctor[] doctors;
    Patient[] patients;
    int doctorCount = 0, patientCount = 0;

    Hospital(String hospitalName,int maxDoctors,int maxPatients) {
        this.hospitalName=hospitalName;
        doctors=new Doctor[maxDoctors];
        patients=new Patient[maxPatients];
    }

    void addDoctor(Doctor doctor) {
        doctors[doctorCount++]=doctor;
    }

    void addPatient(Patient patient) {
        patients[patientCount++]=patient;
    }
}