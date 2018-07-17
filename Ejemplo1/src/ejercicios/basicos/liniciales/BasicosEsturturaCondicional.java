package ejercicios.basicos.liniciales;

import java.io.IOException;
import java.util.Scanner;

public class BasicosEsturturaCondicional {
	
	public static void main(String[] args) throws IOException {
		char c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un caracter:");
		c = (char)System.in.read();
		if(Character.isUpperCase(c)) {
			System.out.println("Es mayuscula");
		}
		else {
			System.out.println("Es minuscula");
		}
		
	}

	
	public static void main02(String[] args) {
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		numero = sc.nextInt();
		if(numero%10 == 0) {
			System.out.println("El numero "+numero+" es multiplo de 10");
		}
		else {
			System.out.println("El numero "+numero+" no es multiplo de 10");
		}
	}

	
	public static void main01(String[] args) {
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		numero = sc.nextInt();
		
		System.out.println(numero + (numero%2 == 0 ? " es par" : " es impar"));
		
/*		if(numero%2 == 0) {
			 System.out.println("El numero "+numero+" es par");
		 }
		 else {
			 System.out.println("El numero "+numero+" es impar");
		 }
*/		

	}

}
