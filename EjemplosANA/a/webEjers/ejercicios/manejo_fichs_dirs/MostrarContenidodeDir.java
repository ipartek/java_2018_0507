package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.File;
import java.util.Arrays;

public class MostrarContenidodeDir {
	public static void main(String[] args) {
		File directorio = new File("c:/"); //directorio a listar
		String[] lista = directorio.list();
		Arrays.sort(lista);
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
}
