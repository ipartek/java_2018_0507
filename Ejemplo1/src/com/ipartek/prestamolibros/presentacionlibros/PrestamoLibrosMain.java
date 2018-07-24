package com.ipartek.prestamolibros.presentacionlibros;


import java.util.Scanner;

import com.ipartek.prestamolibros.Cliente;
import com.ipartek.prestamolibros.Libro;
import com.ipartek.prestamolibros.accesoDatos.ClientesArrayDAO;
import com.ipartek.prestamolibros.accesoDatos.CrudAble;
import com.ipartek.prestamolibros.accesoDatos.LibrosArrayDAO;



public class PrestamoLibrosMain {

	public static boolean salir = true;
	public static int opcion;
	public static int opcionLibro;
	public static int opcionCliente;
	public static char caracter;
	public static String letter;
	public static int id;
	public static String isbn;
	public static String titulo;
	public static String autor;
	public static String editorial;
	public static boolean alquilado;
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc3 = new Scanner(System.in);
	static LeerTeclado lt = new LeerTeclado(sc);
	static LeerTeclado lt2 = new LeerTeclado(sc2);
	static LeerTeclado lt3 = new LeerTeclado(sc3);
	 //Creando aqui el dao no requiero usarlo en cada metodo
	static CrudAble<Cliente> daoC = ClientesArrayDAO.getInstance();
	static CrudAble<Libro> daoL = LibrosArrayDAO.getInstance();
	
	
	public static void main(String[] args) {
		
		cargarLibros();
		cargarClientes();
		mostrarMenu();
		
	}
	private static void mostrarMenuLibros() {
		p("------------");
		p("Prestamo Libros");
		p("------------");
		p("");
		p("1. Listado de libros");
		p("...");
		p("2. Indica que libro quieres ver. (Por Id)");
		p("...");
		p("3. Añadir libro.");
		p("...");
		p("4. Modificar libro.");
		p("...");
		p("5. Eliminar libro.");
		p("...");
		p("9. volver");
		p("...");
		p("0. Salir");
		p("...");
		p("Elige una opción");
		opcionMenuLibros(opcionLibro);
	}
	private static void mostrarMenuClientes() {
		p("------------");
		p("Prestamo Libros");
		p("------------");
		p("");
		p("1. Listado de clientes");
		p("...");
		p("2. Indica que cliente quieres ver. (Por Id)");
		p("...");
		p("3. Añadir cliente.");
		p("...");
		p("4. Modificar clientes.");
		p("...");
		p("5. Eliminar clientes.");
		p("...");
		p("9. volver");
		p("...");
		p("0. Salir");
		p("...");
		p("Elige una opción");
		opcionMenuClientes(opcionCliente);
	}
	private static void mostrarMenu() {
		p("------------");
		p("Prestamo Libros");
		p("------------");
		p("");
		p("1. Libros");
		p("...");
		p("2. Clientes");
		p("...");
		p("3. Mostrar libros alquilados");
		p("...");
		p("4. Alquilar libro");
		p("...");
		p("5. Devolver libro");
		p("...");
		p("0. Salir");
		p("...");
		p("Elige una opción");
		
		opcionMenu(opcion);
		
	}
	@SuppressWarnings("static-access")
	private static void opcionMenu(int opcion) {
		System.out.println();
		do {
			opcion = lt.leerInt(opcion);
			salir = true;
		switch(opcion) {
		case 1: 
			mostrarMenuLibros();
			volver();
			break;
		case 2:
			mostrarMenuClientes();
			volver();
			break;
		case 3:
			mostrarAlquilados();
			volver();
			break;
		case 4:
			alquilarLibro();
			volver();
			break;
		case 5:
			devolverLibro();
			volver();
			break;
		case 0:
			p("Adios");
			break;
		default:
			salir = false;
			System.out.println("Eleccion no valida. \nVuelva a elegir una opcion");
			break;
		}
		}while (salir==false);
	}
	

	private static void opcionMenuClientes(int opcionCliente) {
		do {
			opcionCliente = lt.leerInt(opcionCliente);
			salir = true;
		switch(opcionCliente) {
		case 1: 
			
			listadoClientes();
			volverCliente();
			break;
		case 2:
			listadoClientesById();
			volverCliente();
			break;
		case 3:
			AddCliente();
			volverCliente();
			break;
		case 4:
			updateCliente();
			volverCliente();
			break;
		case 5:
			deleteCliente();
			volverCliente();
			break;
		case 9: mostrarMenu();
		break;
		case 0:
			p("Adios");
			break;
		default:
			salir = false;
			System.out.println("Eleccion no valida. \nVuelva a elegir una opcion");
			break;
		}
		}while (salir==false);
	}
	
