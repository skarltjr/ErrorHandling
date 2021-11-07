package com.example.demo.common;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private int errorCode;
    private String message;

    public ErrorResponse(HttpStatus httpStatus,int errorCode,String message) {
        this.timeStamp = LocalDateTime.now();
        this.status = httpStatus.value();
        this.errorCode = errorCode;
        this.message = message;
    }
}
