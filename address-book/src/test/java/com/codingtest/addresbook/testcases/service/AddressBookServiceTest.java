/**
 * 
 */
package com.codingtest.addresbook.testcases.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.codingtest.addresbook.testcases.utils.AssertConstants;
import com.codingtest.addresbook.testcases.utils.StubDataProvider;
import com.codingtest.addressbook.model.Person;
import com.codingtest.addressbook.repo.AddressBookRepo;
import com.codingtest.addressbook.service.AddressBookService;
import com.codingtest.addressbook.service.AddressBookServiceImpl;

/**
 * @author ROHAN-PC
 *
 */
public class AddressBookServiceTest {
	
	@Mock
	private AddressBookRepo addressBookRepo;
	
	@InjectMocks
	private AddressBookService addressBookService=new AddressBookServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_oldestPersonInAddressBook() throws Exception {
		
			Mockito.when(addressBookRepo.loadAddressBook()).thenReturn(StubDataProvider.stubPeopleStream());
			Person person=addressBookService.oldestPersonInAddressBook();
			Assert.assertNotNull(person);
			Assert.assertEquals(AssertConstants.ASSERT_NAME_WES, person.getFirstname().trim());
		}
	
	
	@Test
	public void test_noOfPersonsByGender() throws Exception{
			Mockito.when(addressBookRepo.loadAddressBook()).thenReturn(StubDataProvider.stubPeopleStream());
			long noOfPersons=addressBookService.noOfPersonsByGender(AssertConstants.ASSERT_GENDER_MALE);
			Assert.assertEquals(3, noOfPersons);
		}
	
	
	@Test
	public void test_noOfDaysDifference() throws Exception {
		
			Mockito.when(addressBookRepo.loadAddressBook()).thenReturn(StubDataProvider.stubPeopleStream());
			long noOfDays=addressBookService.noOfDaysDifference(AssertConstants.ASSERT_NAME_BILL, AssertConstants.ASSERT_NAME_PAUL);
			Assert.assertEquals(2862, noOfDays);
		}
	
	
	

}
