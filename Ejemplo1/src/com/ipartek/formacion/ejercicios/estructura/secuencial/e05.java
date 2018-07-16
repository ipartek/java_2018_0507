package com.ipartek.formacion.ejercicios.estructura.secuencial;



import java.util.Scanner;

/* 5. Programa que lee por teclado el valor del radio de una circunferencia y calcula y muestra
 * por pantalla la longitud y el área de la circunferencia. 
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia = PI*Radio^2
*/

public class e05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Integer r;

		System.out.println("Introduce el radio de la circunferencia: ");
		r = sc.nextInt();
		System.out.println("Long: " + (2 * Math.PI * r) + " Área: " + (Math.PI * (r * r)));
	}

}
