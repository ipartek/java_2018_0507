package com.ipartek.formacion.ejercicios.iniciales;

/* 1. Programa java que realice lo siguiente: declarar una variable N de tipo int,
 * una variable A de tipo double y una variable C de tipo char y asigna a cada una un valor.
 *  A continuación muestra por pantalla: El valor de cada variable, la suma de N + A,
 *  la diferencia de A - N, el valor numérico correspondiente al carácter que contiene la variable C.
 */

public class e01 {

	public static int N = 1;
	public static double A = 2.2;
	public static char C = 'C';

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N);
		System.out.println(A);
		System.out.println(C);
		System.out.println();
		System.out.println(N + A);
		System.out.println(A - N);
		System.out.println((int) C);
	}

}
