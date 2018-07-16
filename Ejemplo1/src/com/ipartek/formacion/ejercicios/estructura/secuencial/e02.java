package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/* 2.      Programa Java que lea un nombre y muestre por pantalla:
“Buenos dias nombre_introducido”
*/

public class e02 {

	public static void main(String[] args) {

		String S;
		Scanner sc = new Scanner(System.in);

		// TODO Auto-generated method stub
		System.out.println("Introduce tu nombre: ");
		S = sc.nextLine();
		System.out.println("Tu nombre es: " + S);

	}

}
