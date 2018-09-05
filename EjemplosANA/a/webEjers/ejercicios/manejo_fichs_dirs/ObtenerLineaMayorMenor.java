package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

//pag.165
/*
Programa que obtiene la línea de mayor tamaño y la de menor tamaño dentro de un fichero de
texto.
Para resolver este ejercicio se utiliza la clase Scanner para leer el fichero. La lectura se realiza
línea a línea hasta que se alcance el final del fichero. Para determinar cuál es la de mayor
longitud y cuál es la menor, se lee la primera línea del fichero y se toma como la línea mayor
y la menor. A continuación se leen el resto de líneas y para cada una se compara su tamaño
con la mayor y menor actuales.
El nombre del fichero se selecciona de forma gráfica utilizando la clase JFileChooser.*/

public class ObtenerLineaMayorMenor {
	
	public static void main(String[] args) {
		Scanner entrada = null;
		String cadena, mayor = null, menor = null;
		JFileChooser j = new JFileChooser();
		j.showOpenDialog(j); //muestra la ventana para seleccionar el archivo
		try {
			String ruta = j.getSelectedFile().getAbsolutePath(); //obtiene la ruta del archivo seleccionado
			File f = new File(ruta); //se crea un File con el archivo seleccionado
			entrada = new Scanner(f); //se crea un Scanner para leer el archivo
			
			if (entrada.hasNext()) { //si el archivo no está vacío
				cadena = entrada.nextLine(); //lectura de la primera línea
				mayor = menor = cadena; //se toma como mayor y menor
			}
			while (entrada.hasNext()) { //resto de líneas del fichero
				cadena = entrada.nextLine(); //se lee la siguiente línea
				if (cadena.length() > mayor.length()) { //si su longitud es mayor que la longitud de la mayor actual
					mayor = cadena; //se toma como mayor
				} else if (cadena.length() < menor.length()) { //sino si su longitud es menor que la longitud de la menor actual
					menor = cadena;
				}
			}
			if (mayor == null || menor == null) {
				System.out.println("Fichero vacío");
			} else {
				System.out.println("Línea más larga:");
				System.out.println(mayor);
				System.out.println("Línea más corta:");
				System.out.println(menor);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) { //si se cierra la ventana de selección del archivo sin haberlo seleccionado.
			System.out.println("No se ha seleccionado ningún archivo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}
}
