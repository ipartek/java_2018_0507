package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Serie de Fibonacci en Java Programa que imprima los N primeros números de la
 * serie de Fibonacci. El primer número de la serie es 1, el segundo número es 1
 * y cada uno de los siguientes es la suma de los dos anteriores. 1, 1, 2, 3, 5,
 * 8, 13, ....... , N
 */
public class e08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduce un número: ");
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		int temp1 = 1;
		int temp2 = 1;

		System.out.print(temp1 + " ");
		for (int i = 2; i <= numero; i++) {
			System.out.print(temp2 + " ");
			temp2 = temp1 + temp2;
			temp1 = temp2 - temp1;
		}

			sc.close();
	}

}
