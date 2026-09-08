package com.fundoonotes.auth.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int userId) {
        super("User not found: " + userId);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
