package pro.sky.employee_book_mockito.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class EmployeeControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> employeeAlreadyAddedExceptionHandler(IllegalArgumentException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
}
