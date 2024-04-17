package com.inditex.endpoint.boot;

import com.inditex.endpoint.domain.exception.ErrorCatalog;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    public void testHandlePriceNotFoundException() {
        PriceNotFoundException exception = new PriceNotFoundException(ErrorCatalog.PRICE_NOT_FOUND.getCode(),
                ErrorCatalog.PRICE_NOT_FOUND.getMessage());
        ResponseEntity<Object> responseEntity = globalExceptionHandler.handlePriceNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Price not found with these parameters", responseEntity.getBody());
    }

}