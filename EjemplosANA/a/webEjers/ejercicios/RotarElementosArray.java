package a.webEjers.ejercicios;
import java.util.ArrayList;
import java.util.Scanner;

public class RotarElementosArray {
	
		public static void main(String[] args) {
			ArrayList<Integer> A = leerArray();
			mostrar(A);
			//utilizando el método clásico
			desplazarDerecha(A);
			mostrar(A);
			//utilizando solo los métodos de ArrayList
			desplazarDerecha2(A);
			mostrar(A);
		}
		//pedir por teclado los valores del ArrayList
		public static ArrayList<Integer> leerArray() {
			Scanner sc = new Scanner(System.in);
			ArrayList<Integer> numeros = new ArrayList();
			int N;
			do {
				System.out.print("Número de elementos del array (>0): ");
				N = sc.nextInt();
				} while (N <= 0);
				for (int i = 0; i < N; i++) {
				System.out.print("elemento[" + i + "]= ");
				numeros.add(sc.nextInt());
			}
			sc.close();
			return numeros;
		}
		//método clásico: guardamos el último elemento en un auxiliar,
		//desplazamos todos los elementos una posición a la derecha
		//finalmente guardamos en el primer elemento el valor guardado en el auxiliar
		public static void desplazarDerecha(ArrayList<Integer> a) {
			int i;
			int aux = a.get(a.size() - 1); //guardar el último elemento en una variable
			for (i = a.size() - 1; i > 0; i--) { //desplazar los elementos
				a.set(i, a.get(i - 1)); //a cada elemento se le asigna el anterior
			}
			a.set(0, aux); //asignar al primero el último que se guardó al principio
		}
		//Utilizando métodos de ArrayList:
		//guardamos el último elemento en una variable
		//insertamos este elemento al principio
		//eliminamos el último elemento
		public static void desplazarDerecha2(ArrayList<Integer> a) {
			int aux = a.get(a.size()-1);
			a.add(0,aux);
			a.remove(a.size()-1);
		}
		//Método para mostrar todo el ArrayList
		public static void mostrar(ArrayList<Integer> a) {
			System.out.println(a);
		}
}
