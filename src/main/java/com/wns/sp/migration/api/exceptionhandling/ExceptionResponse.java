package com.wns.sp.migration.api.exceptionhandling;

import java.io.Serializable;

/**
 * Exception Response class.
 * @author Dilip
 *
 */
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 5L;
	
	private String statusCode;
	private String errorMessage;
	private String requestedURI;

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void callerURL(String requestedURI) {
		this.requestedURI = requestedURI;
	}
}
