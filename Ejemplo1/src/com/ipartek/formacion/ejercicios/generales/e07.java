package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/* COMPROBAR SI DOS NÚMEROS SON AMIGOS
Dos números enteros positivos A y B son números amigos si la suma de los divisores
 propios de A es igual a B y la suma de los divisores propios de B es igual a A.
Los divisores propios de un número incluyen la unidad pero no el propio número. */

public class e07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer número: ");
		int numero1 = sc.nextInt();
		System.out.println("Introduce el segundo número: ");
		int numero2 = sc.nextInt();

		int suma1 = 0;
		int suma2 = 0;

		for (int i = 1; i < numero1; i++) {
			if (numero1 % i == 0) {
				suma1 = suma1 + i;
			}
		}

		for (int i = 1; i < numero2; i++) {
			if (numero2 % i == 0) {
				suma2 = suma2 + i;
			}
		}

		if ((suma2 == numero1) && (suma1 == numero2))
			System.out.println("Los números son amigos");
		else
			System.out.println("Los números NO son amigos");

		sc.close();
	}

}
