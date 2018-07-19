package com.ipartek.formacion.presentacionConsola;

import com.ipartek.formacion.accesoDatos.ClienteDAO;
import com.ipartek.formacion.accesoDatos.CrudAbleCliente;
import com.ipartek.formacion.accesoDatos.CrudAbleLibro;
import com.ipartek.formacion.accesoDatos.LibroDAO;
import com.ipartek.formacion.prestamoLibrosPojo.Cliente;
import com.ipartek.formacion.prestamoLibrosPojo.Libro;

public class LibroClienteMain {

	private static CrudAbleCliente<Cliente> daoCliente = ClienteDAO.getInstance();
	private static CrudAbleLibro<Libro> daoLibro = LibroDAO.getInstance();
	
	private static final int SALIR = 0;
	private static final int IR_A_CLIENTES = 1;
	private static final int IR_A_LIBROS = 2;
	private static final int LISTAR_PRESTADOS_Y_A_QUIEN = 3;
	
	private static final int LISTADO_CLIENTE = 1;
	private static final int CARGAR_CLIENTE_POR_ID = 2;
	private static final int CARGAR_CLIENTE_POR_DNI = 3;
	private static final int INSERTAR_CLIENTE = 4;
	private static final int MODIFICAR_CLIENTE = 5;
	private static final int BORRAR_CLIENTE = 6;
	
	private static final int LISTADO_LIBROS = 1;
	private static final int VER_LIBRO_POR_ID = 1;
	private static final int VER_LIBRO_POR_ISBN = 1;
	private static final int INSERTAR_LIBRO = 1;
	private static final int MODIFICAR_LIBRO = 1;
	private static final int BORRAR_LIBRO = 1;
	private static final int PRESTAR_LIBRO = 1;

	
	public static void main(String[] args) {
		
		cargarClientes();
		cargarLibros();
		
		int opcion;
		
		do {
			//mostrarMenu();
			
			opcion = Utils.leerInt();
			
			//procesarOpcion(opcion);
			
		} while (opcion != SALIR);

	}
	
	private static void cargarClientes() {
			
			//dao.insert(new Cliente(id, nombre, apellido, lista_libros));
		/*for (int i = 1; i <= 10; i++) {
			dao.insert(new VideoYoutube(i, "codigo" + i, "Titulo" + i));
		}*/
		
	}
	private static void cargarLibros() {
		
	}
	
	private static void procesarOpcion(int opcionesMenu) {
		switch (opcionesMenu) {
			case IR_A_CLIENTES: 
				//irAMenuClientes();
				break;
			case IR_A_LIBROS:
				//irAMenuLibros();
				break;
			case LISTAR_PRESTADOS_Y_A_QUIEN:
				//verLibrosPrestados();
				break;
			case SALIR:
				//salir();
				break;
			default:
				//noDisponible();
				break;
		}
	}

}
