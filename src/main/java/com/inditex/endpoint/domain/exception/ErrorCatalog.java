package com.inditex.endpoint.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ErrorCatalog {

    PRICE_NOT_FOUND("PRICE-000001",
        "Price not found with these parameters",
        HttpStatus.NOT_FOUND,
        Severity.WARNING),

    UNKNOWN("UNKNOWN",
        "Unknown validation error",
        HttpStatus.CONFLICT,
        Severity.WARNING);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
    private final Severity severity;

    public static ErrorCatalog ofCode(String code) {
        return Arrays.stream(values())
            .filter(value -> value.getCode().equals(code))
            .findFirst()
            .orElse(ErrorCatalog.UNKNOWN);
    }

}
