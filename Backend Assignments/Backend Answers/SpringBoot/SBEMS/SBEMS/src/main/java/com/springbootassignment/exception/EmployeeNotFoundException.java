package com.springbootassignment.exception;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	// Default constructor
	public EmployeeNotFoundException() {
		super();
	}
	
	// Constructor with custom error message
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	// Constructor with custom error message and cause
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	// Constructor with a cause
	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}
	
	// Constructor with custom error message, a cause, and options for suppression and stack trace
	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
