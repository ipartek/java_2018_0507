package com.ipartek.formacion.otrosEjemplos;

import java.util.Calendar;

public class Calendario {

	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		System.out.println(c.getTime());
		
		
		System.out.print(c.get(Calendar.YEAR));
		System.out.print("/");
		System.out.print(c.get(Calendar.MONTH)+1);
		System.out.print("/");
		System.out.print(c.get(Calendar.DAY_OF_MONTH));
		System.out.print(" ----- ");
		System.out.print(c.get(Calendar.HOUR));
		System.out.print(":");
		System.out.print(c.get(Calendar.MINUTE));
		System.out.print(":");
		System.out.print(c.get(Calendar.SECOND));
		

	}

}
