package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_4_GradCent_a_Far {
/*
Ejercicio 4:
Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit.
La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
F = 32 + ( 9 * C / 5)
*/
	public static void main(String[] args) {
		
		double gradosC,gradosF;
		Scanner sc=new Scanner(System.in);
		System.out.println("Usar coma para decimales y no punto");
		System.out.print("Introduce Grados Cº: ");
		gradosC= sc.nextDouble();
		System.out.println("Grados Cº introducidos: "+gradosC);
		
		//Convertir a Fahrenheit -> F = 32 + ( 9 * C / 5)
		
		gradosF=32+(9*gradosC/5);
		System.out.println("Grados Fahrenheit: "+gradosF);
		sc.close();
		
	}

}
