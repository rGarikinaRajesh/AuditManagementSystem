package com.cognizant.AuditAuthenticationMicroservice.Exception;

public class TokenExpiredException extends RuntimeException {

	/**
	 * This class handles the UserNotFoundException exception this class extends the
	 * RuntimeException class.
	 * 
	 */
	private static final long serialVersionUID = 3518511691549884886L;

	/**
	 * 
	 * @param message
	 */
	public TokenExpiredException(String message) {
		super(message);
	}

}
