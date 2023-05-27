package org.morozov.exception;

public class StorageIsEmptyException extends RuntimeException {
    public StorageIsEmptyException(String message) {
        super(message);
    }
}
