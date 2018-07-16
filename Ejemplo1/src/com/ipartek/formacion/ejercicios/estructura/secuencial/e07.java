package com.ipartek.formacion.ejercicios.estructura.secuencial;

/* 7. Programa lea la longitud de los catetos de un triángulo rectángulo y calcule 
 * la longitud de la hipotenusa según el teorema de Pitágoras.
 */

import java.util.Scanner;

public class e07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el cateto 1: ");
		double cateto1 = sc.nextDouble();

		System.out.print("Introduce el cateto 2: ");
		double cateto2 = sc.nextDouble();

		System.out.println("Hipotenusa:" + Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2)));
		sc.close();
	}

}
