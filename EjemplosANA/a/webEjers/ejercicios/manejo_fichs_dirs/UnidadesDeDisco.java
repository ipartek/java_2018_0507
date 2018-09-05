package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.File;

public class UnidadesDeDisco {
	public static void main(String[] args) {
		File [] unidades = File.listRoots();
		System.out.printf(" %20s %20s %n" , "Tamaño Total", "Tamaño disponible");
		for(File f : unidades){
			System.out.print(f);
			System.out.printf("%20s %20s %n", f.getTotalSpace(), f.getFreeSpace());
		}
	}
}
