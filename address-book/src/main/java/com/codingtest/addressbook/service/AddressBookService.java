/**
 * 
 */
package com.codingtest.addressbook.service;

import org.springframework.stereotype.Service;

import com.codingtest.addressbook.model.Person;

/**
 * @author ROHAN-PC
 *
 */
@Service
public interface AddressBookService {
	
	 public long noOfPersonsByGender(String gender);
	 public Person oldestPersonInAddressBook();
	 public long noOfDaysDifference(String firstname,String otherPersonFirstname);
}
