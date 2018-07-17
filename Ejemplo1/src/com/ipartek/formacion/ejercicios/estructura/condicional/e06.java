package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.io.IOException;

/* 6: Programa java que lea un carácter por teclado y compruebe si es un dígito numérico 
 * (cifra entre 0 y 9).
Vamos a escribir dos soluciones a este ejercicio. 
La primera consiste en comprobar si el carácter es un dígito mediante el método isDigit
 de la clase Character. Este método devuelve true si el carácter que se le pasa como
  parámetro es una cifra entre 0 y 9: */
public class e06 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Introduzca un carácter: ");
		char caracter = (char) System.in.read();
		
		if (Character.isDigit(caracter))
			System.out.println("El caracter es un número");
		else System.out.println("El caracter NO es un número");

	}

}
