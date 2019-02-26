/**
 * 
 */
package com.codingtest.addressbook.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author ROHAN-PC
 *
 */
public class DateTimeHelper {
	
	/**
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static LocalDate getLocalDate(String date, String format ) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
	}
	
	/**
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long differenceInDays(LocalDate startInclusive,LocalDate endExclusive) {
		return Duration.between(startInclusive.atStartOfDay(), endExclusive.atStartOfDay()).toDays();
	}

}
