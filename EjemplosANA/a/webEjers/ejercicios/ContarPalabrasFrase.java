package a.webEjers.ejercicios;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ContarPalabrasFrase {
	/*Contar el número de palabras de una frase en Java
	Programa Java para contar el número de palabras que contiene una frase.
	El programa lee un texto por teclado y lo guarda en un String. A continuación mostrará el
	número de palabras que contiene.
	La forma más sencilla de resolverlo es utilizando la clase StringTokenizer. Esta clase sirve
	para dividir un String en partes, según unos delimitadores. Uno de estos delimitadores es el
	espacio en blanco, por lo tanto podemos aplicar StringTokenizer al texto ya que las palabras
	en un texto están separadas por espacios en blanco. El método countTokens() nos dirá cuantos
	elementos se han obtenido o lo que es lo mismo, cuantas palabras contiene el texto.
	*/


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		System.out.print("Introduce una frase: ");
		frase = sc.nextLine();
		StringTokenizer st = new StringTokenizer(frase);
		System.out.println("Número de palabras: " + st.countTokens());
		sc.close();
	}
	
}
