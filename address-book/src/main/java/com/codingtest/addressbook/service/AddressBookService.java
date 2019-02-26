/**
 * 
 */
package com.codingtest.addressbook.service;

import java.io.IOException;

import com.codingtest.addressbook.exceptions.NoContentException;
import com.codingtest.addressbook.exceptions.ValidationException;
import com.codingtest.addressbook.model.Person;

/**
 * @author ROHAN-PC
 *
 */

public interface AddressBookService {

	 public long noOfPersonsByGender(String gender) throws IOException;
	 public Person oldestPersonInAddressBook() throws ValidationException, NoContentException;
	 public long noOfDaysDifference(String firstname,String otherPersonFirstname) throws ValidationException; 

}
