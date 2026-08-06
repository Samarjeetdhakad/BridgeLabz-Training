package com.bridgelabz.jdbcpractice.model;

import lombok.Data;

@Data
public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String appointmentDate;
    private String status;

    public Appointment() {}
    public Appointment(int appointmentId,int patientId,  int doctorId,String appointmentDate,String status) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
    // Getters and Setters
}