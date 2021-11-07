package com.example.demo.common;

import com.example.demo.common.exceptions.AlreadyExistException;
import com.example.demo.common.exceptions.AnimalNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistException(AlreadyExistException e) {
        ErrorResponse errorResponse =
                new ErrorResponse(HttpStatus.BAD_REQUEST, ErrorCode.ANIMAL_ALREADY_EXIST.getErrorCode(),
                        ErrorCode.ANIMAL_ALREADY_EXIST.getErrorMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(AnimalNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAnimalNotFoundException(AnimalNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ErrorCode.ANIMAL_NOT_FOUND.getErrorCode(),
                ErrorCode.ANIMAL_NOT_FOUND.getErrorMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
