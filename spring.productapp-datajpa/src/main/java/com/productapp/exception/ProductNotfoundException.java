package com.productapp.exception;

public class ProductNotfoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotfoundException() {
		super();
	}

	public ProductNotfoundException(String message) {
		super(message);
	}

}
