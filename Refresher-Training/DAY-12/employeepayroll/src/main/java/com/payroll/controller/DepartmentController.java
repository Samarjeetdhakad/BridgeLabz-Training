package com.payroll.controller;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.dto.department.DepartmentRequestDTO;
import com.payroll.dto.department.DepartmentResponseDTO;
import com.payroll.service.department.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(
            @Valid @RequestBody DepartmentRequestDTO request) {
    	
    	 log.info("Received request to create department");
    	
        DepartmentResponseDTO response =  departmentService.createDepartment(request);
        
        log.info("Department created successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById( @PathVariable Long id) {
        
    	log.info("Received request to get department with id: {}", id);
    	
    	DepartmentResponseDTO response = departmentService.getDepartmentById(id);
        
    	log.info("Department retrieved successfully for id: {}", id);
    	
    	return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment( @PathVariable Long id, @Valid @RequestBody DepartmentRequestDTO request) {
        
    	 log.info("Received request to update department with id: {}", id);

    	 DepartmentResponseDTO response = departmentService.updateDepartment(id, request);
        
    	 log.info("Department updated successfully for id: {}", id);

    	 return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment( @PathVariable Long id) {
       
    	 log.info("Received request to delete department with id: {}", id);

    	departmentService.deleteDepartment(id);
        
    	log.info("Department deleted successfully for id: {}", id);
    	
    	return ResponseEntity.noContent().build();
    }
    
    //pagination and sorting
    @GetMapping
    public ResponseEntity<Page<DepartmentResponseDTO>> getAllDepartments(
    		@RequestParam(defaultValue = "0" ) int page,
    		@RequestParam (defaultValue = "") int size,
    		@RequestParam (defaultValue = "id") String sortby,
    		@RequestParam (defaultValue = "asc" )String direction
    		) {
    	
    	 log.info(
    	            "Received request to get departments. page={}, size={}, sortBy={}, direction={}",
    	            page, size, sortby, direction
    	        );
    	 
    	Page<DepartmentResponseDTO> response = departmentService.getAllDepartments(page , size, sortby, direction);
    	
    	 log.info(
    	            "Departments retrieved successfully:"
    	        );
    	 
		return ResponseEntity.ok(response);
       
    }
    
    
    
    
}