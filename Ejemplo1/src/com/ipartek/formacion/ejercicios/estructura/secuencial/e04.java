package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/* 4. Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit.
 * La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
 */
public class e04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Integer N;

		System.out.println("Introduce los grados centígrados: ");
		N = sc.nextInt();
		N = 32 + (9 * N / 5);
		System.out.println(N + " Grados Farenheit");

	}

}
