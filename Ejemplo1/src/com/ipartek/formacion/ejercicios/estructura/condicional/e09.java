package com.ipartek.formacion.ejercicios.estructura.condicional;
/* 9: Programa que lea por teclado tres números enteros H, M, S correspondientes a hora, minutos y segundos
 *  respectivamente, y comprueba si la hora que indican es una hora válida. 
Supondremos que se leemos una hora en modo 24 Horas, es decir,
el valor válido para las horas será  mayor o igual que cero y menor que 24.
El valor válido para los minutos y segundos estará comprendido entre 0 y 59 ambos incluidos */

import java.util.Scanner;

public class e09 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce las horas: ");
		int horas = sc.nextInt();
		System.out.println("Introduce los minutos: ");
		int minutos = sc.nextInt();
		System.out.println("Introduce los segundos: ");
		int segundos = sc.nextInt();
		
		if ((horas>=0&&horas<=23)&&(minutos>=0&&minutos<=59)&&(segundos>=0&&segundos<=59))
			System.out.println("Es una hora válida");
		else System.out.println("NO es una hora válida");
		
		sc.close();
	}
}
