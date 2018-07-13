package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Ejercicio1 {

	public int number1;
	public int number2;
	
	Scanner sc = new Scanner(System.in);
	LeerTeclado lt = new LeerTeclado(sc);
	
	public void leerNumero() {
		
		System.out.println("Introduce un número: ");
		number1 = lt.leerInt(number1);
		System.out.println("Ahora introduce el otro");
		number2 = lt.leerInt(number2);
		System.out.println("Los numeros que has introducido son: " + number1 + " y " + number2);
		
		//Lo de abajo funciona sin problemas.
//		System.out.println("Introduce un número: ");
//		number1 = sc.nextInt();
//		System.out.println("Ahora introduce el otro");
//		number2 = sc.nextInt();
//		System.out.println("Los numeros que has introducido son: " + number1 + " y " + number2);
	}
	
	
	
}
