package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_6_Km_a_ms {

	//Ejercicio 6. Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado
	public static void main(String[] args) {

		System.out.print("Introduzca km/h: ");
		Scanner sc=new Scanner(System.in);
		Double KmH = sc.nextDouble();

		System.out.println(KmH + " Km/h -> " + KmH*1000/3600 + " m/s");
		sc.close();
	}

}
