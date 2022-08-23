package com.payments.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8291648835672204821L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}

