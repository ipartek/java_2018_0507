//Programa que lee un número de 3 cifras y muestra sus cifras por separado.
package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Ejercicio10 extends LeerTeclado{

	public Ejercicio10(Scanner sc) {
		super(sc);
		// TODO Auto-generated constructor stub
	}

	public int numero;
	public String numeroCortad;
	
	//Scanner sc = new Scanner(System.in);
	LeerTeclado lt  = new LeerTeclado(sc);
	
	public void cortarNumero() {
	
	System.out.println("Introduzca el numero que quiera cortar.");
	numero = lt.leerInt(numero);
	numeroCortad = Integer.toString(numero);
	String [] cortes = numeroCortad.split("");
	for (int i = 0; i < cortes.length; i++) {
		System.out.print(cortes[i] + " ");
	}
		
	}
}
