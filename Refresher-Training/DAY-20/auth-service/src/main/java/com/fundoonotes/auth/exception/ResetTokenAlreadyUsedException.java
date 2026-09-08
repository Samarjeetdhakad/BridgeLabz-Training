package com.fundoonotes.auth.exception;

public class ResetTokenAlreadyUsedException extends RuntimeException {

    public ResetTokenAlreadyUsedException() {
        super("Recovery token has already been used");
    }
}
