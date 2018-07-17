//Mostrar las unidades de disco del sistema.
package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.io.File;

public class EjercicioFicherosDirectorios1 {

	File[] discos = File.listRoots();
	String sistema = System.getProperty("os.name").toString().toLowerCase();
	public void mostrarUnidadesDisco(){
		System.out.println("El sistema operatico es: \n");
		System.out.println(sistema);
		System.out.println("Y tiene las siguientes unidades de disco:");
		for(File unidadesDisco: discos) {
			System.out.print(unidadesDisco + " ");
		}
		//System.out.println();
	}
}
