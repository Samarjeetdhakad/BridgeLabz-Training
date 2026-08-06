package com.bridgelabz.jdbcpractice.model;

public class Patient {

    private int patientId;
    private String name;
    private String phone;
    private String dob;
    
    public Patient() {}
    public Patient(int patientId, String name, String phone, String dob) {
        this.patientId = patientId;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
    }
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    @Override
    public String toString() {
    	return "[patient id="+patientId+",name=" +name +
                ",phone="+phone +
                ",dob="+dob+"]";
    }
    
}
