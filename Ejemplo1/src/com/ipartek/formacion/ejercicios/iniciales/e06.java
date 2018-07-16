package com.ipartek.formacion.ejercicios.iniciales;

/* 6. Programa Java que declare una variable B de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si el valor de B es positivo o negativo.
 * Consideraremos el 0 como positivo. Utiliza el operador condicional (? : )
 * dentro del println para resolverlo.
 * 
 */
public class e06 {

	public static Integer B = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(B + (B >= 0 ? " es positivo" : " es negativo"));
	}

}
