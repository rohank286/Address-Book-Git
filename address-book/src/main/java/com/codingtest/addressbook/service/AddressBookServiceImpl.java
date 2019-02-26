/**
 * 
 */
package com.codingtest.addressbook.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingtest.addressbook.exceptions.NoContentException;
import com.codingtest.addressbook.exceptions.ValidationException;
import com.codingtest.addressbook.model.ErrorCodes;
import com.codingtest.addressbook.model.Person;
import com.codingtest.addressbook.repo.AddressBookRepo;
import com.codingtest.addressbook.utils.DateTimeHelper;

/**
 * @author ROHAN-PC
 *
 */
@Service
public class AddressBookServiceImpl implements AddressBookService {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressBookServiceImpl.class);
	@Autowired
	private AddressBookRepo addressBookRepo;

	@Override
	public long noOfPersonsByGender(String gender) throws IOException {
		 return addressBookRepo.loadAddressBook()
			.filter(person -> person.getGender().equalsIgnoreCase(gender))
			.count();
		}

	@Override
	public Person oldestPersonInAddressBook() throws ValidationException, NoContentException  {
		
		
		try {
			Optional<Person> optionalOldestPerson = addressBookRepo.loadAddressBook()
				.sorted((person1,person2) -> person1.getBirthdate().compareTo(person2.getBirthdate()))
				.findFirst();
			
			if(!optionalOldestPerson.isPresent()) throw new NoContentException(ErrorCodes.NO_CONTENT);
			return optionalOldestPerson.get();
			
		} catch (IOException e) {
			logger.error(e.getMessage());
			 
			throw new ValidationException(ErrorCodes.DATA_LOAD_EXCEPTION);
			
		}
		
	}

	/**
	 * 
	 */
	@Override
	public long noOfDaysDifference(String firstname, String otherPersonFirstname) throws ValidationException {
		
		long noOfDaysDifference =-1;
		List<Person> personList= null;
		try {
			 personList=addressBookRepo.loadAddressBook()
			.filter(person -> person.getFirstname().equals(firstname) || person.getFirstname().equals(otherPersonFirstname) )
			.sorted((person1,person2) -> person1.getBirthdate().compareTo(person2.getBirthdate()))
			.collect(Collectors.toList());
			 
			 if(personList!=null && personList.size()==2) {
				 
				 Optional<Person> optionalPerson = getPersonByFirstname(personList.stream(), firstname);
				 Optional<Person> optionalOtherPerson = getPersonByFirstname(personList.stream(), otherPersonFirstname);
				 
				 if(!optionalPerson.isPresent() || !optionalOtherPerson.isPresent()) {
					 throw new ValidationException(ErrorCodes.PERSON_NOT_FOUND);
				 }
				 
				 noOfDaysDifference = DateTimeHelper.differenceInDays(optionalPerson.get().getBirthdate(), optionalOtherPerson.get().getBirthdate());
				 
				 
			 }
			 
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new ValidationException(ErrorCodes.DATA_LOAD_EXCEPTION);
			
		}
		
		return noOfDaysDifference;
	}
	
	
	/**
	 * 
	 * @param stream
	 * @param firstname
	 * @return
	 */
	private   Optional<Person> getPersonByFirstname(Stream<Person> stream, String firstname) {
		
		return stream.filter(person -> person.getFirstname().equals(firstname))
		.findFirst();
	} 

	
}
