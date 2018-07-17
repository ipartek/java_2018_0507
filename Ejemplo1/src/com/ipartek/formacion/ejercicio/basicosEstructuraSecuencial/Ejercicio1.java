//Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Ejercicio1 {

	public int number1;
	public int number2;
	public boolean reEjecutar= true;
	
	Scanner sc = new Scanner(System.in);
	LeerTeclado lt = new LeerTeclado(sc);
	
	public void leerNumero() {
		
		System.out.println("Introduce un número: ");
		number1 = lt.leerInt(number1);
		System.out.println("Ahora introduce el otro");
		number2 = lt.leerInt(number2);
		System.out.println("Valor incorrecto. Vuelva a introducir los valores");
	}
	
	
}
