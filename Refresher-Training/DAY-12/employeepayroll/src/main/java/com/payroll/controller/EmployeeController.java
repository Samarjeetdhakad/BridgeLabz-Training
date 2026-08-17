package com.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.dto.employee.EmployeeRequestDTO;
import com.payroll.dto.employee.EmployeeResponseDTO;
import com.payroll.dto.employee.EmployeeSalaryUpdateDTO;
import com.payroll.service.employee.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(
		name = "Employee Management",
		description = "APIs for managing employess"
		)
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	private final EmployeeService employeeService;
	
	@Operation(
			summary = "Create a new Employee",
			description = "creates a new employee and assigns the employee to a department"
			)
	@ApiResponses({
		@ApiResponse(
				responseCode = "201",
				description = "Employee created successfully"
				),
		@ApiResponse(
				responseCode = "400",
				description = "Invalid employee data"
				)
	})
	
	 @PostMapping
	    public ResponseEntity<EmployeeResponseDTO> addEmployee( @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {

		//LOG
		log.info("Creating employee with email: {}",employeeRequestDTO.getEmail());
	        
		EmployeeResponseDTO response = employeeService.createEmployee(employeeRequestDTO);
	    
		log.info("Employee created successfully with email: {}",employeeRequestDTO.getEmail());
		
		return ResponseEntity .status(HttpStatus.CREATED) .body(response);
	    
	}
	 
	
	@Operation(
		    summary = "Delete an employee",
		    description = "Deletes an employee using the employee ID"
		)
	@ApiResponses({
		    @ApiResponse(
		        responseCode = "204",
		        description = "Employee deleted successfully"
		    ),
		    @ApiResponse(
		        responseCode = "404",
		        description = "Employee not found"
		    )
		})
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployee(
	    		@Parameter(
	    		description = "Unique id of the employee",
	    		example = "1"
	    		)@PathVariable Long id) 
	{
		
	        employeeService.deleteEmployee(id);
	        
	        log.info("Employee deleted successfully with id: {}", id);
	        
	        return ResponseEntity.noContent().build();
	        
	    }

	
	@Operation(
		    summary = "Update employee salary",
		    description = "Updates the salary of an existing employee"
		)
	@ApiResponses({
		    @ApiResponse(
		        responseCode = "200",
		        description = "Salary updated successfully"
		    ),
		    @ApiResponse(
		        responseCode = "400",
		        description = "Invalid salary"
		    ),
		    @ApiResponse(
		        responseCode = "404",
		        description = "Employee not found"
		    )
		})
	  @PatchMapping("/{id}/salary")
	  public ResponseEntity<EmployeeResponseDTO> updateSalary( @PathVariable Long id, @Valid @RequestBody EmployeeSalaryUpdateDTO request) {
	      
		EmployeeResponseDTO response = employeeService.updateSalary(id, request);
	     
	      log.info("Salary updated successfully for employee with id: {}", id);

	      return ResponseEntity.ok(response);
	  }

	    @GetMapping("/department/{departmentId}")
	    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment( @PathVariable Long departmentId) {
	        List<EmployeeResponseDTO> employees = employeeService.getEmployeesByDepartment(departmentId);
	        
	        log.info("Successfully fetched {} employees for department id: {}",
	                employees.size(), departmentId);
	        
	        return ResponseEntity.ok(employees);
	    }
	 
	 // get by pagination and sorting 
	    @GetMapping
	    public ResponseEntity<Page<EmployeeResponseDTO>> getAllEmployees(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam(defaultValue = "id") String sortBy,
	            @RequestParam(defaultValue = "asc") String direction) {

	        Page<EmployeeResponseDTO> employees = employeeService.getAllEmployees(page, size, sortBy, direction);

	        return ResponseEntity.ok(employees);
	    }
	    
	    @GetMapping("/email/{email}")
	    public ResponseEntity<EmployeeResponseDTO> getEmployeeByEmail(
	            @PathVariable String email) {

	        EmployeeResponseDTO response =
	                employeeService.getEmployeeByEmail(email);
	       
	      
	        log.info("Employee fetched successfully with email: {}", email);

	        return ResponseEntity.ok(response);
	    }
	 
	 
}
