/**
 * 
 */
package com.codingtest.addressbook.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codingtest.addressbook.model.ErrorCodes;
import com.codingtest.addressbook.model.Status;



/**
 * @author ROHAN-PC
 *
 */

@ControllerAdvice
public class ExceptionControllerAdvice {
	

	
	 /**
	    * 
	    * @param ioException
	    * @return
	    */
	   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	   @ResponseBody
	   @ExceptionHandler({IOException.class})
	   public Status handelIOException(IOException ioException) {

		   return new Status(ErrorCodes.DATA_LOAD_EXCEPTION.getErrorCode(),ErrorCodes.DATA_LOAD_EXCEPTION.getErrorMessage());
	   }
	   
	   
	
	 /**
	    * 
	    * @param exception
	    * @return
	    */
	   @ResponseStatus(HttpStatus.NO_CONTENT)
	   @ResponseBody
	   @ExceptionHandler({NoContentException.class})
	   public Status handleNoContent(NoContentException exception) {

		   return new Status(exception.getErrorCode(),exception.getErrorMessage());
	   }
}
