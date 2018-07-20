package com.ipartek.formacion.uf2216.main;

import com.ipartek.formacion.uf2216.dao.RevistaDao;
import com.ipartek.formacion.uf2216.pojo.Revista;
import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @class Main
 * contiene metodos validadores y necesarios para operar
 * @author AnaMAMM
 *
 */
public class Main {
	/**
	 * variables para el switch de opciones
	 */
	private static final int INSERTAR = 1;
	private static final int LISTAR = 2;
	private static final int GUARDAR = 3;
	private static final int SALIR = 0;

	
	private static RevistaDao dao = RevistaDao.getInstance();
	private static Scanner s = new Scanner(System.in);

	/**
	 * necesario para guardar un fichero
	 */
	private static final String RUTA_FICHERO = "C:\\trabajos\\fichero.txt";
	private static final boolean AUTO_FLUSH = true;
	private static final boolean SOBREESCRIBIR = true;

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			// Se espera la entrada de un entero , si no es un entero entrara en el catch
			try {
				opcion = s.nextInt();
			} catch (Exception ex) {
				// No es un numero entonces
				p("No es una entrada valdia");
				// Limpia lo escrito, porque sino entraria en bucle
				s.next();
				// Opcion -1 para que no coincida con ninguna de las opciones
				opcion = -1;
			}
			
