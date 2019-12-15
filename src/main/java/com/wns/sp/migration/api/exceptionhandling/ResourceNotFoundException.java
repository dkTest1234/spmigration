package com.wns.sp.migration.api.exceptionhandling;

/**
 * Custom Exception class to handle the Resource Not Found Exception
 * @author Dilip
 *
 */
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 5L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
