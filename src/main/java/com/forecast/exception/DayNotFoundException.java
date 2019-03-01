package com.forecast.exception;

public class DayNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8848161829848605323L;

	/**
	 * @param message
	 */
	public DayNotFoundException() {
		super("Day not found on DB");
	}

}
