package a.webEjers.ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LlenarArrayAleatorioNOFUNCIONA {
/*En esta entrada vamos a escribir un método Java que llene un array de enteros con números
aleatorios.*/
	
	//Pagina 72.
	static int [] numeros;
	
	public static void main(String args[]) {
	
		numeros=llenarArrayAleatorio(0, 5, 10);
		for (int i=0;i<numeros.length;i++) {
			System.out.println(numeros[i]);
		}
		
	}
	
	public static int[] llenarArrayAleatorio(int desde, int hasta, int tam) {
		int[] numeros = new int[tam];
		Random rnd = new Random();
		int n;
		for (int i = 0; i < numeros.length; i++) {
			do {
				n = rnd.nextInt(hasta - desde + 1) + desde;
			} while (comprobarSiContiene(numeros, i, n));
			
			numeros[i] = n;
		}
		return numeros;
	}
	
	public static boolean comprobarSiContiene(int[] numeros, int indice, int valor) {
		for (int i = 0; i < indice; i++) {
			if (numeros[i] == valor) {
				return true;
			}
		}
		return false;
	}
}
