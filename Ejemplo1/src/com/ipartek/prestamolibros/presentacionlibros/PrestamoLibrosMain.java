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
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc3 = new Scanner(System.in);
	static LeerTeclado lt = new LeerTeclado(sc);
	static LeerTeclado lt2 = new LeerTeclado(sc2);
	static LeerTeclado lt3 = new LeerTeclado(sc3);
	 //Creando aqui el dao no requiero usarlo en cada metodo
	//static CrudAble<Cliente> daoC = ClientesArrayDAO.getInstance();
	static CrudAble<Libro> dao = LibrosArrayDAO.getInstance();
	
	
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
		p("3. Indica que libro quieres ver. (Por Id)");
		p("...");
		p("5. Añadir libro.");
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
		p("4. Indica que cliente quieres ver. (Por Id)");
		p("...");
		p("6. Añadir cliente.");
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
		p("4. Devolver libro");
		p("...");
		p("0. Salir");
		p("...");
		p("Elige una opción");
		
		opcionMenu(opcion);
		
	}
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
			volver();
			break;
		case 2:
			listadoClientesById();
			volver();
			break;
		case 3:
			AddCliente();
			volver();
			break;
		case 4:
			updateCliente();
			volver();
			break;
		case 5:
			deleteCliente();
			volver();
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
			volver();
			break;
		case 2:
			listadoLibrosById();
			volver();
			break;
		case 3:
			AddLibro();
			volver();
			break;
		case 4:
			updateLibro();
			volver();
			break;
		case 5:
			deleteLibro();
			volver();
			break;
		default:
			salir = false;
			System.out.println("Eleccion no valida. \nVuelva a elegir una opcion");
			break;
		}
		}while (salir==false);
	}
	private static void mostrarAlquilados() {
		// TODO Auto-generated method stub
		
	}
	private static void alquilarLibro() {
		// TODO Auto-generated method stub
		
	}
	private static void deleteCliente() {
		CrudAble<Cliente> dao = ClientesArrayDAO.getInstance();
		long id = 0;
		listadoClientes();
		p("");
		p("Introduzca el id del Cliente que desea eliminar");
		id = lt.leerLong(id);
		dao.delete(id);
		
	}
	private static void updateCliente() {
		CrudAble<Cliente> dao = ClientesArrayDAO.getInstance();
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
		nombre = lt3.leerString(nombre);
		p("Introduzca el apellido  del cliente que desea actualizar");
		apellido = lt.leerString(apellido);
		
		dao.update(new Cliente(id, dni,  nombre, apellido));
	}
	private static void AddCliente() {
		CrudAble<Cliente> dao = ClientesArrayDAO.getInstance();
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
		nombre = lt3.leerString(nombre);
		p("Introduzca el apellido");
		apellido = lt.leerString(apellido);
		dao.insert(new Cliente(id, dni,  nombre, apellido));
		
	}
	private static void listadoClientesById() {
		CrudAble<Cliente> dao = ClientesArrayDAO.getInstance();
		p("Indique el id" + "(" + dao.getAll().size() + ")");
		id = lt.leerInt(id);
		for (Cliente cliente : dao.getAll()) {
			if(cliente.getId()==id) {
				mostrarCabeceraClientes();
				System.out.println(cliente.getId() + "\t" + cliente.getDni() +
						"\t"  + cliente.getNombre() + "\t");
			}
		}
		
	}
	private static void listadoClientes() {
		CrudAble<Cliente> dao = ClientesArrayDAO.getInstance();
		
		mostrarCabeceraClientes();
		
		for(Cliente cliente: dao.getAll()) {
			mostrarCliente(cliente);
		}
	}
	
	private static void mostrarCliente(Cliente cliente) {
		p(cliente.getId() + "\t" + cliente.getDni() + "\t" + cliente.getNombre() + "\t" + cliente.getApellidos());
	}
	private static void mostrarCabeceraClientes() {
		p("ID\tDNI\tNOMBRE\tApELLIDOS");
		
	}
	private static void deleteLibro() {
		long id = 0;
		listadoLibros();
		p("");
		p("Introduzca el id del Libro que desea eliminar");
		id = lt.leerLong(id);
		dao.delete(id);
		
	}
	private static void updateLibro() {
		long id = 0;
		String isbn = null;
		String titulo = null;
		String autor = null;
		String editorial = null;	
		listadoLibros();
		p("Introduzca un id que desee actualizar");
		id = lt.leerLong(id);
		p("Introduzca el ISBN");
		isbn = lt2.leerString(isbn);
		p("Introduzca el nombre");
		titulo = lt3.leerString(titulo);
		p("Introduzca el apellido");
		autor = lt.leerString(autor);
		p("Introduzca la editorial");
		editorial = lt2.leerString(editorial);
		dao.update(new Libro(id, isbn,  titulo, autor, editorial));
		
	}
	private static void AddLibro() {
		 long id = 0;
		String isbn = null;
		String titulo = null;
		String autor = null;
		String editorial = null;

		//No comprueba que el id exista
		//id = dao.getAll().size()+1;
		listadoLibros();
		p("Introduzca un id que no este en la lista");
		id = lt.leerLong(id);
		p("Introduzca el ISBN");
		isbn = lt2.leerString(isbn);
		p("Introduzca el nombre");
		titulo = lt3.leerString(titulo);
		p("Introduzca el apellido");
		autor = lt.leerString(autor);
		p("Introduzca la editorial");
		editorial = lt2.leerString(editorial);
		dao.insert(new Libro(id, isbn,  titulo, autor, editorial));
		
	}
	private static void listadoLibrosById() {
		p("Indique el id" + "(" + dao.getAll().size() + ")");
		id = lt.leerInt(id);
		for (Libro libro : dao.getAll()) {
			if(libro.getId()==id) {
				mostrarCabeceraClientes();
				System.out.println(libro.getId() + "\t" + libro.getIsbn() +
						"\t"  + libro.getTitulo() + "\t" + libro.getAutor() +
						"\t" + libro.getEditorial());
			}
		}
	}
	private static void listadoLibros() {
		CrudAble<Libro> dao = LibrosArrayDAO.getInstance();
		
		mostrarCabeceraLibros();
		
		for(Libro libro: dao.getAll()) {
			mostrarLibro(libro);
		}
	}
	private static void mostrarLibro(Libro libro) {
		p(libro.getId() + "\t" + libro.getIsbn() + "\t" + libro.getTitulo() + "\t" + libro.getAutor() + 
				"\t" + libro.getEditorial());
	}
	private static void mostrarCabeceraLibros() {
		p("ID\tISBN\tTITULO\tAUTOR\tEDITORIAL");
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
		CrudAble<Libro> dao = LibrosArrayDAO.getInstance();
		
		for(int i = 1; i <= 5; i++) {
			dao.insert(new Libro(i, "isbn " + i, "titulo " + i, "autor " + i, "editorial " + i));
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

