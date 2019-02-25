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
	DATA_LOAD_EXCEPTION(601,"Error while loading the addressbook");
	
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
