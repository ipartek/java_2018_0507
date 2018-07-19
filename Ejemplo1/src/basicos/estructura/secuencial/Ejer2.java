package basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejer2 {

	// Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
	public static void main1(String[] args) {
		Integer n1, n2;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		n1 = teclado.nextInt();
		System.out.println("Introduce un segundo numero: ");
		n2 = teclado.nextInt();
		System.out.println("Numeros introducidos: " + n1 + " y " + n2);
	}
	// Programa Java que lea un nombre y muestre por pantalla: “Buenos dias nombre_introducido”.
	public static void main2(String[] args) {
		String nombre;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		nombre = teclado.nextLine();
		System.out.println("Buenos dias " +nombre);
	}
	
	//Programa Java que lee un número entero por teclado y obtiene y muestra por 
	//pantalla el doble y el triple de ese número.
	public static void main3(String[] args) {
		Integer n1;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		n1 = teclado.nextInt();
		System.out.println("Doble: "+(n1*2)+" y triple: "+(n1*3));
	}
	
	//Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. 
	//La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
	public static void main(String[] args) {
		Integer grados;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Intrduce los grados:");
		grados = teclado.nextInt();
		grados = 32 + ( 9 * grados / 5);
		System.out.println("Grados Fahrenheit: "+grados);
	}	
}
