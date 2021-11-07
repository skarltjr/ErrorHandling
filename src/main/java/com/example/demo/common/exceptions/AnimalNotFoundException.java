package com.example.demo.common.exceptions;

import lombok.Getter;

@Getter
public class AnimalNotFoundException extends RuntimeException {
    private final int errorCode;

    public AnimalNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
