package com.fundoo.exception;


public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(long noteId) {
        super("Note not found: " + noteId);
    }
}