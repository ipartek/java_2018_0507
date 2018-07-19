package com.ipartek.formacion.libro.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.libro.accesodatos.CrudAble;
import com.ipartek.formacion.libro.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.libro.pojo.Libro;

public class LibroMenu {

	private static final String SALIR = "0";
	private static final String ACTUALIZAR = "5";
	private static final String BORRAR = "4";
	private static final String NUEVO = "3";
	private static final String ARTICULO = "2";
	private static final String LISTADO = "1";

	public static void libroMenu() throws InstantiationException, IllegalAccessException {

		mostrarMenuLibro();

		// TODO: Hacer el menú que se repita cada vez e implementar la lectura de
		// teclado
		Scanner sc = new Scanner(System.in);
		String opcion =  sc.next();

		switch (opcion) {
		case LISTADO:
			listadoLibros();
			break;
		case ARTICULO:
			librosArticulo();
			break;
		case NUEVO:
			librosNuevo();
			break;
		case BORRAR:
			librosBorrar();
			break;
		case ACTUALIZAR:
			librosActualizar();
			break;
		case SALIR:
			MainMenu.main(null);
			break;
		default: System.out.println(">>Opción no válida: ");
		libroMenu();
		}
		sc.close();
	}

	private static void mostrarMenuLibro() {
		p("------------");
		p("Libros");
		p("------------");
		p("1. Listado de libros");
		p("2. Buscar un libro");
		p("3. Añadir un nuevo libro");
		p("4. Borrar un libro");
		p("5. Actualizar un libro");
		p("");
		p("0. Volver");
		p("");
		p(">>Elige una opción: ");
	}

	public static void listadoLibros() {
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();
		mostrarCabecera();
		for (Libro libro : dao.getAll()) {
			mostrarLibro(libro);
		}
	}
	

	private static void librosArticulo() {
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();

		Scanner sc = new Scanner(System.in);
		p("Introduce el ID del libro: ");
		long identificador = sc.nextLong();

		Libro libro = dao.getById(identificador);
		mostrarCabecera();
		mostrarLibro(libro);
		sc.close();
	}
	

	private static void librosNuevo() throws InstantiationException, IllegalAccessException {
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID del libro: ");
		long id = sc1.nextLong();

		Scanner sc2 = new Scanner(System.in);
		p("Introduce el isbn del libro: ");
		String isbn = sc2.next().trim();

		Scanner sc3 = new Scanner(System.in);
		p("Introduce el titulo del libro: ");
		String titulo = sc3.next().trim();

		Scanner sc4 = new Scanner(System.in);
		p("Introduce el autor del libro: ");
		String autor = sc4.next().trim();

		Scanner sc5 = new Scanner(System.in);
		p("Introduce la editorial del libro: ");
		String editorial = sc5.next().trim();

//		Scanner sc6 = new Scanner(System.in);
//		p("Introduce el Cliente del libro: ");
//		String cliente = sc6.next();

		Libro libro = Libro.class.newInstance();
		libro.setId(id);
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
//		libro.setCliente(cliente);

		dao.insert(libro);

		p("El libro se ha insertado");
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		sc5.close();
//		sc6.close();

	}

	
	private static void librosBorrar() {
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();

		Scanner sc = new Scanner(System.in);
		p("Introduce el ID de la película a borrar: ");
		long id = sc.nextLong();
		dao.delete(id);
		sc.close();

		p("Libro borrado");
	}
	


	private static void librosActualizar() throws InstantiationException, IllegalAccessException {
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID del libro a actualizar: ");
		long id = sc1.nextLong();

		Libro libro = dao.getById(id);

		Scanner sc2 = new Scanner(System.in);
		p("Introduce el nuevo isbn del libro: ");
		String isbn = sc2.next().trim();

		Scanner sc3 = new Scanner(System.in);
		p("Introduce el nuevo titulo del libro: ");
		String titulo = sc3.next().trim();

		Scanner sc4 = new Scanner(System.in);
		p("Introduce el nuevo autor del libro: ");
		String autor = sc4.next().trim();

		Scanner sc5 = new Scanner(System.in);
		p("Introduce la nueva editorial del libro: ");
		String editorial = sc5.next().trim();

//		Scanner sc6 = new Scanner(System.in);
//		p("Introduce el nuevo Cliente del libro: ");
//		String cliente = sc6.next();

		Libro libro2 = Libro.class.newInstance();
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
//		libro.setCliente(cliente);
		dao.insert(libro2);

		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		sc5.close();
//		sc6.close();

		p("Libro actualizado");
	}


	private static void mostrarCabecera() {
		p("ID\tISBM\tTITULO\tAUTOR\tEDITORIAL\tCLIENTE");
	}
	

	private static void mostrarLibro(Libro libro) {
		p(libro.getId() + "\t" + libro.getIsbn() + "\t" + libro.getTitulo() + libro.getAutor() + libro.getEditorial()
				+ libro.getCliente());
	}
	
	
	public static void p(String s) {
		System.out.println(s);
	}
}
