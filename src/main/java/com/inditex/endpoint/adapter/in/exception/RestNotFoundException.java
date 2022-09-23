package com.inditex.endpoint.adapter.in.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class RestNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5876102253830309227L;
	
	private final int httpCode;

	public RestNotFoundException(String message) {
		super(message);
		this.httpCode = HttpStatus.NOT_FOUND.value();
	}
	
}
