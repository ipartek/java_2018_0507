package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/* 
 * Programa que lea dos variables 
 * numéricas A y B e 
 * intercambie sus contenidos. 
 */
public class e01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduce un número: ");
		Scanner sc = new Scanner(System.in);
		int variableA = sc.nextInt();
		
		System.out.println("Introduce otro número: ");
		int variableB = sc.nextInt();
		
		int variableC= variableA;
		variableA=variableB;
		variableB=variableC;
		
		System.out.println("Las variables son: " + variableA + " y "+ variableB);
		
		sc.close();
	}

}
