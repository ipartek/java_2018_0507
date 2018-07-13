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

	public static void ejerBasico3(int N) {
		System.out.println("EJERCIO BÁSICO 3");
		System.out.println("····························");
		System.out.println("·" + N + " + 77 = " + (N+77) );
		System.out.println("·" + N + " - 3 = " + (N-3) );
		System.out.println("·" + N + " * 2 = " + (N*2) );
		System.out.println("····························");
		System.out.println("");
	}
	
	public static void ejerBasico4(int A, int B, int C, int D) {
		/*
		 *  Programa java que declare cuatro variables enteras A, B, C y D
		 *   y asígnale un valor a cada una. A continuación realiza las instrucciones 
		 *   necesarias para que:
B tome el valor de C
C tome el valor de A
A tome el valor de D
D tome el valor de B
Si por ejemplo A = 1, B = 2, C = 3 y D = 4 el programa debe mostrar:
Valores iniciales
A = 1
B = 2
C = 3
D = 4
Valores finales
B toma el valor de C -> B = 3
C toma el valor de A -> C = 1
A toma el valor de D -> A = 4
D toma el valor de B -> D = 2

		 * 
		 */
		System.out.println("EJERCIO BÁSICO 4");
		System.out.println("····························");
		System.out.println("Valores iniciales");
		//Mostrar valores iniciales de variables
		System.out.println("A = " + A);
		System.out.println("B = " + B);
		System.out.println("C = " + C);
		System.out.println("D = " + D);
		//Asignación de nuevos valores
		int auxB = B;
		B = C;
		C = A;
		A = D;
		D = auxB;
		//Muestra de nuevos valores 
		System.out.println("Valores finales");
		System.out.println("B toma el valor de C -> B = " + B);
		System.out.println("C toma el valor de A -> C = " + C);
		System.out.println("A toma el valor de D -> A = " + A);
		System.out.println("D toma el valor de B -> D = " + D);

	}
}
