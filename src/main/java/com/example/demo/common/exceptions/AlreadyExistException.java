package com.example.demo.common.exceptions;

import lombok.Getter;

@Getter
public class AlreadyExistException extends RuntimeException {
    private final int errorCode;

    public AlreadyExistException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
