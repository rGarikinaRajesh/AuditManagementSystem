package com.cognizant.AuditChecklistServices.Exception;

public class AuditTypeNotFoundException extends RuntimeException {

	/**
	 * @version 1.8 This class is used for handling exception. When the AuditType
	 *          not found then this exception will be thrown. Here we are extending
	 *          {@link RuntimeException} which is an unchecked exception
	 *
	 */
	private static final long serialVersionUID = 1L;

	public AuditTypeNotFoundException(String message) {
		super(message);
	}

}