			switch (opcion) {
			case INSERTAR:
				insertarRevista();
				break;
			case LISTAR:
				listarRevistas();
				break;
			case GUARDAR:
				guardarRevistas();
				break;
			
			}
		
		} while (opcion != SALIR);

	}

	/**
	 * inserta una revista
	 */
	public static void insertarRevista() {
		// Se usa para almacenar si el valor introducido es correcto o no
		boolean resultado;
		// Definidas fuera de los do las variables para luego asignarselas a revista
		String titulo;
		String isbn;
		int paginas;
		String digital;
		int id;
		String confirmacion;
		do {
			p("Insertar titulo de la revista");
			// Se pide un String
			titulo = s.next();
			resultado = validarTitulo(titulo);
		} while (!resultado);
		do {
			p("Inserta el ISBN de la revista");
			// Se pide un String
			isbn = s.next();
			resultado = validarIsbn(isbn);
		} while (!resultado);
		do {
			p("Insertar numero de paginas de la revista");
			try {
				// Se pide un entero, en caso de que no sea un entero entra en el catch
				paginas = s.nextInt();
			} catch (Exception ex) {
				// Mostramos el error
				p("Error de entrada no es un numero");
				// Establece paginas a un valor que no es admitido por el validador , para
				// volver a introducir de nuevo las paginas
				paginas = 0;
				// Se limpia la inserccion para que no entre bucle
				s.next();
			}
			// Se valida
			resultado = validarPaginas(paginas);
		} while (!resultado);
		do {
			p("La revista es digital? (SI/NO)");
			// Se pide un String
			digital = s.next();
			resultado = validarDigital(digital);
		} while (!resultado);
		do {
			p("Insertar ID de la revista");
			try {
				// Se pide un entero , en caso de que no sea de ese tipo entrara en el catch
				id = s.nextInt();
			} catch (Exception ex) {
				// Se muestra el error
				p("Error de entrada no es un numero");
				// Se estable en -1 el id , para capturarlo y volver a pedirle al usuario la
				// inserccion del id
				id = -1;
				// Se limpia la inserccion para que no entre bucle
				s.next();
			}
			// Si el valor es distinto de -1 , significa que no ha dado un excepcion , por
			// lo que continuamos
			if (id != -1) {
				// Se busca que ya exista una revista con ese id
				Revista revista = dao.getById(id);
				// Si la revista existe entonces ese id ya esta en uso
				if (revista != null) {
					p("Ese id ya esta en uso");
					resultado = false;

				} else {
					// Si no existe el resultado es valido
					resultado = true;
				}
			} else {
				resultado = false;
			}

		} while (!resultado);
		// Una vez que el id es valido
		boolean isDigital;
		// Se conbierte el digital que era una entrada de si / no a true o false para
		// que se pueda usar en el revista
		if (digital.equalsIgnoreCase("si")) {
			isDigital = true;
		} else {
			isDigital = false;
		}
		// Se crea la revista con los datos introducidos
		Revista revista = new Revista(titulo, isbn, paginas, isDigital, id);
		// Se muestra la cebzera
		mostrarCabezeraRebista();
		// Se muestra la revista introducida
		mostrarRevista(revista);

		do {
			p("Desea guardar la revista (SI/NO)");
			// Se pregunta si se quiere guardar la revista
			confirmacion = s.next();
			resultado = validarConfirmacion(confirmacion);
		} while (!resultado);

		// Si la respuesta es valida , se comprueba si ha seleccionado si
		if (confirmacion.equalsIgnoreCase("si")) {
			// Se guarda en el dao la revista
			dao.insert(revista);
		}

	}

	
	
	
	
	
	/**
	 * muestra el menu por consola
	 */
	private static void mostrarMenu() {
		p("------------");
		p("Revistas");
		p("------------");
		p("");
		p("1. Insertar Revista");
		p("2. Listar revistas insertadas");
		p("3. Guardar en un fichero txt todas las revistas");
		p("");
		p("0. Salir");
		p("");
		p("Elige una opción");
	}

	/**
	 * lista las revistas
	 */
	public static void listarRevistas() {
		// Se cogen todas las revistas del dao
		List<Revista> revistas = dao.getAll();
		// Si el tamaño de las revistas es mayor que 0
		if (revistas.size() > 0) {
			// Se muestra la cabezera de revistas
			mostrarCabezeraRebista();
			// Se recorren las revistas y las mostramos
			for (Revista revistal : revistas) {
				mostrarRevista(revistal);
			}
		} else {
			p("NO hay revistas para listas");
		}

	}

	public static void guardarRevistas() {
		try {
			// Se crean los accesos al fichero
			FileWriter fw = new FileWriter(RUTA_FICHERO, SOBREESCRIBIR);
			PrintWriter pw = new PrintWriter(fw, AUTO_FLUSH);
			// Se cogen todas las revistas del dao
			List<Revista> revistas = dao.getAll();
			// Si el tamaño de las revistas es mayor que 0
			if (revistas.size() > 0) {
				// Se imprime una cabecera para que quede mas elegante
				pw.println("ID" + "\t" + "TITULO" + "\t" + "PAGINAS" + "\t" + "ISBN" + "\t" + "DIGITAL");
				// Se recorren las revistas y por cada revista se imprimen sus atributos
				for (Revista revista : revistas) {
					pw.println(revista.getId() + "\t" + revista.getTitulo() + "\t" + revista.getPaginas() + "\t"
							+ revista.getIsbn() + "\t" + revista.isDigital());
				}
			} else {
				// En caso de que no haya ninguna revista
				p("No existen revistas");
				pw.println("No existen revistas");
			}
			// Se cierran
			pw.close();
			fw.close();

			p("Fichero guardado en " + RUTA_FICHERO);
		} catch (Exception ex) {
			p("Error no se pudo guardar en " + RUTA_FICHERO);
			ex.printStackTrace();
		}
	}

	
	
	/**
	 * muestra una revista
	 * @param revista
	 */
	// recibe revista e imprime por pantalla sus atributos
	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + revista.getTitulo() + "\t" + revista.getPaginas() + "\t" + revista.getIsbn() + "\t"
				+ revista.isDigital());
	}
	
	//VALIDADORES
	
	/**
	 * valida que el isbn tenga 10 digitos
	 * @param isbn
	 * @return
	 */
	public static boolean validarIsbn(String isbn) {
		boolean res;
		if (isbn.matches("\\d{10}")) {
			p("El ISBN ingresado  es valido");
			res = true;
		} else {
			p("El ISBN ingresado no es valido");
			res = false;
		}
		return res;

	}
	
		/**
		 * valida la confirmacion para si o no
		 * @param confirmacion
		 * @return
		 */
		public static boolean validarConfirmacion(String confirmacion) {
			boolean res;
			if (confirmacion.equalsIgnoreCase("si")) {
				p("Es valida la entrada, guardar revista");
				res = true;
			} else if (confirmacion.equalsIgnoreCase("no")) {
				p("Es valida la entrada,no guardar revista");
				res = true;
			} else {
				p("No valida la entrada inserte SI/NO");
				res = false;
			}
			return res;

		}

		/**
		 * valida si la revista es digital o papel
		 * @param digital
		 * @return
		 */
		public static boolean validarDigital(String digital) {
			boolean res;
			if (digital.equalsIgnoreCase("si")) {
				p("Es valida la entrada, revista digital");
				res = true;
			} else if (digital.equalsIgnoreCase("no")) {
				p("Es valida la entrada, revista de papael");
				res = true;
			} else {
				p("No es valida la entrada inserte SI/NO");
				res = false;
			}
			return res;
		}

		/**
		 * valida el numero de paginas
		 * @param paginas
		 * @return
		 */
		public static boolean validarPaginas(int paginas) {
			boolean res;
			if (paginas >= 1) {
				p("Las paginas son validas");
				res = true;
			} else {
				p("Las paginas no son validas");
				res = false;
			}
			return res;
		}

		/**
		 * valida que el titulo tenga entre 3 y 150 caracteres
		 * @param titulo
		 * @return
		 */
		public static boolean validarTitulo(String titulo) {
			boolean res;
			if (titulo.matches("[a-zA-Z]{3,150}")) {
				p("El titulo ingresado  es valido");
				res = true;
			} else {
				p("El titulo ingresado no es valido");
				res = false;
			}
			return res;

		}

	
	
	
	//METODOS generales
		
	//	
	// imprime en pantalla las cabezeras de revista
	private static void mostrarCabezeraRebista() {
		p("ID" + "\t" + "TITULO" + "\t" + "PAGINAS" + "\t" + "ISBN" + "\t" + "DIGITAL");
	}

	
   //para no tener que escribir system.out...... todo el tiempo
	public static void p(String s) {
		System.out.println(s);
	}

}