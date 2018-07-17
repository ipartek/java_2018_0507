package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

// pide un número entero por teclado y calcula y muestra el número de cifras que tiene.
public class e02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Introduce un número: ");
Scanner sc = new Scanner(System.in);
int numero = sc.nextInt();
int contador = 1;
while ((numero/10)!=0) {
	numero=numero/10;
			contador++;
}

System.out.println("El número de cifras es: " + contador);
sc.close();
	}

}
