package a.webEjers.ejercicios.basico_1_inicial;

public class Ejer_7 {

	/*
	 * Ejercicio básico inicial 7
Escribe un programa java que declare una variable C de tipo entero y asígnale un valor. A
continuación muestra un mensaje indicando si el valor de C es positivo o negativo, si es par o
impar, si es múltiplo de 5, si es múltiplo de 10 y si es mayor o menor que 100.
Consideraremos el 0 como positivo. Utiliza el operador condicional ( ? : ) dentro del println
para resolverlo.
Si por ejemplo C = 55 la salida será
55 es positivo
55 es impar
55 es múltiplo de 5
55 no es múltiplo de 10
55 es menor que 100
	 */
	public static void main(String[] args) {
		int c=7;
		int a=6;
		int b=20;
		int d=100;
		int e=101;
		
		System.out.println( c + (c>0 ? " positico" : " negativo"));
		
		System.out.println( c + (c%2==0 ? " entero" : " noEntero"));

		System.out.println( a + (a%2==0 ? " entero" : " noEntero"));

		System.out.println( b + (b%5==0 ? " multiplo de 5" : " no multuplo de 5"));
		System.out.println( b + (b%10==0 ? " multiplo de 10" : " no multuplo de 10"));
		
		System.out.println(d+(d>100 ? " mayor" : " menor"));
		System.out.println(e+(e>100 ? " mayor" : " menor"));

	}

}
