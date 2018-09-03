package a.webEjers.ejercicios.basico_1_inicial;

public class Ejer_3 {
	/*
	 Ejercicio básico inicial 3
	Escribe un programa Java que declare una variable entera N y asígnale un valor. A
	continuación escribe las instrucciones que realicen los siguientes:
	Incrementar N en 77.
	Decrementarla en 3.
	Duplicar su valor.
	Si por ejemplo N = 1 la salida del programa será:
	Valor inicial de N = 1
	N + 77 = 78
	N - 3 = 75
	N * 2 = 150

	 */
	public static void main(String[] args) {
		int N=1;
		//N=N+77;
		N+=77;
		System.out.println("N = "+N);
		//N=N-3;
		N-=3;
		System.out.println("N = "+N);
		//N=N*2;
		N*=2;
		System.out.println("N = "+N);
	}

}
