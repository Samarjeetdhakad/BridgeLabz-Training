package com.fundoonotes.auth.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {

		return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateEmail(DuplicateEmailException ex) {

		return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex) {

		return buildResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
	}

	@ExceptionHandler(InvalidResetTokenException.class)
	public ResponseEntity<ErrorResponse> handleInvalidResetToken(InvalidResetTokenException ex) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(ResetTokenAlreadyUsedException.class)
	public ResponseEntity<ErrorResponse> handleResetTokenAlreadyUsed(ResetTokenAlreadyUsedException ex) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(ResetTokenExpiredException.class)
	public ResponseEntity<ErrorResponse> handleResetTokenExpired(ResetTokenExpiredException ex) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), status.value(), message);

		return ResponseEntity.status(status).body(errorResponse);
	}
}
