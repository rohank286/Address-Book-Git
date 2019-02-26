/**
 * 
 */
package com.codingtest.addresbook.testcases.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.codingtest.addressbook.model.Person;

/**
 * @author ROHAN-PC
 *
 */
public class StubDataProvider {
	
	/**
	 * Stubed Data to use while mocking the AddressRepo methods.
	 * @return
	 */
	public static Stream<Person> stubPeopleStream() {
		List<Person> persons=new ArrayList<Person>();
		persons.add(new Person("Bill McKnight","Male","16/03/77"));
		persons.add(new Person("Paul Robinson","Male","15/01/85"));
		persons.add(new Person("Gemma Lane","Female","20/11/91"));
		persons.add(new Person("Sarah Stone","Female","20/09/80"));
		persons.add(new Person("Wes Jackson","Male","14/08/74"));
		return persons.stream();
	}

}
