
package com.fundoo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fundoo.dto.user.ErrorResponseDTO;
import com.fundoo.exception.DuplicateEmailException;
import com.fundoo.exception.InvalidNoteStateException;
import com.fundoo.exception.NoteNotFoundException;
import com.fundoo.exception.UnathorizedNoteAccessException;
import com.fundoo.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	// Duplicate email
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<ErrorResponseDTO> handleDuplicateEmail(DuplicateEmailException e) {

		logger.warn("Duplicate email: {}", e.getMessage());

		ErrorResponseDTO response = new ErrorResponseDTO(e.getMessage(), HttpStatus.CONFLICT.value());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}

	// Note not found
	@ExceptionHandler(NoteNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleNoteNotFound(NoteNotFoundException e) {

		ErrorResponseDTO response = new ErrorResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	// User not found
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleUserNotFound(UserNotFoundException e) {

		ErrorResponseDTO response = new ErrorResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	// Invalid state
	@ExceptionHandler(InvalidNoteStateException.class)
	public ResponseEntity<ErrorResponseDTO> handleInvalidState(InvalidNoteStateException e) {

		ErrorResponseDTO response = new ErrorResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Unauthorized note access
	@ExceptionHandler(UnathorizedNoteAccessException.class)
	public ResponseEntity<ErrorResponseDTO> handleUnauthorized(UnathorizedNoteAccessException e) {

		ErrorResponseDTO response = new ErrorResponseDTO(e.getMessage(), HttpStatus.FORBIDDEN.value());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	}

	// Validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDTO> handleValidation(MethodArgumentNotValidException e) {

		String message = e.getBindingResult().getFieldError().getDefaultMessage();

		ErrorResponseDTO response = new ErrorResponseDTO(message, HttpStatus.BAD_REQUEST.value());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Unexpected exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDTO> handleUnexpected(Exception e) {

		logger.error("Unexpected error occurred", e);

		ErrorResponseDTO response = new ErrorResponseDTO("An unexpected error occurred",
				HttpStatus.INTERNAL_SERVER_ERROR.value());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}