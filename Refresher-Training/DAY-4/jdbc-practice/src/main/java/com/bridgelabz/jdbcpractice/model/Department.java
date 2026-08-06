package com.bridgelabz.jdbcpractice.model;

import lombok.Data;

@Data
public class Department {
    private int departmentId;
    private String departmentName;

    public Department() {}
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    // Getters and Setters
}