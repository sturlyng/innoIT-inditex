package com.inditex.endpoint.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@AllArgsConstructor
@Getter
@ToString
public enum Severity {

    CRITICAL("critical"),
    ERROR("error"),
    WARNING("warning"),
    INFO("info");


    private final String value;

    public static Severity fromValue(String value) {
        return Arrays.stream(Severity.values())
                .filter(severity -> severity.value.equals(value) || severity.name().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unexpected severity value '%s'", value)));
    }

}
