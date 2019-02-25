package com.codingtest.addressbook.model;

public class AddressBookResponse {
	
	private long noOfPersons;
	private Person oldestPerson;
	private long noOfDaysDifference;
	
	
	public AddressBookResponse() {}
	
	/**
	 * @param noOfmales
	 * @param oldestPerson
	 * @param noOfDaysDifference
	 */
	public AddressBookResponse(long noOfPersons, Person oldestPerson, long noOfDaysDifference) {
		super();
		this.noOfPersons = noOfPersons;
		this.oldestPerson = oldestPerson;
		this.noOfDaysDifference = noOfDaysDifference;
	}
	/**
	 * @return the noOfPersons
	 */
	public long getNoOfPersons() {
		return noOfPersons;
	}
	/**
	 * @param noOfPersons the noOfmales to set
	 */
	public void setNoOfPersons(int noOfmales) {
		this.noOfPersons = noOfmales;
	}
	/**
	 * @return the oldestPerson
	 */
	public Person getOldestPerson() {
		return oldestPerson;
	}
	/**
	 * @param oldestPerson the oldestPerson to set
	 */
	public void setOldestPerson(Person oldestPerson) {
		this.oldestPerson = oldestPerson;
	}
	/**
	 * @return the noOfDaysDifference
	 */
	public long getNoOfDaysDifference() {
		return noOfDaysDifference;
	}
	/**
	 * @param noOfDaysDifference the noOfDaysDifference to set
	 */
	public void setNoOfDaysDifference(int noOfDaysDifference) {
		this.noOfDaysDifference = noOfDaysDifference;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressBookResponse [noOfPersons=" + noOfPersons + ", oldestPerson=" + oldestPerson
				+ ", noOfDaysDifference=" + noOfDaysDifference + "]";
	}
	
	
	
	
	

}
