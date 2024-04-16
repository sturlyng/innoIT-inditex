package com.inditex.endpoint.domain.exception;

import java.io.Serial;

public class PriceNotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 4104695584451332907L;

	public PriceNotFoundException(String message) {
		super(message);
	}
	
}
