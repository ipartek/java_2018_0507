package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

import com.ipartek.formacion.uf2216.accesodatos.CrudAble;
import com.ipartek.formacion.uf2216.accesodatos.RevistaArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;
import com.ipartek.formacion.uf2216.Utils;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
		// TODO Auto-generated method stub

		cargarRevistas();
		mostrarMenu();

		Scanner sc = new Scanner(System.in);
		String opcion = sc.next().trim();

		switch (opcion) {
		case "1":
			listadoRevistas();
			main(null);
			break;
		case "2":
			revistasNuevo();
			main(null);
			break;
		case "3":
			guardarFichero();
			main(null);
			break;
		case "0":
			menuSalir();
			break;
		default:
			System.out.println(">>Opción no válida");
			main(null);
		}
		sc.close();
	}

	private static void mostrarMenu() {
		p("------------");
		p("GESTIÓN DE REVISTAS");
		p("------------");
		p("1. Listado de revistas");
		p("2. Introducir revista");
		p("3. Generar fichero de revistas");
		p("");
		p("0. Salir");
		p("");
		p(">>Elige una opción: ");
	}

	private static void guardarFichero() throws IOException {
		File f2 = new File("fichero.txt");
		if (f2.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f2));

			CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
			for (Revista revista : dao.getAll()) {
				bw.write(revista.getId() + "\t" + revista.getIsbn() + "\t" + revista.getTitulo() + "\t"
						+ revista.getPaginas() + "\t" + revista.getFormato() + "\n");
			}
			bw.close();
		} else {
			// File doesn't exist. Crearlo...
			f2.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
			CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
			for (Revista revista : dao.getAll()) {
				bw.write(revista.getId() + revista.getIsbn() + revista.getTitulo() + revista.getPaginas()
						+ revista.getFormato());
			}
			bw.close();
		}

	}

	private static void revistasNuevo() throws InstantiationException, IllegalAccessException, IOException {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID de la revista: ");
		long id = Utils.leerLong();

		Scanner sc2 = new Scanner(System.in);
		p(">>Introduce el isbn de la revista: ");
		String isbn = sc2.nextLine().trim();
		if ((isbn.length() != 10))
			p(">>Introduce un isbn numérico de 10 caracteres: ");
		isbn = sc2.nextLine().trim();
		// Habría que utilizar excepciones pero no estoy muy suelto con ellas.
		// Habría que utilizar expresiones regulares para validar que cumplen el formato
		// pero tampco he practicado lo suficiente
		// He probado a resolverlo con un while pero se volvía loco repitiendo el
		// mensaje de ayuda. 

		Scanner sc3 = new Scanner(System.in);
		p(">>Introduce el titulo de la revista: ");
		String titulo = sc3.nextLine().trim();
		if ((titulo.length() < 3) || (titulo.length() > 150)) {
			p("Introduce un título de entre 3 y 150 caracteres: ");
			titulo = sc3.nextLine().trim();
		}
		// Habría que utilizar excepciones pero no estoy muy suelto con ellas.
		// He probado a resolverlo con un while pero se volvía loco repitiendo el
		// mensaje de ayuda.

		Scanner sc4 = new Scanner(System.in);
		p(">>Introduce el número de páginas de la revista: ");
		Integer paginas = Utils.leerInteger();

		Scanner sc5 = new Scanner(System.in);
		p(">>Introduce el formato del libro (D)igital / (P)apel: ");
		Boolean formato = true;
		String opcionFormato = sc5.next().trim();
		switch (opcionFormato) {
		case "D":
			formato = true;
			break;
		case "P":
			formato = false;
			break;
		default:
			System.out.println(">>Opción no válida");
			main(null);
		}

		Revista revista = Revista.class.newInstance();
		revista.setId(id);
		revista.setIsbn(isbn);
		revista.setTitulo(titulo);
		revista.setPaginas(paginas);
		revista.setFormato(formato);

		mostrarCabecera();
		mostrarRevista(revista);
		p(">>Pulse (S) para guardar, cualquier otra tecla para cancelar:");

		String confirmacion = sc5.next().trim();

		if ("S".equals(confirmacion)) {
			dao.insert(revista);
			p("La revista se ha insertado");
		} else {
			p("Revista NO guardada");
			main(null);
		}

		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		sc5.close();
	}

	public static void listadoRevistas() {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
		mostrarCabecera();
		for (Revista revista : dao.getAll()) {
			mostrarRevista(revista);
		}
	}

	private static void mostrarCabecera() {
		p("ID\tISBM\t\tTITULO\tPAGS\tFORMATO");
	}

	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + revista.getIsbn() + "\t" + revista.getTitulo() + "\t" + revista.getPaginas() + "\t"
				+ revista.getFormato());
	}

	private static void menuSalir() {
		p("Gracias por utilizar esta aplicación. Adiós");
	}

	private static void cargarRevistas() throws InstantiationException, IllegalAccessException {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();

		for (int i = 1; i <= 2; i++) {
			dao.insert(new Revista(i, "000000000" + i, "titulo" + i, 0, true));
		}
	}

	public static void p(String s) {
		System.out.println(s);

	}

}
