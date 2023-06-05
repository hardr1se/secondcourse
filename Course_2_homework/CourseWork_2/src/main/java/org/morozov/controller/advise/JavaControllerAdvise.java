package org.morozov.controller.advise;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.MethodNotAllowedException;
import org.morozov.exception.NotFoundElementException;
import org.morozov.exception.StorageIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JavaControllerAdvise {
    @ExceptionHandler(IncorrectArgumentException.class)
    public ResponseEntity<String> incorrectArgumentExceptionHandler(IncorrectArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NotFoundElementException.class)
    public ResponseEntity<String> notFoundElementExceptionHandler(NotFoundElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(StorageIsEmptyException.class)
    public ResponseEntity<String> storageIsEmptyExceptionHandler(StorageIsEmptyException e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<String> methodNotAllowedExceptionHandler(MethodNotAllowedException e) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(e.getMessage());
    }
}
