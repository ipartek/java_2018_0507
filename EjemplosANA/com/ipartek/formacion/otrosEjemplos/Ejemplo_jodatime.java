package com.ipartek.formacion.otrosEjemplos;

import org.joda.time.LocalDate;

public class Ejemplo_jodatime {
	 
	public static void main (String[] args) {
	
		//joda-time
		LocalDate newYear=LocalDate.now().plusYears(1).withDayOfYear(1);
		System.out.println(newYear);
		
		
		//Java 8
		
		java.time.LocalDate j8newYear = java.time.LocalDate.now().plusYears(1).withYear(2018);
		System.out.println(j8newYear);
	}

}
