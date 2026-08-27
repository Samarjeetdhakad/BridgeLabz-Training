package com.fundoo.exception;


public class UnathorizedNoteAccessException
        extends RuntimeException {

    public UnathorizedNoteAccessException() {
        super("You are not authorized to access this note");
    }
}