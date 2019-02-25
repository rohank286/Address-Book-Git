/**
 * 
 */
package com.codingtest.addressbook.exceptions;

import com.codingtest.addressbook.model.ErrorCodes;

/**
 * @author ROHAN-PC
 *
 */
public class ValidationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8383562368363383788L;
	private int errorCode;
	private String errorMessage;
	
	/**
	 * 
	 * @param errorCodes
	 */
	public ValidationException(ErrorCodes errorCodes) {
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
