package com.done.RegistrationService.exception;

public class EnvironmentVariableNotFoundException extends RuntimeException {
    public EnvironmentVariableNotFoundException(String message) {
        super(message);
    }
}
