package com.fundoonotes.notes.exception;

public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(int noteId) {
        super("Note not found: " + noteId);
    }
}
