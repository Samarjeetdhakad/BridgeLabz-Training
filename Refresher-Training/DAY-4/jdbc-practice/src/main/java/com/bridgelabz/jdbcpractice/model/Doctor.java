package com.bridgelabz.jdbcpractice.model;

import lombok.Data;

@Data
public class Doctor {
    private int doctorId;
    private String name;
    private String specialty;
    private double doctorFee;
    private int departmentId;

    public Doctor() {}
    
    public Doctor(int doctorId, String name, String specialty, double doctorFee, int departmentId) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
        this.doctorFee = doctorFee;
        this.departmentId = departmentId;
    }

    // Getters and Setters
}