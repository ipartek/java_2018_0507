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

	public static void ejerBasico5(int A) {
		System.out.println("");
		System.out.println("EJERCIO BÁSICO 5");
		System.out.println("····························");
		// Otra forma de resolverlo System.out.println(A + (A%2==0 ? " es par " : " es impar "));
		if(A%2==0) {
			System.out.println("El número " + A + " es par");
		}else {
			System.out.println("El número " + A + " es impar");
		}
		System.out.println("····························");
	}

	public static void ejerBasico6(int B) {
		System.out.println("");
		System.out.println("EJERCIO BÁSICO 6");
		System.out.println("····························");
		if(B>=0) {
			System.out.println("El número " + B + " es positivo");
		}else {
			System.out.println("El número " + B + " es negativo");
		}
		System.out.println("····························");
	}
	
	public static void ejerBasico7(int C) {
		System.out.println("");
		System.out.println("EJERCIO BÁSICO 7");
		System.out.println("····························");
		if(C>=0) {
			System.out.println(C + " es positivo");
		}else {
			System.out.println(C + " es negativo");
		}
		
		if(C%2==0) {
			System.out.println(C + " es par");
		}else {
			System.out.println(C + " es impar");
		}
		
		if(C%5==0) {
			System.out.println(C + " es múltiplo de 5");
		}else {
			System.out.println(C + " no es múltiplo de 5");
		}
		
		if(C%10==0) {
			System.out.println(C + " es múltiplo de 10");
		}else {
			System.out.println(C + " no es múltiplo de 10");
		}
		
		if(C<100) {
			System.out.println("El número es menor a 100");
		}else {
			System.out.println("El número es mayor a 100");
		}
		System.out.println("····························");
	}
}
