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
import org.springframework.web.server.MethodNotAllowedException;

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
	    * @param validationException
	    * @return
	    */
	   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	   @ResponseBody
	   @ExceptionHandler({ValidationException.class})
	   public Status handelValidationException(ValidationException validationException) {
		   return new Status(validationException.getErrorCode(),validationException.getErrorMessage());
	   }
	   
	   
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
	   @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	   @ResponseBody
	   @ExceptionHandler({MethodNotAllowedException.class})
	   public Status methodTypeInvalid(MethodNotAllowedException exception) {

		   return new Status(HttpStatus.METHOD_NOT_ALLOWED.value(),exception.getMessage());
	   }
	   
	   
	   /**
	    * 
	    * @param exception
	    * @return
	    */
	   @ResponseStatus(HttpStatus.BAD_REQUEST)
	   @ResponseBody
	   @ExceptionHandler({BadRequestException.class})
	   public Status handleBadRequest(BadRequestException exception) {

		   return new Status(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
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
