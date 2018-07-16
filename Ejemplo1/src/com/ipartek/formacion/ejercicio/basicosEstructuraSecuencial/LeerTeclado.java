/*
 * Clase desde la que se llama a los metodos de lectura del teclado.
 */
package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class LeerTeclado {

	public Scanner sc = new Scanner(System.in);
	
	public LeerTeclado(Scanner sc) {
		super();
		this.sc = sc;
	}

	public int leerInt(int i) {
		return i = sc.nextInt();
	}
	public String leerString(String s) {
		return s = sc.nextLine();
	}	
	public String leerChar(String l) {
		return l = sc.nextLine();
	}
	public Double leerDoble(Double d) {
		return d= sc.nextDouble();
	}
}
