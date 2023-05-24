package pro.sky.StringList.exception;

public class StorageOverflowException extends RuntimeException {
    public StorageOverflowException() {
    }

    public StorageOverflowException(String message) {
        super(message);
    }
}
