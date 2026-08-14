package com.payroll.dto.employee;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeRequestDTO {

    @NotBlank(message = "Employee name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern( regexp = "^[0-9]{10}$",  message = "Phone number must contain exactly 10 digits")
    private String phone;

    @NotNull(message = "Salary is required")
    @DecimalMin( value = "0.0", inclusive = false, message = "Salary must be greater than 0" )
    private BigDecimal salary;

    @NotNull(message = "Department ID is required")
    private Long departmentId;
}