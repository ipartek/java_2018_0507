package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

public class Utils {
	private static Scanner s = new Scanner(System.in);

	public static String leerLinea() {
		return s.nextLine();
	}
	
	public static long leerLong() {
		long l = s.nextLong();
		s.nextLine();
		return l;
	}
	
	public static int leerInt() {
		int i = s.nextInt();
		s.nextLine();
		return i;
	}
}
