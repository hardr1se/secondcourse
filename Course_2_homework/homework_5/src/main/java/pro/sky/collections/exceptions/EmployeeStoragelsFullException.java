package pro.sky.collections.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeStoragelsFullException extends RuntimeException {
    public EmployeeStoragelsFullException(String message) {
        super(message);
    }
}
