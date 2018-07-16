package com.ipartek.formacion.ejercicios.iniciales;

/* 4. Programa java que declare cuatro variables enteras A, B, C y D y asígnale un valor acada una.
 * A continuación realiza las instrucciones necesarias para que:
 * B tome el valor de C, C tome el valor de A, A tome el valor de D, D tome el valor de B.
 */

public class e04 {

	public static Integer A = 1;
	public static Integer B = 2;
	public static Integer C = 3;
	public static Integer D = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B = C;
		C = A;
		A = D;
		D = B;

		System.out.println(A + " " + B + " " + C + " " + D);
	}

}
