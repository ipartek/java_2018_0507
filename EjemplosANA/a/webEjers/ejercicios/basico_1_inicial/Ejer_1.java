package a.webEjers.ejercicios.basico_1_inicial;

public class Ejer_1 {
	/*
	Ejercicio básico inicial 1:
		Escribe un programa Java que realice lo siguiente: declarar una variable N de tipo int, una
		variable A de tipo double y una variable C de tipo char y asigna a cada una un valor. A
		continuación muestra por pantalla:
		El valor de cada variable.
		La suma de N + A
		La diferencia de A - N
		El valor numérico correspondiente al carácter que contiene la variable C.
		Si por ejemplo le hemos dado a N el valor 5, a A el valor 4.56 y a C el valor ‘a’, se debe
		mostrar por pantalla:
		Variable N = 5
		Variable A = 4.56
		Variable C = a
		5 + 4.56 = 9.559999999999999
		4.56 - 5 = -0.4400000000000004
		Valor numérico del carácter a = 97
		*
		*/
	public static void main(String[] args) {
		// TO0DO Auto-generated method stub
		int N=5;
		double A=4.56;
		char C='a';
		
		System.out.println("N = "+N);
		System.out.println("A = "+A);
		System.out.println("C = "+C);
		
		double suma=N+A;
		System.out.println(suma);
		double resta=A-N;
		System.out.println(resta);
		System.out.println((int)C);

	}

}
