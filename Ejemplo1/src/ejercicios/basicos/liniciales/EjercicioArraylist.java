package ejercicios.basicos.liniciales;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioArraylist {
	
	public static void main(String[] args) {
		
	}

	
/*	EJERCICIO 2	
	public static void main(String[] args) {

		ArrayList<Integer> valores = leerValores();
		int suma = calcularSuma(valores);
		mostrarResultados(valores, suma);
	}
	
	public static ArrayList<Integer> leerValores() {
        ArrayList<Integer> valores = new ArrayList<Integer>();
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero, -99 para terminar");		
		n = sc.nextInt();
		while(n != -99) {
			valores.add(n);
			System.out.println("Introduce un numero, -99 para terminar");		
			n = sc.nextInt();
			
		}
		return valores;
	}
	
	public static int calcularSuma(ArrayList<Integer> valores) {
		int n = 0;
		int suma = 0;
		for(int i = 0; i<valores.size(); i++) {
			n = valores.get(i);
			suma += n;
			
		}
		return suma;
	}

	public static void mostrarResultados(ArrayList<Integer> valores, int suma) {
		int contador = 0;
		for(int i = 0; i<valores.size(); i++) {
			System.out.println("Valor "+(i+1)+": "+valores.get(i));
		}
		System.out.println("La suma de todos los valores es: "+suma);
		double suma1 = suma;
		System.out.println("La media de todos los valores es: "+suma1/valores.size());
		for(int i = 0; i<valores.size(); i++) {
			if(suma1/valores.size()<valores.get(i)) {
				contador++;
				System.out.println("El valor "+(i+1)+", es mayor que la media");
			}
		}
		System.out.println(contador+" valor/es son mayores que la media");
	}
*/	
	
/*	EJERCICIO 1
 * 
	public static void main(String[] args) {
		ArrayList<Double> alturas = new ArrayList<Double>();
		int N = numeroAlumnos();
		leerAlturas(alturas, N);
		double A = calcularMedia(alturas);
		calcularMedias(alturas,A);
	}
	
	public static int numeroAlumnos() {
	      Scanner sc = new Scanner(System.in);
	      int N;
	      do {
	    	  System.out.println("Introduce el numero de alumnos:");
	    	  N = sc.nextInt();
	      }
	      while (N<=0);
	      return N;
	}

	public static void leerAlturas(ArrayList<Double> alturas, int N) {
	      Scanner sc = new Scanner(System.in);
	      double alto;
	      for(int i = 0; i<N; i++) {
	    	  do {
	    		  System.out.println("Introduce la altura del alumno "+(i+1));
		    	  alto = sc.nextDouble();
	    	  }
	    	  while(alto<=0);
    	   alturas.add(alto);
	      }
	}

	public static double calcularMedia(ArrayList<Double> altura) {
		double media = 0;
		for(int i = 0; i<altura.size(); i++) {
			media += altura.get(i);
		}
		System.out.println(media/altura.size());
		return media/altura.size();
	}

	public static void calcularMedias(ArrayList<Double> altura, double A) {
		for(int i = 0; i<altura.size(); i++) {
			System.out.println("Altura del alumno "+(i+1)+" es "+altura.get(i));
			if(altura.get(i)<A) {
				System.out.println("La altura es menor que la media");
			}
			else if(altura.get(i)>A) {
				System.out.println("La altura es mayor que la media");
			}
		}
		System.out.println("La media de las alturas es "+A);
		
		
	}

*/
}
