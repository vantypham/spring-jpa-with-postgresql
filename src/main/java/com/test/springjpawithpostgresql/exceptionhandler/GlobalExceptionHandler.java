package com.test.springjpawithpostgresql.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Validate for invalid argument
     * MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidArgument(MethodArgumentNotValidException ex) {
        HashMap map = new HashMap();
        ex.getBindingResult().getFieldErrors().forEach((fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }));
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    /**
     * Validate for invalid argument
     * MethodArgumentTypeMismatchException
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleInvalidArgument(MethodArgumentTypeMismatchException ex) {
        HashMap map = new HashMap();
        map.put(ex.getName(), ex.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        return new ResponseEntity<>("An Exception occurred at the Global scope - "+ ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
