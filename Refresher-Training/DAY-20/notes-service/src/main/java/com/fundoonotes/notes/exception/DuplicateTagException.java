package com.fundoonotes.notes.exception;

public class DuplicateTagException extends RuntimeException {

    public DuplicateTagException(String tagName) {
        super("Tag already exists: " + tagName);
    }
}
