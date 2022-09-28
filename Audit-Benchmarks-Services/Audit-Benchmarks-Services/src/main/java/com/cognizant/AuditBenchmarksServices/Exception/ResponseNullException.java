package com.cognizant.AuditBenchmarksServices.Exception;

public class ResponseNullException extends RuntimeException {

	/**
	 * @version 1.8 This class is used for handling exception. When the
	 *          ResponseNullException found then this exception will be thrown. Here
	 *          we are extending {@link RuntimeException} which is an unchecked
	 *          exception
	 *
	 */
	private static final long serialVersionUID = 6167668598205258632L;

	public ResponseNullException(String message) {
		super(message);
	}

}
