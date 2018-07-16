package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/* 13:Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) y
 * calcule su número de la suerte.
El número de la suerte se calcula sumando el día, mes y año de la fecha de nacimiento y
a continuación sumando las cifras obtenidas en la suma.

Por ejemplo:
Si la fecha de nacimiento es 12/07/1980 
Calculamos el número de la suerte así: 12+7+1980 = 1999  1+9+9+9 = 28
Número de la suerte: 28
 */

public class e13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el día de tu cumpleaños: ");
		int dia = sc.nextInt();
		System.out.println("Introduce el mes de tu cumpleaños: ");
		int mes = sc.nextInt();
		System.out.println("Introduce el año de tu cumpleaños: ");
		int ano = sc.nextInt();
		
		int numero = dia + mes + ano;
		System.out.println("Suma: " + numero);
		int millar = (numero/1000);
		int centena = (numero/100%10);
		int decena = (numero/10%10);
		int unidad = (numero%10);
		System.out.println(millar);
		System.out.println(centena);
		System.out.println(decena);
		System.out.println(unidad);
		
		System.out.println("El número de la suerte es: " + (millar + centena + decena + unidad));
		sc.close();
	}

}
