package com.payroll.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleDepartmentNotFound(
            DepartmentNotFoundException exception) {

    	 log.warn("Department not found: {}", exception.getMessage());
    	 
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(  HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleEmployeeNotFound(
            EmployeeNotFoundException exception) {

    	log.warn("Employee not found: {}", exception.getMessage());
    	
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse,  HttpStatus.NOT_FOUND );
    }
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException exception) {
       
    	 log.warn("Validation error occurred while processing request");
    	 
    	Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->{
			                log.warn(
			                        "Validation failed - field: {}, message: {}",
			                        error.getField(), error.getDefaultMessage());
                        
			                errors.put( error.getField(), error.getDefaultMessage());
                        } );

        return  ResponseEntity.status( HttpStatus.BAD_REQUEST).body(errors);         
        
    }
    
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception exception) {

        log.error("Unexpected error occurred", exception);

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong",  LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    
    
}