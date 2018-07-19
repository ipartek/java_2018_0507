package com.ipartek.formacion.claseFile;

import java.io.File;
import java.util.Arrays;

public class MainEjercicioFiles {

	/*
	 * 1. Mostrar las unidades de disco del sistema.
	 * */
	public static void mainFile1(String[] args) {
		File[] unidades = File.listRoots();
		
		System.out.printf("   %20s %20s %n", "Tamaño Total", "Tamaño disponible");
		
		for (File f : unidades) {
			System.out.print(f);
			System.out.printf("%20s %20s %n", f.getTotalSpace(), f.getFreeSpace());
		}
	}
	
	/*
	 * 2. Mostrar el contenido de un directorio.
	 * */
	public static void main(String[] args) {
		File directorio = new File("C:/"); 
		String[] lista = directorio.list();
		
		Arrays.sort(lista);
		
		for (int i = 0; i < lista.length; i++) {
		    System.out.println(lista[i]);
		}
	}
}
