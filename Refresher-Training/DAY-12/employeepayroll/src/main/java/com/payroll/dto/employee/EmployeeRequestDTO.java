package com.payroll.dto.employee;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
	    name = "EmployeeRequest",
	    description = "Request payload used to create or update an employee"
	)
@Data
public class EmployeeRequestDTO {

	@Schema(
	        description = "Full name of the employee",
	        example = "Rahul Sharma",
	        requiredMode = Schema.RequiredMode.REQUIRED
	    )
    @NotBlank(message = "Employee name is required")
    private String name;

	 @Schema(
		        description = "Unique email address of the employee",
		        example = "rahul.sharma@gmail.com",
		        requiredMode = Schema.RequiredMode.REQUIRED
		    )
    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;

	@Schema(
		        description = "Contact phone number of the employee",
		        example = "9876543210"
		    )
    @NotBlank(message = "Phone number is required")
    @Pattern( regexp = "^[0-9]{10}$",  message = "Phone number must contain exactly 10 digits")
    private String phone;

	 @Schema(
		        description = "Monthly salary of the employee",
		        example = "75000.00",
		        requiredMode = Schema.RequiredMode.REQUIRED
		    )
    @NotNull(message = "Salary is required")
    @DecimalMin( value = "0.0", inclusive = false, message = "Salary must be greater than 0" )
    private BigDecimal salary;

	 @Schema(
		        description = "ID of the department assigned to the employee",
		        example = "1",
		        requiredMode = Schema.RequiredMode.REQUIRED
		    )
    @NotNull(message = "Department ID is required")
    private Long departmentId;
}