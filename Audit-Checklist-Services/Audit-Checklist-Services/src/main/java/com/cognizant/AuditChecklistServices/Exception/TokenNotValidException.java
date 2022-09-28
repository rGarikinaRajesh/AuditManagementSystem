package com.cognizant.AuditChecklistServices.Exception;

public class TokenNotValidException extends Exception {

	/**
	 * @version 1.8 This class is used for handling exception. When the token is not
	 *          a valid one then this exception will be thrown
	 */
	private static final long serialVersionUID = 1L;

	public TokenNotValidException(String message) {
		super(message);
	}

}
