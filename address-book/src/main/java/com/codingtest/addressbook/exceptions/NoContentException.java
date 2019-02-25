/**
 * 
 */
package com.codingtest.addressbook.exceptions;

import com.codingtest.addressbook.model.ErrorCodes;

/**
 * @author ROHAN-PC
 *
 */
public class NoContentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4096659046704274886L;
	private int errorCode;
	private String errorMessage;
	
	/**
	 * 
	 * @param errorCodes
	 */
	public NoContentException(ErrorCodes errorCodes) {
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