	private static void opcionMenuLibros(int opcionLibro) {
		do {
			opcionLibro = lt.leerInt(opcionLibro);
			salir = true;
		switch(opcionLibro) {
		case 1: 
			
			listadoLibros();
			volverLibro();
			break;
		case 2:
			listadoLibrosById();
			volverLibro();
			break;
		case 3:
			AddLibro();
			volverLibro();
			break;
		case 4:
			updateLibro();
			volverLibro();
			break;
		case 5:
			deleteLibro();
			volverLibro();
			break;
		case 9: mostrarMenu();
		break;
		case 0:
			p("Adios");
			break;
		default:
			salir = false;
			System.out.println("Eleccion no valida. \nVuelva a elegir una opcion");
			break;
		}
		}while (salir==false);
	}
	private static void mostrarAlquilados() {
		mostrarCabeceraLibrosAlquilados();
		
		for(Libro libro: daoL.getAll()) {
			mostrarLibrosAlquilados(libro);
		}
	}
	private static void alquilarLibro() {
		listadoLibros();
		p("Indique el id" + "(" + daoC.getAll().size() + ")");
		id = lt.leerInt(id);
		long id2;
		for (Libro libro : daoL.getAll()) {
			if(libro.getId()==id && !alquilado) {
				id2= libro.getId();
				isbn=libro.getIsbn();
				titulo = libro.getTitulo();
				alquilado = true;
				autor = libro.getAutor();
				editorial = libro.getEditorial();
				daoL.update(new Libro(id2, isbn,  titulo, autor,
						editorial, alquilado));
			}
		}
		
		daoL.update(new Libro(id, isbn,  titulo, autor, editorial, alquilado));
	}
	private static void devolverLibro() {
		listadoLibros();
		p("Indique el id" + "(" + daoC.getAll().size() + ")");
		id = lt.leerInt(id);
		long id2;
		for (Libro libro : daoL.getAll()) {
			if(libro.getId()==id && alquilado) {
				id2= libro.getId();
				isbn=libro.getIsbn();
				titulo = libro.getTitulo();
				alquilado = false;
				autor = libro.getAutor();
				editorial = libro.getEditorial();
				daoL.update(new Libro(id2, isbn,  titulo, autor,
						editorial, alquilado));
			}
		}
		
		daoL.update(new Libro(id, isbn,  titulo, autor, editorial, alquilado));
	}
		
	private static void deleteCliente() {
		long id = 0;
		listadoClientes();
		p("");
		p("Introduzca el id del Cliente que desea eliminar");
		id = lt.leerLong(id);
		daoC.delete(id);
		
	}
	private static void updateCliente() {
		long id = 0;
		String dni = null;
		String nombre = null;
		String apellido = null;
		listadoClientes();
		p("");
		p("Introduzca el id del cliente que desea actualizar");
		id = lt.leerLong(id);
		p("Introduzca el dni del cliente que desea actualizar");
		dni = lt2.leerString(dni);
		p("Introduzca el nombre  del cliente que desea actualizar");
		nombre = lt2.leerString(nombre);
		p("Introduzca el apellido  del cliente que desea actualizar");
		apellido = lt2.leerString(apellido);
		
		daoC.update(new Cliente(id, dni,  nombre, apellido));
	}
	private static void AddCliente() {
		
		long id = 0;
		String dni = null;
		String nombre = null;
		String apellido = null;
		listadoClientes();
		p("Introduzca un id que no este en la lista");
		id = lt.leerLong(id);
		p("Introduzca el dni");
		dni = lt2.leerString(dni);
		p("Introduzca el nombre");
		nombre = lt2.leerString(nombre);
		p("Introduzca el apellido");
		apellido = lt2.leerString(apellido);
		daoC.insert(new Cliente(id, dni,  nombre, apellido));
		
	}
	private static void listadoClientesById() {
		p("Indique el id" + "(" + daoC.getAll().size() + ")");
		id = lt.leerInt(id);
		for (Cliente cliente : daoC.getAll()) {
			if(cliente.getId()==id) {
				mostrarCabeceraClientes();
				System.out.println(cliente.getId() + "\t" + cliente.getDni() +
						"\t"  + cliente.getNombre() + "\t" + cliente.getApellidos());
			}
		}
	}
	private static void listadoClientes() {
		
		
		mostrarCabeceraClientes();
		
		for(Cliente cliente: daoC.getAll()) {
			mostrarCliente(cliente);
		}
	}
	
