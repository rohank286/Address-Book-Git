/**
 * 
 */
package com.codingtest.addresbook.testcases.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.codingtest.addressbook.controller.AddressBookController;
import com.codingtest.addressbook.exceptions.ExceptionControllerAdvice;
import com.codingtest.addressbook.exceptions.NoContentException;
import com.codingtest.addressbook.exceptions.ValidationException;
import com.codingtest.addressbook.model.AddressBookRequest;
import com.codingtest.addressbook.model.ErrorCodes;
import com.codingtest.addressbook.model.Person;
import com.codingtest.addressbook.service.AddressBookService;
import com.codingtest.addressbook.utils.GlobalConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ROHAN-PC
 *
 */
public class AddressBookControllerTests {
	
	private MockMvc mockMvc;
	
	@Mock
	private AddressBookService addressBookService;
	
	@InjectMocks
	private AddressBookController addressBookController=new AddressBookController();
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(addressBookController).setControllerAdvice(ExceptionControllerAdvice.class).build();
	}
	
	
	
	@Test
	public void test_oldestPersonInAddressBook_Success() throws Exception {
		   
		   Person person =new Person("Paul Robinson", "Male", "15/01/85");
	       Mockito.when(addressBookService.oldestPersonInAddressBook()).thenReturn(person);
		   
	       mockMvc.perform(get("/address-book/persons/oldest"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"status\":{\"statusCode\":200,\"statusMessage\":\"Sucess\"},\"data\":{\"noOfPersons\":0,\"oldestPerson\":{\"firstname\":\"Paul\",\"lastname\":\"Robinson\",\"gender\":\"Male\",\"birthdate\":\"15-01-1985\"},\"noOfDaysDifference\":0}}"));
	}
	
	@Test
	public void test_oldestPersonInAddressBook_NoContent() throws Exception {
		   
		  
	       Mockito.when(addressBookService.oldestPersonInAddressBook()).thenThrow(new NoContentException(ErrorCodes.NO_CONTENT));
		   
	       mockMvc.perform(get("/address-book/persons/oldest")) 
	       .andDo(print())
			.andExpect(status().isNoContent())
			.andExpect(content().json("{\"statusCode\":204,\"statusMessage\":\"No Content\"}"));
	}
	
	@Test
	public void test_oldestPersonInAddressBook_ValidationException() throws Exception {
		   
		  
	       Mockito.when(addressBookService.oldestPersonInAddressBook()).thenThrow(new ValidationException(ErrorCodes.DATA_LOAD_EXCEPTION));
		   
	       mockMvc.perform(get("/address-book/persons/oldest")) 
	       .andDo(print())
			.andExpect(status().isInternalServerError())
			.andExpect(content().json("{\"statusCode\":601,\"statusMessage\":\"Error while loading the addressbook\"}"));
	}
	
	
	@Test
	public void test_noOfMales_Success() throws Exception {
		   
		   String gender="Male";
	       Mockito.when(addressBookService.noOfPersonsByGender(gender)).thenReturn((long) 3);
		   
	       mockMvc.perform(get("/address-book/"+gender+"/persons"))
	       .andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().json("{\"status\":{\"statusCode\":200,\"statusMessage\":\"Sucess\"},\"data\":{\"noOfPersons\":3,\"oldestPerson\":null,\"noOfDaysDifference\":0}}"));
	}
	
	@Test
	public void test_noOfFemales_Success() throws Exception {
		   
		   String gender="Female";
	       Mockito.when(addressBookService.noOfPersonsByGender(gender)).thenReturn((long) 2);
		   
	       mockMvc.perform(get("/address-book/"+gender+"/persons"))
	       .andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().json("{\"status\":{\"statusCode\":200,\"statusMessage\":\"Sucess\"},\"data\":{\"noOfPersons\":2,\"oldestPerson\":null,\"noOfDaysDifference\":0}}"));
	}
	
	@Test
	public void test_noOfPersonByGender_Blank() throws Exception {
		   
		   String gender="";
	       Mockito.when(addressBookService.noOfPersonsByGender(gender)).thenReturn((long) 2);
		   
	       mockMvc.perform(get("/address-book/"+gender+"/persons"))
	       .andDo(print())
			.andExpect(status().isNotFound());
	}
	
	
	@Test
	public void test_noOfDaysDifference_Success() throws Exception {
		   
		AddressBookRequest addressBookRequest=new AddressBookRequest();
		addressBookRequest.setPersonFirstname(GlobalConstants.PERSON_NAME_BILL);
		addressBookRequest.setAnotherPersonFirstname(GlobalConstants.PERSON_NAME_PAUL);
	    
		Mockito.when(addressBookService.noOfDaysDifference(Mockito.anyString(),Mockito.anyString())).thenReturn((long) 2862);
		   
	      
	       mockMvc.perform(
	               post("/address-book/persons/ageDifference")
	                       .contentType(MediaType.APPLICATION_JSON)
	                       .content(new ObjectMapper().writeValueAsString(addressBookRequest)))
	       			.andDo(print())
	               .andExpect(status().isOk())
	               .andExpect(content().json("{\"status\":{\"statusCode\":200,\"statusMessage\":\"Sucess\"},\"data\":{\"noOfPersons\":0,\"oldestPerson\":null,\"noOfDaysDifference\":2862}}"));
	}

	
	
}
