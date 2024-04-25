package com.inditex.endpoint.boot;

import com.inditex.endpoint.domain.exception.ErrorCatalog;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.exception.Severity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException (PriceNotFoundException exception) {
        final ErrorCatalog error = ErrorCatalog.ofCode(exception.getCode());
        return handleException(exception, error);
    }

    private ResponseEntity<Object> handleException(Exception exception, ErrorCatalog error) {
        printMessageInLog(error.getMessage(), exception, error.getSeverity());
        return ResponseEntity.status(error.getHttpStatus()).body(error.getMessage());
    }

    private void printMessageInLog(String message, Exception exception, Severity severity) {
        switch (severity) {
            case CRITICAL:
                LOG.error(message, exception);
                break;
            case ERROR:
                LOG.error(message, exception);
                break;
            case WARNING:
                LOG.warn(message, exception);
                break;
            default:
                LOG.info(message, exception);
                break;
        }
    }

}
