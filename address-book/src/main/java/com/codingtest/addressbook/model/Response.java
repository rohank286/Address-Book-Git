/**
 * 
 */
package com.codingtest.addressbook.model;

/**
 * @author ROHAN-PC
 *
 */
public class Response {
	
	private Status status;
	private AddressBookResponse data;
	
	
	
	public Response() {}
	
	/**
	 * @param status
	 * @param data
	 */
	public Response(Status status, AddressBookResponse data) {
		super();
		this.status = status;
		this.data = data;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the data
	 */
	public AddressBookResponse getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(AddressBookResponse data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [status=" + status + ", data=" + data + "]";
	}
	
	
	
	

}
