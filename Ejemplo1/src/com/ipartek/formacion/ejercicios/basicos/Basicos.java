package com.ipartek.formacion.ejercicios.basicos;

public class Basicos {
	public static void ejerBasico1(int N, double A, char C) {
		System.out.println("EJERCIO BÁSICO 1");
		System.out.println("····························");
		System.out.println("·El valor de la variable N es: " + N + ", el de la variable A es: " + A + " y el de la variable C es: " + C);
		System.out.println("·La suma del valor " + N + " y de " + A + " es " + (N+A));
		System.out.println("·La diferencia del valor " + N + " y de " + A + " es " + (N-A));
		System.out.println("·El valor numérico correspondiente al carácter '" + C + "' es: " + (int)C);
		System.out.println("····························");
		System.out.println("");
	}
	
	public static void ejerBasico2(int X, int Y, double N, double M) {
		System.out.println("EJERCIO BÁSICO 2");
		System.out.println("····························");
		System.out.println("·El valor de la variable X es: " + X + ", el de la variable Y es: " + Y + ", el de la variable N es: " + N + " y el de la variable M es: " + M);
		System.out.println("·Suma: " + X + " + " + Y + " = " + (X+Y));
		System.out.println("·Diferencia: " + X + " - " + Y + " = " + (X-Y));
		System.out.println("·Producto: " + X + " x " + Y + " = " + (X*Y));
		System.out.println("·Cociente: " + X + " / " + Y + " = " + (X/Y));
		System.out.println("·Resto: " + X + " % " + Y + " = " + (X%Y));
		System.out.println("·Suma: " + N + " + " + M + " = " + (N+M));
		System.out.println("·Diferencia: " + N + " - " + M + " = " + (N-M));
		System.out.println("·Producto: " + N + " x " + M + " = " + (N*M));
		System.out.println("·Cociente: " + N + " / " + M + " = " + (N/M));
		System.out.println("·Resto: " + N + " % " + M + " = " + (N%M));
		System.out.println("·El doble de la variable X es " + (X*2) + ", Y es " + (Y*2)+ ", N es " + (N*2) + " y M es " + (M*2));
		System.out.println("·La suma de todas las variables es: " + X + " + " + Y + " + " + N + " + " + M + " = " + (X+Y+N+M));
		System.out.println("·El producto de todas las variables es: " + X + " * " + Y + " * " + N + " * " + M + " = " + (X*Y*N*M));
		System.out.println("····························");
		System.out.println("");
	}
}
