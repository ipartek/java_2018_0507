package ejercicios.basicos.liniciales;

import java.util.ArrayList;
import java.util.Scanner;

public class EjerciciosArrayList {

	public static void main(String[] args) {
      ArrayList altura = new ArrayList();

		int N = numeroAlumnos();
		leerAlturas(altura,N);
		double M = calcularMedia(altura);

	}

	public static int numeroAlumnos() {
		int n;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Introduce el numero de alumnos:");
			n = sc.nextInt();
		}
		while (n<1);
		return n;
	}
	
	public static void leerAlturas(ArrayList altura, int N) {
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i<=N; i++) {
			System.out.println("introduce la altura del alumno:");
			double n = sc.nextDouble();
			altura.add(n);
		}
	}

	public static double calcularMedia(ArrayList altura) {
		double media;
		for(int i = 0; i<altura.size(i); i++) {
			media = media + altura.size();
		}
		System.out.println(media);
		return media;
		
	}
	
}