package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/*  calcular si un número es perfecto
 * Un número es perfecto si es igual a la suma de todos sus divisores positivos sin incluir el propio número.
 */
public class e06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduce un número: ");
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		int suma = 0;

		for (int i = 1; i < numero; i++) {
			if (numero%i==0) {
				System.out.println(i);
				suma = suma + i;
			}
		}
		if (suma==numero) System.out.println("El número es perfecto"); else System.out.println("El número NO es perfecto");;
		sc.close();
	}

}
