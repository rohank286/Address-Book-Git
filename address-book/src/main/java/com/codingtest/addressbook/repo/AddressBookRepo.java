/**
 * 
 */
package com.codingtest.addressbook.repo;

import java.io.IOException;
import java.util.stream.Stream;

import com.codingtest.addressbook.model.Person;

/**
 * @author ROHAN-PC
 *
 */

public interface AddressBookRepo {
	
	public Stream<Person> loadAddressBook() throws IOException;

}
 