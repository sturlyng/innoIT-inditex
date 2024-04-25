package com.inditex.endpoint.domain.exception;

import lombok.Getter;

@Getter
public class PriceNotFoundException extends RuntimeException {

	private final String code;

	public PriceNotFoundException(String code, String message) {
		super(message);
		this.code = code;
	}
	
}
