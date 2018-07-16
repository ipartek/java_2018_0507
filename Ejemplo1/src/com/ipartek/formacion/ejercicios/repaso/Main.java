package com.ipartek.formacion.ejercicios.repaso;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Comprobar si 2 numeros son amigos. 
		//Dos números enteros positivos A y B son números amigos si la suma de los divisores
		//propios de A es igual a B y la suma de los divisores propios de B es igual a A. 
		
		
		int num1;
		int num2;
		int suma=0;
		int suma2=0;
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Introduce el primer numero");
		 num1 = sc.nextInt();
		 System.out.println("Introduce el primer numero");
		 num2 = sc.nextInt();
		 for (int i = 1; i < num1; i++) {
			if (num1%i==0) {
				suma = suma+i;
			}
		 }
		 for (int i = 1; i < num1; i++) {
				if (num2%i==0) {
					suma2 = suma2+i;
				}						
		 }
		if (suma == num2)
			System.out.println("Son numeros amigos");
		else
			System.out.println("No son amigos");
		if (suma2 == num1)
			System.out.println("Son numeros amigos");
		else
			System.out.println("no son amigos");
		
		
	}

}
