/**
 * 
 */
package com.codingtest.addressbook.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingtest.addressbook.exceptions.BadRequestException;
import com.codingtest.addressbook.exceptions.NoContentException;
import com.codingtest.addressbook.exceptions.ValidationException;
import com.codingtest.addressbook.model.AddressBookRequest;
import com.codingtest.addressbook.model.AddressBookResponse;
import com.codingtest.addressbook.model.ErrorCodes;
import com.codingtest.addressbook.model.Person;
import com.codingtest.addressbook.model.Response;
import com.codingtest.addressbook.model.Status;
import com.codingtest.addressbook.service.AddressBookService;
import com.codingtest.addressbook.utils.GlobalConstants;

/**
 * @author ROHAN-PC
 *
 */
@RestController
public class AddressBookController {
	
		@Autowired
		private AddressBookService addressBookService;
		
		/**
		 * This service returns the oldest {Person} from the Address Book.
		 * @return
		 * @throws ValidationException
		 * @throws NoContentException 
		 */
		@GetMapping("/address-book/persons/oldest")
		public ResponseEntity<Response> getOldestPerson() throws ValidationException, NoContentException  {
			Person oldestPerson= addressBookService.oldestPersonInAddressBook();
			Response response =new Response(new Status(200,GlobalConstants.STATUS_SUCCESS),new AddressBookResponse(0, oldestPerson, 0));
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			
		}
		
		
		/**
		 * 
		 * This service provides number of person for the gender.
		 * @param gender
		 * @return
		 * @throws IOException
		 * @throws ValidationException
		 * @throws BadRequestException 
		 */
		@GetMapping("/address-book/{gender}/persons")
		public ResponseEntity<Response> noOfPersonsByGender(@PathVariable String gender) throws  IOException,ValidationException, BadRequestException  {
			if(gender==null || gender.trim().length()==0) {
				throw new BadRequestException(ErrorCodes.BAD_REQUEST_GENDER);
			}
			long noOfPersonsByGender=addressBookService.noOfPersonsByGender(gender);
				Response response =new Response(new Status(200,GlobalConstants.STATUS_SUCCESS),new AddressBookResponse(noOfPersonsByGender, null, 0));
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			
		}
		
		
		/**
		 * This service returns the age difference in days between two persons in address book.
		 * @param addressBookRequest
		 * @return
		 * @throws IOException
		 * @throws ValidationException
		 */
		@PostMapping("/address-book/persons/ageDifference")
		public ResponseEntity<Response> noOfDaysDifference(@Valid @RequestBody AddressBookRequest addressBookRequest) throws  IOException,ValidationException  {
			long noOfDiffInDays=addressBookService.noOfDaysDifference(addressBookRequest.getPersonFirstname(), addressBookRequest.getAnotherPersonFirstname());
			Response response =new Response(new Status(200,GlobalConstants.STATUS_SUCCESS),new AddressBookResponse(0, null, noOfDiffInDays));
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			
		}
	

}
