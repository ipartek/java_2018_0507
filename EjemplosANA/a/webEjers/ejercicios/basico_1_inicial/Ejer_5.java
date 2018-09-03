package a.webEjers.ejercicios.basico_1_inicial;

public class Ejer_5 {

	/*Ejercicio básico inicial 5
Escribe un programa java que declare una variable A de tipo entero y asígnale un valor. A
continuación muestra un mensaje indicando si A es par o impar. Utiliza el operador
condicional ( ? : ) dentro del println para resolverlo.
Si por ejemplo A = 14 la salida será
14 es par
Si fuese por ejemplo A = 15 la salida será:
15 es impar
 
	  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A=14;
		int B=15;
		//Lo mismo de dos formas diferentes
								//Si el resto de A es 0, es par :else impar
		//1.
		System.out.println(A + (A%2==0 ? " es par " : " es impar "));
		//2.
		if(A%2==0)
			System.out.println("PAR");
		else
			System.out.println("IMPAR");
		
		//1.
								//Si el resto de B es 0, es par :else impar		
		System.out.println(B + (B%2==0 ? " es par " : " es impar "));
		//2.
		if(B%2==0)
			System.out.println("PAR");
		else
			System.out.println("IMPAR");

	}

}
