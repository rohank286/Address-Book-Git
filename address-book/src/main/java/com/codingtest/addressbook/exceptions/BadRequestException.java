/**
 * 
 */
package com.codingtest.addressbook.exceptions;

import com.codingtest.addressbook.model.ErrorCodes;

/**
 * @author ROHAN-PC
 *
 */
public class BadRequestException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7532484332821583190L;
	private int errorCode;
	private String errorMessage;
	
	/**
	 * 
	 * @param errorCodes
	 */
	public BadRequestException(ErrorCodes errorCodes) {
		this.errorCode = errorCodes.getErrorCode();
		this.errorMessage = errorCodes.getErrorMessage();
	}
	

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	

}
