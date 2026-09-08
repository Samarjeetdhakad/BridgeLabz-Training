package com.fundoonotes.notes.exception;

public class InvalidNoteStateException extends RuntimeException {

    public InvalidNoteStateException(String message) {
        super(message);
    }
}
