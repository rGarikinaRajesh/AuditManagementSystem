package com.cognizant.AuditAuthenticationMicroservice.Exception;

public class LoginFailedException extends RuntimeException {

	/**
	 * 
	 * This class handles the LoginFailedException exception this class extends the
	 * RuntimeException class.
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public LoginFailedException(String message) {
		super(message);

	}

}
