package com.payroll.dto.employee;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EmployeeResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private BigDecimal salary;

    private Long departmentId;
}