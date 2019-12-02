package org.wahlzeit.model;

public class IllegalCoordinateException extends RuntimeException{
	
	private static final long serialVersionUID = 1111111111111111111L;
	
	//Error Message to be displayed
	protected String errorMsg;
	
	//Error occurred in class...
	protected String className;
	
	protected double invalidValue;

	public IllegalCoordinateException(String errorMsg, String className, double invalidValue) {
		super("Exception for " + className + " object. Invalid value (" + invalidValue + "): " + errorMsg);
		this.errorMsg = errorMsg;
		this.className = className;
		this.invalidValue = invalidValue;
	}

	public double getInvalidValue() {
		return invalidValue;
	}
	
	public String getInvalidClass() {
		return className;
	}

	@Override
	public String getLocalizedMessage() {
		String message = super.getMessage();
		
		message += "Exception for " + className + " object. Invalid value (" + invalidValue + "): " + errorMsg;
		
		return message;
	}
}
