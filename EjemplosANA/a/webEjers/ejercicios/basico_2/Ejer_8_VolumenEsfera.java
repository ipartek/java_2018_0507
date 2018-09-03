package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_8_VolumenEsfera {
	//173
/*
	Programa que tome como dato de entrada un número que corresponde a la longitud del radio
	una esfera y nos calcula y escribe el volumen de la esfera que se corresponden con dicho
	radio.
	La fórmula para calcular el volumen de la esfera es
	v = (4/3)*PI*r^3
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double radio, volumen;
		
		System.out.print("Introduzca radio de la esfera: ");
		radio = sc.nextDouble();
		volumen=(4.0/3)* Math.PI * Math.pow(radio, 3);
		System.out.println("Volumen de la esfera de radio " + radio + " = " + volumen);
		sc.close();
	}
}
