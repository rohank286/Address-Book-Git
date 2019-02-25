/**
 * 
 */
package com.codingtest.addressbook.repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.codingtest.addressbook.model.Person;
import com.codingtest.addressbook.utils.GlobalConstants;

/**
 * This class loads the address book into stream of string.
 * @author ROHAN-PC
 *
 */
@Repository
public class AddressbookRepoImpl implements AddressBookRepo {

	
	private static final Logger logger = LoggerFactory.getLogger(AddressbookRepoImpl.class);
	
	/**
	 *Method loads the data from file to {Stream<String>}
	 */
	@Override
	public Stream<Person> loadAddressBook() throws IOException {
		
		File fileToLoad = ResourceUtils.getFile(GlobalConstants.ADDRESS_BOOK_FILE);
		logger.debug("Loading Address from File :: "+fileToLoad.getAbsolutePath());
		return Files.lines(Paths.get(fileToLoad.getAbsolutePath()))
		.map(line -> line.split(GlobalConstants.DELIM_COMMA))
		.map(splittedRow -> new Person(splittedRow[0], splittedRow[1], splittedRow[2]));
		
		
	}

}
