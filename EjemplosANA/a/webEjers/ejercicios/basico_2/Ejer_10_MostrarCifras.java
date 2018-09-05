package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

/*Pagina 10
* Programa que lea un número de 3 cifras y muestre por pantalla las cifras del número
*/
public class Ejer_10_MostrarCifras {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		System.out.print("Introduzca valor de 3 cifras: ");
		
		N = sc.nextInt(); //supondremos que el número introducido tiene 3 cifras
		
		while(N<99) {
			System.out.println("Numero de tres cifras por favor");
			N = sc.nextInt();
		}

		System.out.println("Primera cifra de " + N + " -> " + (N/100));
		System.out.println("Cifra central de " + N + " -> " + (N/10)%10);
		System.out.println("Última cifra de " + N + " -> " + (N%10));
		
		sc.close();
	
	}
}



