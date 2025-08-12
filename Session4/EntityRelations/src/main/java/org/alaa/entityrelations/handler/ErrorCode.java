package org.alaa.entityrelations.handler;

import lombok.Getter;

@Getter
public enum ErrorCode {

    RESOURCE_NOT_FOUND("E001","Resource Not Found"),
    BAD_REQUEST("E002","validation Error");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
