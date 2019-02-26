/**
 * 
 */
package com.codingtest.addressbook.model;

/**
 * @author ROHAN-PC
 *
 */
public enum ErrorCodes {
	
	NO_CONTENT(204,"No Content"),
	BAD_REQUEST_GENDER(400,"Input variable gender is null or empty."),
	DATA_LOAD_EXCEPTION(601,"Error while loading the addressbook"),
	PERSON_NOT_FOUND(602,"Person name provided is not in addressbook"),
	GENERIC_EXCEPTION(604,"Something went wrong.");
	
	private final int errorCode;
    private final String errorMessage;
	
   
    
    ErrorCodes(int code,String message) {
		this.errorCode=code;
		this.errorMessage=message;
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
