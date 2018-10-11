package a.webEjers.ejercicios;

import java.util.Scanner;

public class IntercambioVariables {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("INTERCAMBIO CON AUXILIAR");
		intercambioVarconAuxiliar();
		System.out.println("INTERCAMBIO SIN AUXILIAR");
		intercambioVarsinAuxiliar();

	}
	
	public static void intercambioVarconAuxiliar() {
		
		int A, B, AUX;
		System.out.print("Introduzca valor de A: ");
		A = sc.nextInt();
		System.out.print("Introduzca Valor de B: ");
		B = sc.nextInt();
		System.out.println("Valores iniciales: A = " + A + " B = " + B);
		//instrucciones para hacer el intercambio
		//se utiliza una variable auxiliar
		AUX = A;
		A = B;
		B = AUX;
		System.out.println("Valores intercambiados: A = " + A + " B = " + B);

		
	}
	
	public static void intercambioVarsinAuxiliar() {
		int A, B;
		System.out.print("Introduzca valor de A: ");
		A = sc.nextInt();
		System.out.print("Introduzca Valor de B: ");
		B = sc.nextInt();
		System.out.println("Valores iniciales: A = " + A + " B = " + B);
		//instrucciones para hacer el intercambio
		//sin utilizar una variable auxiliar
		A = A + B;
		B = A - B;
		A = A - B;
		System.out.println("Valores intercambiados: A = " + A + " B = " + B);
	}
}

