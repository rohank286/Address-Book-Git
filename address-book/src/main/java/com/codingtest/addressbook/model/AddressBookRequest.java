/**
 * 
 */
package com.codingtest.addressbook.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ROHAN-PC
 *
 */
public class AddressBookRequest {
	
	private String gender;
	
	@NotNull
	@NotBlank
	private String personFirstname;
	
	@NotNull
	@NotBlank
	private String anotherPersonFirstname;
	
	public AddressBookRequest() {}

	/**
	 * @param gender
	 * @param personFirstname
	 * @param anotherPersonFirstname
	 */
	public AddressBookRequest(String gender, String personFirstname, String anotherPersonFirstname) {
		super();
		this.gender = gender;
		this.personFirstname = personFirstname;
		this.anotherPersonFirstname = anotherPersonFirstname;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the personFirstname
	 */
	public String getPersonFirstname() {
		return personFirstname;
	}

	/**
	 * @param personFirstname the personFirstname to set
	 */
	public void setPersonFirstname(String personFirstname) {
		this.personFirstname = personFirstname;
	}

	/**
	 * @return the anotherPersonFirstname
	 */
	public String getAnotherPersonFirstname() {
		return anotherPersonFirstname;
	}

	/**
	 * @param anotherPersonFirstname the anotherPersonFirstname to set
	 */
	public void setAnotherPersonFirstname(String anotherPersonFirstname) {
		this.anotherPersonFirstname = anotherPersonFirstname;
	}
	
	
	
	
	

}
