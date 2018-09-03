package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_3 {
/*
 * 3. Escribe un programa Java que lee un número entero por teclado y obtiene y 
 * muestra por pantalla el doble y el triple de ese número.
 */
	public static void main(String[] args) {
		System.out.print("Introduce un numero: ");
		Scanner sc=new Scanner(System.in);
		
		int num_introd=sc.nextInt();
		
		System.out.println("Numero introducido: " + num_introd);
		System.out.println("Doble del numero: "+ num_introd*2);
		System.out.println("Tripe del numero: "+ num_introd*3);
		sc.close();

	}

}
