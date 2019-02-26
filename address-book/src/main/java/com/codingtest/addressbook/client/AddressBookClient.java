/**
 * 
 */
package com.codingtest.addressbook.client;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codingtest.addressbook.model.AddressBookRequest;
import com.codingtest.addressbook.model.Response;

/**
 * @author ROHAN-PC
 *
 */
public class AddressBookClient {
	
	
	private static String oldestpersonUrl="http://localhost:8080/address-book/persons/oldest";
	private static String noOfPersonByGenderUrl="http://localhost:8080/address-book/{gender}/persons";
	private static String noOfDaysOfDiffUrl="http://localhost:8080/address-book/persons/ageDifference";
	
	
	public static void main(String[] args) {
	//	getOldestPersonClient();
		getNoOfPersonByGenderClient();
		getNoOfDaysDifference();
	}
	
	public static void getOldestPersonClient() {
		
		UriComponentsBuilder builder = UriComponentsBuilder
			    .fromUriString(oldestpersonUrl);
		RestTemplate restTemplate = new RestTemplate();
		Response response = restTemplate.getForObject(builder.toUriString(), Response.class);
		System.out.println("Oldest Person ::"+response.toString());
	}
	
	public static void getNoOfPersonByGenderClient() {
		
	    String gender="Male";
	
		UriComponentsBuilder builder = UriComponentsBuilder
			    .fromUriString(noOfPersonByGenderUrl)
			    .queryParam("gender", gender);
		RestTemplate restTemplate = new RestTemplate();
		Response response = restTemplate.getForObject(builder.toUriString(), Response.class,gender);
		System.out.println("Number of Males ::"+response.toString());
	}
	
public static void getNoOfDaysDifference()  {
		
	    String firstPerson="Bill";
	    String anotherPersonFirstname="Paul";
	   
	  AddressBookRequest addressBookRequest=new AddressBookRequest();
	  addressBookRequest.setPersonFirstname(firstPerson);
	   addressBookRequest.setAnotherPersonFirstname(anotherPersonFirstname);

	   

	    RestTemplate restTemplate = new RestTemplate();
	    Response response = restTemplate.postForObject(noOfDaysOfDiffUrl, addressBookRequest, Response.class);

	   
		System.out.println("Age Difference between"+firstPerson+" and "+anotherPersonFirstname+"  in days ::"+response.toString());
	}

}
