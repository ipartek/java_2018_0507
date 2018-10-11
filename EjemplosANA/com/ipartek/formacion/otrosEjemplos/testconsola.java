package com.ipartek.formacion.otrosEjemplos;

import java.io.IOException;

public class testconsola {
	public static void main( String[] args) {
		// Lectura de un byte
		try {
			int aByte = System.in.read();
		
	
			// Lectura de hasta 10 bytes
			byte [] buffer = new byte[10];
			System.in.read(buffer);
			System.out.println(buffer.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
