package com.encapsulationpolymorphisminterfaceandabstract.hospitalmanagementsystem;

abstract class Patient {
	
    private int patientId;
    private String name;
    private int age;

    private String diagnosis;

    public Patient(int patientId, String name, int age) {
        this.patientId=patientId;
        this.name=name;
        this.age=age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID :"+patientId);
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis=diagnosis;
    }
    
    protected String getDiagnosis() {
        return diagnosis;
    }
}