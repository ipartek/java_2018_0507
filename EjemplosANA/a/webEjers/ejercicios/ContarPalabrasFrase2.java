package a.webEjers.ejercicios;

import java.util.Scanner;

public class ContarPalabrasFrase2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.print("Introduce una frase: ");
		s = sc.nextLine();
		contarPalabras(s);
		sc.close();
	}

	public static int contarPalabras(String s) {
		int contador = 1, pos;
		s = s.trim(); //eliminar los posibles espacios en blanco al principio y al final
		if (s.isEmpty()) { //si la cadena está vacía
			contador = 0;
		} else {
			pos = s.indexOf(" "); //se busca el primer espacio en blanco
			while (pos != -1) { //mientras que se encuentre un espacio en blanco
				contador++; //se cuenta una palabra
				pos = s.indexOf(" ", pos + 1); //se busca el siguiente espacio en blanco
			} //a continuación del actual
		}
		return contador;
	}
}
