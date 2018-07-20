package com.ipartek.formacion.prestamolibros.presentacionConsola;

import java.util.List;

import com.ipartek.formacion.prestamolibros.accesoDatos.ClienteDAO;
import com.ipartek.formacion.prestamolibros.accesoDatos.CrudAbleCliente;
import com.ipartek.formacion.prestamolibros.accesoDatos.CrudAbleLibro;
import com.ipartek.formacion.prestamolibros.accesoDatos.LibroDAO;
import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.uf2216.presentacionconsola.Utils;

public class LibroClienteMain {

	private static CrudAbleCliente<Cliente> daoCliente = ClienteDAO.getInstance();
	private static CrudAbleLibro<Libro> daoLibro = LibroDAO.getInstance();
	
//	private static final int SALIR = 0;
//	private static final int IR_A_CLIENTES = 1;
//	private static final int IR_A_LIBROS = 2;
//	private static final int LISTAR_PRESTADOS_Y_A_QUIEN = 3;
//	
//	private static final int LISTADO_CLIENTE = 1;
//	private static final int CARGAR_CLIENTE_POR_ID = 2;
//	private static final int CARGAR_CLIENTE_POR_DNI = 3;
//	private static final int INSERTAR_CLIENTE = 4;
//	private static final int MODIFICAR_CLIENTE = 5;
//	private static final int BORRAR_CLIENTE = 6;
//	
//	private static final int LISTADO_LIBROS = 1;
//	private static final int VER_LIBRO_POR_ID = 1;
//	private static final int VER_LIBRO_POR_ISBN = 1;
//	private static final int INSERTAR_LIBRO = 1;
//	private static final int MODIFICAR_LIBRO = 1;
//	private static final int BORRAR_LIBRO = 1;
//	private static final int PRESTAR_LIBRO = 1;
	
	private static final int OPCION_SALIR = 0;
	private static final int OPCION_LISTAPRESTADOS = 1;
	private static final int OPCION_LISTANOPRESTADOS = 2;
	private static final int OPCION_BUSCAR = 3;

	
	public static void main(String[] args) {
		
		try {
			cargarLibros();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cargarClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int opcion;
		
		do {
			mostrarMenu();
			
			opcion = Utils.leerInt();
			
			procesarOpcion(opcion);
			
		} while (opcion != OPCION_SALIR);

	}
	
	/**
	 * Carga manual de clientes de prueba
	 * 
	 */
	private static void cargarClientes() {
		Cliente cliente;
		
		cliente = new Cliente(123, "123456789A", "Antxon", "Urrutia", null);
		daoCliente.insert(cliente);
		
		cliente = new Cliente(456, "123456789B", "Antxon2", "Urrutia", null);
		daoCliente.insert(cliente);
		
		cliente = new Cliente(789, "123456789C", "Antxon3", "Urrutia", null);
		daoCliente.insert(cliente);
		
		cliente = new Cliente(012, "123456789D", "Antxon4", "Urrutia", null);
		daoCliente.insert(cliente);
		
		cliente = new Cliente(345, "123456789E", "Antxon5", "Urrutia", null);
		daoCliente.insert(cliente);
	}
	
	/**
	 * Carga manual de libros de prueba
	 * 
	 */
	private static void cargarLibros() {
		Libro libro;
		libro = new Libro(123, "9788416001460", "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "autor1",
				"LIBROS DEL K.O", true, null);
		daoLibro.insert(libro);
	
		libro = new Libro(345, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015", "autor2", 
				"EDICIONES SM",	false, null);
		daoLibro.insert(libro);
	
		libro = new Libro(345, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "autor3", "EDICIONES SM", false, null);
		daoLibro.insert(libro);
	
		libro = new Libro(678, "9788461716098", "LA VOZ DE TU ALMA", "autor4", "AUTOR-EDITOR", true, null);
		daoLibro.insert(libro);
	
		libro = new Libro(901, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "autor5", "EDICIONES SM", false, null);
		daoLibro.insert(libro);
	
		libro = new Libro(234, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "autor6","MACMILLAN CHILDRENS BOOKS", false, null);
		daoLibro.insert(libro);
	
		libro = new Libro(567, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", "autor7","MACMILLAN CHILDRENS BOOKS", false, null);
		daoLibro.insert(libro);
	}
	
	
	private static void mostrarMenu() {
		
		p("------------------------------------");
		p("--        Casa del Libro          --");
		p("------------------------------------");
		p("-    1. Listar prestados           -");
		p("-    2. Libros no prestados			");
		p("-    3. Buscar        	           -");
		p("-                                  -");
		p("-    0 - Salir                     -");
		p("------------------------------------");
		p("");
		p("Dime una opcion por favor");
	}
	
	private static void procesarOpcion(int opcionesMenu) {
		switch (opcionesMenu) {
			case OPCION_LISTAPRESTADOS: 
				listarPrestados();
				break;
			case OPCION_LISTANOPRESTADOS:
				listarNoPrestados();
				break;
			case OPCION_BUSCAR:
				buscar();
				break;
			case OPCION_SALIR:
				salir();
				break;
			default:
				noDisponible();
				break;
		}
	}
	
	/**
	 * Muestra la lista de libros prestados
	 */
	private static void listarPrestados() {

		List<Libro> listaLibros = daoLibro.getAllPrestados(true);

		p("		Libros Prestados		");
		p("------------------------------------------------");

		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		p("");
		p("");
		p("");
	}
	
	/**
	 * Muestra la lista de libros no prestados
	 */
	private static void listarNoPrestados() {
		List<Libro> listaLibros = daoLibro.getAllPrestados(false);

		p("		Libros no Prestados		");
		p("------------------------------------------------");

		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		p("");
		p("");
		p("");
	}
	
	/**
	 * Busca en la lista de libros por su titulo
	 */
	private static void buscar() {

		System.out.println("Introduce el titulo del libro a buscar: ");
		String titulo = Utils.leerLinea();

		List<Libro> listaLibros = daoLibro.getByTitulo(titulo);

		p("Resultados de la busqueda de: " + titulo);
		p("------------------------------------------------------");

		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		p("");
		p("");
		p("");

		if (listaLibros.size() == 0)
			p("No se encuentran libros con ese titulo.");

	}
	
	public static void p(String s) {
		System.out.println(s);
	}
	
	private static void salir() {
		p("ADIOS!!!");
	}
	
	private static void noDisponible() {
		p("Esa funcion no existe");
	}

}
