package com.payroll.controller;

import java.util.List;

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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	 @PostMapping
	    public ResponseEntity<EmployeeResponseDTO> addEmployee( @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {

//		 if(EmployeeService.isEmailExists(employeeRequestDTO.getEmail()))
//		 return ResponseEntity
//	                .status(HttpStatus.CONFLICT)
//	                .body();
		 
	        EmployeeResponseDTO response = employeeService.createEmployee(employeeRequestDTO);
	        return ResponseEntity .status(HttpStatus.CREATED) .body(response);
	    }
	 
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
	    }

	  @PatchMapping("/{id}/salary")
	  public ResponseEntity<EmployeeResponseDTO> updateSalary( @PathVariable Long id, @Valid @RequestBody EmployeeSalaryUpdateDTO request) {
	      EmployeeResponseDTO response = employeeService.updateSalary(id, request);
	      return ResponseEntity.ok(response);
	  }

	    @GetMapping("/department/{departmentId}")
	    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment( @PathVariable Long departmentId) {
	        List<EmployeeResponseDTO> employees = employeeService.getEmployeesByDepartment(departmentId);
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

	        return ResponseEntity.ok(response);
	    }
	 
	 
}
