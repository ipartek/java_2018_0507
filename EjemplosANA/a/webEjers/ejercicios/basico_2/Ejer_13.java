package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_13 {


/*
 * Ejercicio 13:
Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) y
calcule su número de la suerte.
El número de la suerte se calcula sumando el día, mes y año de la fecha de nacimiento y a
continuación sumando las cifras obtenidas en la suma.
Por ejemplo:
Si la fecha de nacimiento es 12/07/1980
Calculamos el número de la suerte así: 12+7+1980 = 1999 1+9+9+9 = 28
Número de la suerte: 28
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dia,mes,anio,suerte;

		System.out.print("Introduzca fecha de nacimiento");
		System.out.println("DIA");
		dia = sc.nextInt();
		System.out.println("MES");
		mes=sc.nextInt();
		System.out.println("ANIO");
		anio=sc.nextInt();
		
		int suma=dia+mes+anio;
				
		int num1=suma/1000;
		int num2=suma/100%10;
		int num3=suma/10%10;
		int num4= suma%10;
		suerte=num1+num2+num3+num4;
		
		
		System.out.println("Numero de la suerte:"+suerte);
		sc.close();
		
	}

}
