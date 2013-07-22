package com.plivo.helper.android.exception;

/*
 * Android SDK's Exception
 */
public class AndroidClientException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public AndroidClientException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}	
}

