package com.forecast.exception;

public class InvalidDayException extends RuntimeException {

	private static final long serialVersionUID = 1373703214721424838L;

	/**
	 * @param arg0
	 */
	public InvalidDayException() {
		super("Invalid day entered: please enter a value between [1-3560]");
	}
	
	

}
