package com.inditex.endpoint.domain.exception;

public class PriceNotFoundException extends Exception{

	private static final long serialVersionUID = 4104695584451332907L;

	public PriceNotFoundException(String message) {
		super(message);
	}
	
}
