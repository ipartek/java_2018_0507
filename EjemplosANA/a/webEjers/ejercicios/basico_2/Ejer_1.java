package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_1 {
	/*
	 * 1. Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Introduce numero 1: ");
		int n1=sc.nextInt();
		
		System.out.print("Introduce numero 2: ");
		int n2=sc.nextInt();
		
		System.out.println("Introducidos: Numero1="+n1+" Numero2="+n2);
		sc.close();

	}

}
