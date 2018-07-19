package com.ipartek.formacion.presentacionConsola;

import com.ipartek.formacion.accesoDatos.ClienteDAO;
import com.ipartek.formacion.accesoDatos.CrudAbleCliente;
import com.ipartek.formacion.accesoDatos.CrudAbleLibro;
import com.ipartek.formacion.accesoDatos.LibroDAO;
import com.ipartek.formacion.prestamoLibrosPojo.Cliente;
import com.ipartek.formacion.prestamoLibrosPojo.Libro;

public class LibroClienteMain {

	public enum OpcionesMenuPrincipal{
		CLIENTES(1),
		LIBROS(2);
		
		private int numeroOpcion;
		private OpcionesMenuPrincipal(int numeroOpcion) {
			this.numeroOpcion = numeroOpcion;
		}
		public int getNumeroOpcion() {
			return this.numeroOpcion;
		}
	}
	
	public enum OpcionesMenuCliente{
		LISTADO(1),
		CARGAR_CLIENTE_POR_ID(2),
		CARGAR_CLIENTE_POR_DNI(3),
		INSERTAR_CLIENTE(4),
		MODIFICAR_CLIENTE(5),
		BORRAR_CLIENTE(6);
		
		private int numeroOpcionCliente;
		private static int menuClienteMaxOpciones = OpcionesMenuCliente.values().length;
		
		private OpcionesMenuCliente(int numeroOpcionCliente) {
			this.numeroOpcionCliente = numeroOpcionCliente;
		}
		
		public int getNumeroOpcionesCliente() {
			return this.numeroOpcionCliente;
		}
		
		public static int getMaxOpcionesCliente() {
			return menuClienteMaxOpciones;
		}
	}
	
	public enum OpcionesMenuLibro{
		LISTADO(1),
		CARGAR_CLIENTE_POR_ID(2),
		CARGAR_CLIENTE_POR_DNI(3),
		INSERTAR_CLIENTE(4),
		MODIFICAR_CLIENTE(5),
		BORRAR_CLIENTE(6);
		
		private int numeroOpcionLibro;
		private static int menuLibroMaxOpciones = OpcionesMenuLibro.values().length;
		
		private OpcionesMenuLibro(int numeroOpcionLibro) {
			this.numeroOpcionLibro = numeroOpcionLibro;
		}
		
		public int getNumeroOpcionesLibro() {
			return this.numeroOpcionLibro;
		}
		
		public static int getMaxOpcionesLibro() {
			return menuLibroMaxOpciones;
		}
	}
	
	
	public static void main(String[] args) {
		
		cargarClientes();
		cargarLibros();
		

	}
	
	private static void cargarClientes() {
		CrudAbleCliente<Cliente> dao = ClienteDAO.getInstance();
		
		/*for (int i = 1; i <= 10; i++) {
			dao.insert(new VideoYoutube(i, "codigo" + i, "Titulo" + i));
		}*/
		
	}
	private static void cargarLibros() {
		CrudAbleLibro<Libro> dao = LibroDAO.getInstance();
		
	}

}
