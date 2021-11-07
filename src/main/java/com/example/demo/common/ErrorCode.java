package com.example.demo.common;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ANIMAL_NOT_FOUND(1001, "해당 동물이 없습니다."),
    ANIMAL_ALREADY_EXIST(2001,"해당 이름의 동물이 이미 존재합니다");

    private int errorCode;
    private String errorMessage;

    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
