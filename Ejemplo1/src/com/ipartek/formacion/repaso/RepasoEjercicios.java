package com.ipartek.formacion.repaso;

public class RepasoEjercicios {

	public static void main1(String[] args) {

		/**
		 * 
		 * 1. Programa java que realice lo siguiente: declarar una variable N de tipo
		 * int, una variable A de tipo double y una variable C de tipo char y asigna a
		 * cada una un valor. A continuación muestra por pantalla: El valor de cada
		 * variable, la suma de N + A, la diferencia de A - N, el valor numérico
		 * correspondiente al carácter que contiene la variable C.
		 * 
		 * @param args
		 */

		int N = 1;
		double A = 1.1;
		char C = 'A';

		System.out.println("Variable N: " + N + "variable A: " + A + "variable C: " + C);
		System.out.println(N + A);
		System.out.println(A - N);
		System.out.println((int) C);

	}

	public static void main2(String[] args) {
		/**
		 * 2 Programa java que realice lo siguiente: declarar dos variables X e Y de
		 * tipo int, dos variables N y M de tipo double y asigna a cada una un valor. A
		 * continuación reliza y muestra muestra por pantalla una serie de operaciones
		 * entre ellas.
		 * 
		 */

		int X = 1;
		int Y = 2;

		double N = 1.2;
		double M = 3.5;
		System.out.println(N + M);
		System.out.println(Y % 1 + X);
	}

	public static void main3(String[] args) {
		/**
		 * 3 Programa Java que declare una variable entera b y asígnale un valor. A
		 * continuación escribe las instrucciones que realicen lo siguiente: Incrementar
		 * N en 77, Decrementarla en 3, Duplicar su valor.
		 * 
		 */

		int b = 1;
		b += 77;
		System.out.println(b);
		b -= 3;
		System.out.println(b);
		b *= 2;
		System.out.println(b);
	}

	public static void main4(String[] args) {
		/**
		 * 4. Programa java que declare cuatro variables enteras A, B, C y D y asígnale
		 * un valor acada una. A continuación realiza las instrucciones necesarias para
		 * que: B tome el valor de C, C tome el valor de A, A tome el valor de D, D tome
		 * el valor de B.
		 * 
		 */

		int A = 1;
		int B = 2;
		int C = 3;
		int D = 4;

		System.out.println("valores inicial de A :" + A);
		System.out.println("valores inicial de B :" + B);
		System.out.println("valores inicial de C :" + C);
		System.out.println("valores inicial de D :" + D);

		B = C;
		C = A;
		A = D;
		D = B;

		System.out.println("valores final de B :" + B);
		System.out.println("valoresfinalel de C :" + C);
		System.out.println("valores inicial de A :" + A);
		System.out.println("valores inicial de D :" + D);

	}

	public static void main5(String[] args) {
		/**
		 * 5. Programa Java que declare una variable A de tipo entero y asígnale un
		 * valor. A continuación muestra un mensaje indicando si A es par o impar.
		 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
		 */

		int A = 2;

		System.out.println(A % 2 == 0 ? "es par" : "es impar");

	}

	public static void main6(String[] args) {
		/**
		 * 
		 * 6. Programa Java que declare una variable B de tipo entero y asígnale un
		 * valor. A continuación muestra un mensaje indicando si el valor de B es
		 * positivo o negativo. Consideraremos el 0 como positivo. Utiliza el operador
		 * condicional (? : ) dentro del println para resolverlo.
		 */

		int B = -9;

		System.out.println(B >= 0 ? "es positivo" : "es negativo");

	}

	public static void main(String[] args) {
		/**
		 * 
		 * 7. Programa Java que declare una variable C de tipo entero y asígnale un
		 * valor. A continuación muestra un mensaje indicando si el valor de C es
		 * positivo o negativo, si es par o impar, si es múltiplo de 5, si es múltiplo
		 * de 10 y si es mayor o menor que 100. Consideraremos el 0 como positivo.
		 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
		 */

		int C = 1;

		System.out.println(C >= 0  ? "es positivo" : "es negativo");
		System.out.println(C %2==0  ? "es par" : "es impar");
		System.out.println(C %5==0  ? "es multiplo de 5" : "no es multiplo de 5");
		System.out.println(C %10==0  ? "es multiplo de 10" : "no es multiplo de 10");
		System.out.println(C <100  ? "es menor de 100" : "es mayor de 100");

	}

}