package com.poc;

public class CardNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CardNotFoundException() {
		super();
	}

	public CardNotFoundException(String message) {
		this.message = message;

	}

}
