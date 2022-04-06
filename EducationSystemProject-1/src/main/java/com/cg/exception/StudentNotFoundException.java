package com.cg.exception;

public class StudentNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException() {
		super();

	}

	public StudentNotFoundException(final String message) {
		super(message);

	}

}
