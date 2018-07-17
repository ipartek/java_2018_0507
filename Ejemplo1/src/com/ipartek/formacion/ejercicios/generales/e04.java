package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

//  lea un número entero N y muestre la tabla de multiplicar de ese número.
public class e04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduce un número para ver su tabla: ");
		Scanner sc = new Scanner(System.in);
		
		int numero = sc.nextInt();
		
		for (int i = 1; i <=10; i++)
			System.out.println(numero + " x " + i + " = " + numero*i);
		
		sc.close();

	}

}
