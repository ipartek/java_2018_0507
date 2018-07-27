package ejercicios.basicos.liniciales;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioArraylist {

	public static void main(String[] args) {
		
	}

	
/*	EJERCICIO 4
	public static void main(String[] args) {
		ArrayList<String> cadenas = new ArrayList<String>();
		leerArray(cadenas);
		System.out.println("La cadena de caracteres mas larga es: "+cadenaLarga(cadenas));
	}
	
	public static void leerArray(ArrayList<String> cadenas) {
        Scanner sc = new Scanner(System.in);
        String s;
        boolean masCadenas;
        do {
        	masCadenas = true;
        	System.out.println("Introduce una cadena de caracteres | FIN para termimar");
        	s = sc.nextLine();
        	if(s.equalsIgnoreCase("FIN")) {
        		masCadenas = false;
        	}else {
        		cadenas.add(s);
        	}
        	
        }while(masCadenas);
        System.out.println(cadenas);
	}

	public static String cadenaLarga(ArrayList<String> cadena) {
		String mayor = cadena.get(0);
		for(int i = 1; i<cadena.size(); i++) {
			if(cadena.get(i).length()>mayor.length()) {
				mayor = cadena.get(i);
			}
		}
		System.out.println(mayor);
		return mayor;
	}
*/
/*	EJERCICIO 3 segunda parte
	public static void main(String[] args) {
		
		ArrayList<Integer> valores = pedirValores();
		mostrar(valores);
		desplazar(valores);
		mostrar(valores);		
	}
	
	public static ArrayList<Integer> pedirValores(){
	    ArrayList<Integer> valores = new ArrayList<Integer>();
	    int N;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduce el numero de elementos que va a contener el Array <0");
	    	N = sc.nextInt();
		}while (N<=0);
		for(int i = 0; i<N; i++) {
			System.out.println("Introduce el valor "+(i+1)+" del Array");
			int V = sc.nextInt();
			valores.add(V);
		}
		return valores;
	}

	public static void desplazar(ArrayList<Integer> a) {
		int aux = a.get(a.size()-1);     
        a.add(0,aux);
        a.remove(a.size()-1);
	}
	
	public static void mostrar(ArrayList<Integer> a) {
		System.out.println(a);
	}
*/	
	
	
/*	EJERCICIO 3
	public static void main(String[] args) {
		
		ArrayList<Integer> N = darValores();
		desplazarDerecha(N);
		
	}
	
	public static ArrayList<Integer> darValores(){
		ArrayList<Integer> desplazar = new ArrayList<Integer>();
		desplazar.add(15);
		desplazar.add(22);
		desplazar.add(4);
		desplazar.add(56);
		desplazar.add(71);
		desplazar.add(10);
		desplazar.add(2);
		
		return desplazar;
	}
	
	public static void desplazarDerecha(ArrayList<Integer> a) {
		int aux = a.get(a.size()-1);
		for (int i = a.size() - 1; i > 0; i--) { 
            a.set(i, a.get(i - 1));
        }
        a.set(0, aux);
        for(int i = 0; i<a.size(); i++) {
        	System.out.println(a.get(i));
        }
	}
*/
	
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
