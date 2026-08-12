package com.samar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDTO {
	
	@NotBlank(message = "first name is required")
	@Size(min = 2, max = 50)
	private String firstName;
	

	@NotBlank(message = "last name is required")
	@Size(min = 2, max = 50)
	private String lastName;
	
	@NotBlank(message = "email is required")
	@Email(message = "enter valid email")
	private String email;
	
	
	@NotBlank(message = "phone is required")
	@Pattern(regexp = "^[0-9]{10}$",
	                            message = "number must contain 10 digits ")
	private String phone;
	
	@NotBlank(message = "phone is required")
	@Pattern(regexp = "^[0-9]{10}$",
	                            message = "alternate number  must contain 10 digits ")
	private String alternatePhone;
	
	
	
}
