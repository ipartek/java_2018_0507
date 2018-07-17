//Mostrar todos los archivos de un directorio
package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.io.File;
import java.util.Scanner;

public class EjercicioFicherosDirectorios2 extends LeerTeclado{

	public String direccion;
	File carpeta;
	File[] listaArchivos;
	
	public EjercicioFicherosDirectorios2(Scanner sc) {
		super(sc);
	}
	
	public void leerDirectorio() {
		System.out.println("Introduzca la direcion");
		direccion = leerString(direccion);
		System.out.println("A continuacion se indicaran los archivos y carpetas del directorio.");
		carpeta = new File(direccion);
		listaArchivos  = carpeta.listFiles();
		for (int i = 0;i < listaArchivos.length; i++) {
			if(listaArchivos[i].isFile()) {
				System.out.println("Archivo: "+ listaArchivos[i].getName());
			}else if(listaArchivos[i].isDirectory()) {
				System.out.println("Carpeta: " +listaArchivos[i].getName());
			}
		}
	}

}
