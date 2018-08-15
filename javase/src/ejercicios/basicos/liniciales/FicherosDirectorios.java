package ejercicios.basicos.liniciales;

import java.io.File;
import java.util.Arrays;

public class FicherosDirectorios {
	public static void main(String[] args) {

		File directorio = new File("c:/"); //directorio a listar
	    String[] lista = directorio.list();
	    Arrays.sort(lista);
	    for (int i = 0; i < lista.length; i++) {
	        System.out.println(lista[i]);
	    }
	}
	
/*	EJERCICIO 1
	public static void main(String[] args) {
        File [] unidades = File.listRoots();
        System.out.printf("   %20s %20s %n" , "Tamaño Total", "Tamaño disponible");
        for(File f : unidades){
            System.out.print(f);
            System.out.printf("%20s %20s %n", f.getTotalSpace(), f.getFreeSpace());
        }
    }
*/
}
