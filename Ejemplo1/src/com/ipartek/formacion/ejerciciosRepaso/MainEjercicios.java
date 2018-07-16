package com.ipartek.formacion.ejerciciosRepaso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class MainEjercicios {

	/*
	 * 4. Guardar en un array los 20 primeros números pares
	 */
	public static void mainEjercicio4(String[] args) {

		int[] numerosPares = new int[20];
		int numeroPar = 0;

		for (int i = 0; i < numerosPares.length; i++) {
			numerosPares[i] = numeroPar;
			numeroPar += 2;
		}
		for (int i = 0; i < numerosPares.length; i++) {
			System.out.println(numerosPares[i]);
		}
	}

	
	
	/*
	 * 5. Programa Java que guarda en un array 10 números enteros que se leen por
	 * teclado. A continuación se recorre el array y calcula cuántos números son
	 * positivos, cuántos negativos y cuántos ceros.
	 */
	public static void mainEjercicio5(String[] args) {
		int[] numeros = new int[20];
		int contadorPositivo = 0;
		int contadorNegativo = 0;
		int contadorCero = 0;

		// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		for (int i = 0; i < numeros.length; i++)
			numeros[i] = ThreadLocalRandom.current().nextInt(-10, 10 + 1);

		// Mostrar array
		for (int i = 0; i < numeros.length; i++) {
			// System.out.println(numeros[i]);
			if (numeros[i] > 0) {
				contadorPositivo++;
				continue;
			}
			if (numeros[i] < 0) {
				contadorNegativo++;
				continue;
			}
			contadorCero++;
		}
		System.out.println("Positivos: " + contadorPositivo + "\nNegativos: " + contadorNegativo + "\nCeros: " + contadorCero);
	}

	
	
	/*
	 * 8. Leer el nombre y sueldo de 20 empleados y mostrar el nombre y sueldo del
	 * empleado que más gana.
	 */
	public static void main(String[] args) {
		Map<String, Integer> empleados = new LinkedHashMap<>();
		empleados.put("Antxon2", 2000);
		empleados.put("Antxon", 1500);
		empleados.put("Antxon4", 1300);
		empleados.put("Antxon3", 2200);
		empleados.put("Antxon5", 1800);

		System.out.println("Desordenados:");
		System.out.println("Nombres\t\tSueldos");
		for (Entry<String, Integer> empleado : empleados.entrySet()) {
			System.out.println(empleado.getKey() + "\t\t" + empleado.getValue());
		}

		// Cambiar nuestro LinkedHashMap a TreeMap hace que el mapa se ordene por su "key"
		System.out.println("\nOrdenados por empleado: ");
	    Map<String, Integer> empleadosOrdenadosPorNombre = new TreeMap<String, Integer>(empleados);
	    for (Map.Entry<String, Integer> empleado : empleadosOrdenadosPorNombre.entrySet()) {
	    	System.out.println(empleado.getKey() + "\t\t" + empleado.getValue());
	    }
	    
		/* Ordenar Map por valor */
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(empleados.entrySet());

		compararPorValor(entryList);

		empleados.clear();

		System.out.println("\nOrdenados por sueldo: ");
		System.out.println("Nombres\t\tSueldos");
		for (Entry<String, Integer> empleado : entryList) {
			empleados.put(empleado.getKey(), empleado.getValue());
			System.out.println(empleado.getKey() + "\t\t" + empleado.getValue());
		}

	}

	private static void compararPorValor(List<Entry<String, Integer>> entryList) {
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
	}

	
	
	/*
	 * 2. Pasar de decimal a binario de forma recursiva.
	 */
	public static void mainEjercicioRecursivo(String[] args) {
		int numero = 10;
		System.out.println("Numero en decimal: " + numero);

		System.out.print("Numero en binario: ");
		decimalABinario(numero);
	}

	private static void decimalABinario(int num) {
		if (num < 2) {
			System.out.print(num);
			return;
		}
		decimalABinario(num / 2);
		System.out.print(num % 2);
	}
}
