/**
 * 
 */
package com.codingtest.addressbook.model;

import java.time.LocalDate;

import com.codingtest.addressbook.utils.DateTimeHelper;
import com.codingtest.addressbook.utils.GlobalConstants;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author ROHAN-PC
 *
 */
public class Person {
	
	private String firstname;
	private String lastname;
	private String gender;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate birthdate;
	
	
	public Person() {}
	
	/**
	 * 
	 * @param name
	 * @param gender
	 * @param date
	 */
	public Person(String name,String gender,String date) {
		
		String [] tokens=name.trim().split(GlobalConstants.DELIM_BLANK_SPACE);
		this.firstname = tokens[0].trim();
		this.lastname = tokens[1].trim();
		this.gender=gender.trim();
		this.birthdate = DateTimeHelper.getLocalDate(date.trim(), GlobalConstants.DATE_FORMAT_dd_MM_yy).minusYears(100);
	}
	
	
	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", birthdate="
				+ birthdate + "]";
	}
	
	

}