	private static void mostrarCliente(Cliente cliente) {
		p(cliente.getId() + "\t" + cliente.getDni() + "\t" + cliente.getNombre() + "\t" + cliente.getApellidos());
	}
	private static void mostrarCabeceraClientes() {
		p("ID\tDNI\tNOMBRE\t\tApELLIDOS");
		
	}
	private static void deleteLibro() {
		long id = 0;
		listadoLibros();
		p("");
		p("Introduzca el id del Libro que desea eliminar");
		id = lt.leerLong(id);
		daoL.delete(id);
		
	}
	private static void updateLibro() {
		long id = 0;
			
		listadoLibros();
		p("Introduzca un id que desee actualizar");
		id = lt.leerLong(id);
		p("Introduzca el ISBN");
		isbn = lt2.leerString(isbn);
		p("Introduzca el titulo");
		titulo = lt2.leerString(titulo);
		p("Introduzca el autor");
		autor = lt2.leerString(autor);
		p("Introduzca la editorial");
		editorial = lt2.leerString(editorial);
		daoL.update(new Libro(id, isbn,  titulo, autor, editorial, alquilado));
		
	}
	private static void AddLibro() {
		 long id = 0;
		 alquilado = false;
		//No comprueba que el id exista
		//id = dao.getAll().size()+1;
		listadoLibros();
		p("Introduzca un id que no este en la lista");
		id = lt.leerLong(id);
		p("Introduzca el ISBN");
		isbn = lt2.leerString(isbn);
		p("Introduzca el titulo");
		titulo = lt2.leerString(titulo);
		p("Introduzca el autor");
		autor = lt2.leerString(autor);
		p("Introduzca la editorial");
		editorial = lt2.leerString(editorial);
		daoL.insert(new Libro(id, isbn,  titulo, autor, editorial, alquilado));
		
	}
	private static void listadoLibrosById() {
		p("Indique el id" + "(" + daoL.getAll().size() + ")");
		id = lt.leerInt(id);
		for (Libro libro : daoL.getAll()) {
			if(libro.getId()==id) {
				mostrarCabeceraClientes();
				System.out.println(libro.getId() + "\t" + libro.getIsbn() +
						"\t"  + libro.getTitulo() + "\t" + libro.getAutor() +
						"\t" + libro.getEditorial());
			}
		}
	}
	private static void listadoLibros() {
		
		mostrarCabeceraLibros();
		
		for(Libro libro: daoL.getAll()) {
			mostrarLibro(libro);
		}
	}
	private static void mostrarLibro(Libro libro) {
		p(libro.getId() + "\t" + libro.getIsbn() + "\t" + libro.getTitulo() + "\t" + libro.getAutor() + 
				"\t" + libro.getEditorial());
	}
	private static void mostrarLibrosAlquilados(Libro libro) {
		if (libro.isAlquilado()) {
		p(libro.getId() + "\t" + libro.getIsbn() + "\t" + libro.getTitulo() + "\t" + libro.getAutor() + 
				"\t" + "V");
		}else if(!libro.isAlquilado()) {
			p(libro.getId() + "\t" + libro.getIsbn() + "\t" + libro.getTitulo() + "\t" + libro.getAutor() + 
					"\t" + libro.getEditorial() +"\t" + "X");
		}
	}
	private static void mostrarCabeceraLibros() {
		p("ID\tISBN\tTITULO\t\tAUTOR\tEDITORIAL");
	}private static void mostrarCabeceraLibrosAlquilados() {
		p("ID\tISBN\tTITULO\t\tAUTOR\tEDITORIAL\tALQUILADO");
	}
	public static void volverCliente() {
		System.out.println("\nQuieres volver al menu? S/N");
		leerSN();
		if(caracter == 's' || caracter == 'S') {
			mostrarMenuClientes();
		}else if (caracter == 'n' || caracter == 'N'){
			System.out.println("Adios");
		}else {
			volverCliente();
		}
	}
	public static void volverLibro() {
		System.out.println("\nQuieres volver al menu? S/N");
		leerSN();
		if(caracter == 's' || caracter == 'S') {
			mostrarMenuLibros();
		}else if (caracter == 'n' || caracter == 'N'){
			System.out.println("Adios");
		}else {
			volverCliente();
		}
	}
	private static void volver() {
		
		System.out.println("\nQuieres volver al menu? S/N");
		leerSN();
		if(caracter == 's' || caracter == 'S') {
			mostrarMenu();
		}else if (caracter == 'n' || caracter == 'N'){
			System.out.println("Adios");
		}else {
			volver();
		}
	}
	
	public static void leerSN(){
		letter = lt2.leerChar(letter);
		caracter = letter.charAt(0);
	}


	private static void cargarLibros() {
		
		for(int i = 1; i <= 5; i++) {
			daoL.insert(new Libro(i, "isbn " + i, "titulo " + i, "autor " + i, "editorial " + i, false));
		}
	}
	private static void cargarClientes() {
		CrudAble<Cliente> dao = ClientesArrayDAO.getInstance();
		
		for(int i = 1; i <= 5; i++) {
			dao.insert(new Cliente(i, "dni " + i, "nombre " + i, "apellidos " + i));
		}
		
	}
	public static void p(String s) {
		System.out.println(s);
	}
	
}

