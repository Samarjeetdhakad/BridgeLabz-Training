package com.fundoonotes.notes.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoteNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoteNotFound(NoteNotFoundException ex) {

		return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(TagNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleTagNotFound(TagNotFoundException ex) {

		return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(DuplicateTagException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateTag(DuplicateTagException ex) {

		return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
	}

	@ExceptionHandler(InvalidNoteStateException.class)
	public ResponseEntity<ErrorResponse> handleInvalidNoteState(InvalidNoteStateException ex) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), status.value(), message);

		return ResponseEntity.status(status).body(errorResponse);
	}
}
