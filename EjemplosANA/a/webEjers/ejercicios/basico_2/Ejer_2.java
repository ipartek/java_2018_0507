package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_2 {
	/*Programa Java que lea un nombre y muestre por pantalla:
		“Buenos dias nombre_introducido”
	*/

	public static void main(String[] args) {
		System.out.print("Introduce tu nombre: ");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Buenos dias "+sc.nextLine());
		sc.close();

	}

}
