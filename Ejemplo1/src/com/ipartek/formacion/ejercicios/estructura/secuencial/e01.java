package com.ipartek.formacion.ejercicios.estructura.secuencial;
/* 1. Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
 */

import java.util.Scanner;

public class e01 {

	public static Integer N1;
	public static Integer N2;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// leer el primer número
		System.out.println("Introduce un número entero: ");
		N1 = sc.nextInt(); // lee un entero por teclado
		// leer el segundo número
		System.out.println("Introduce otro número entero: ");
		N2 = sc.nextInt(); // lee un entero por teclado
		// mostrar resultado
		System.out.println("Ha introducido los números: " + N1 + " y " + N2);
	}

}
