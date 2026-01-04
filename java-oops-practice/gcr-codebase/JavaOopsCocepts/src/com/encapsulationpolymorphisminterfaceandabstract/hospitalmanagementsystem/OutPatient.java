package com.encapsulationpolymorphisminterfaceandabstract.hospitalmanagementsystem;

class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String diagnosis) {
        setDiagnosis(diagnosis);
    }

    @Override
    public void viewRecords() {
        System.out.println("Diagnosis       : " + getDiagnosis());
        System.out.println("Consultation Fee: " + consultationFee);
    }
}