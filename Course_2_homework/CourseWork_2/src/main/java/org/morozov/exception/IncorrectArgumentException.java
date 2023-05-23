package org.morozov.exception;

public class IncorrectArgumentException extends RuntimeException {
    public IncorrectArgumentException(String message) {
        super(message);
    }
}
