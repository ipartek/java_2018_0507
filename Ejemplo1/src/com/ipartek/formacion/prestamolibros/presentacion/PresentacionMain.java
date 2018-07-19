package com.ipartek.formacion.prestamolibros.presentacion;

import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.prestamolibros.accesodatos.ClienteArrayDAO;
import com.ipartek.formacion.prestamolibros.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class PresentacionMain {

	
	private static final int LISTADO_LIBROS = 1;
	private static final int LISTADO_CLIENTES = 2;
	private static final int MOSTRAR_LIBRO = 3;
	private static final int MOSTRAR_CLIENTE = 4;
	private static final int MOSTRAR_LIBROS_DISPONIBLES= 5;
	private static final int MOSTRAR_LIBROS_PRESTADOS=6;
	private static final int PEDIR_PRESTADO= 7;
	private static final int CLIENTE_TIENE_LIBRO= 8;
	private static final int INSERTAR_LIBRO =9;
	private static final int INSERTAR_CLIENTE =10 ;
	private static final int ACTUALIZAR_LIBRO = 11;
	private static final int ACTUALIZAR_CLIENTE = 12;
	private static final int ELIMINAR_LIBRO = 13;
	private static final int ELIMINAR_CLIENTE = 14;
	private static final int SALIR = 0;
	
	
	public static void main(String[] args) {
		

		/*
		 * pedir prestado devolver listado disponibles listado prestado y a quien
		 */
		LibroArrayDAO dao = LibroArrayDAO.getInstance();
		
		cargarLibros();

		
		int opcion = 0;

		
		Scanner teclado = new Scanner(System.in);
		
		do {
			/**
			 * se muestra el menu y se inicializa teclado para poder introducir el numero de
			 * la opción por consola
			 */
			mostrarMenu();
			
			opcion = teclado.nextInt();
			
			switch (opcion) {
			
			case LISTADO_LIBROS:
				listadoLibros();
				break;
				
			case LISTADO_CLIENTES:
				listadoCientes();
				break;
			
			case MOSTRAR_LIBRO:
				mostrarLibro(null);//TODO implementar
			break;
			
			case MOSTRAR_CLIENTE:
				mostrarCliente(null);//TODO implementar
			break;
			
			case MOSTRAR_LIBROS_DISPONIBLES:
				mostrarLibrosDisponibles();//TODO implementar
			break;
			
			case MOSTRAR_LIBROS_PRESTADOS:
				mostrarLibrosPrestados();//TODO implementar
			break;
			case PEDIR_PRESTADO:
				pedirPrestado();//TODO implementar
			break;
			
			case CLIENTE_TIENE_LIBRO:
				clienteConLibro();//TODO implementar
			break;
			
			case INSERTAR_LIBRO:
				insertarLibro();//TODO implementar
			break;
			
			case INSERTAR_CLIENTE:
				insertarCliente();//TODO implementar
			break;
			
			case ACTUALIZAR_LIBRO:
				actualizarLibro();//TODO implementar
			break;
			
			case ACTUALIZAR_CLIENTE:
				actualizarCliente();//TODO implementar
			break;
			
			case ELIMINAR_LIBRO:
				eliminarLibro();//TODO implementar
			break;
			
			case ELIMINAR_CLIENTE:
				eliminarCliente();//TODO implementar
			break;
			
			case SALIR:
				
			break;
			
			}
			
		/**
		 * switch
		 */
				
		} while (opcion != SALIR);

	}
		
		
		
	
	
	
	
	







	private static void eliminarCliente() {
		// TODO Auto-generated method stub
		
	}















	private static void eliminarLibro() {
		// TODO Auto-generated method stub
		
	}















	private static void actualizarCliente() {
		// TODO Auto-generated method stub
		
	}















	private static void actualizarLibro() {
		// TODO Auto-generated method stub
		
	}















	private static void insertarCliente() {
		// TODO Auto-generated method stub
		
	}















	private static void insertarLibro() {
		// TODO Auto-generated method stub
		
	}















	private static void clienteConLibro() {
		// TODO Auto-generated method stub
		
	}















	private static void pedirPrestado() {
		// TODO Auto-generated method stub
		
	}















	private static void mostrarLibrosPrestados() {
		// TODO Auto-generated method stub
		
	}















	private static void mostrarLibrosDisponibles() {
		// TODO Auto-generated method stub
		
	}















	/**
	 * muestra el menu
	 */
	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de libros");
		p("2. Listado de clientes");
		p("3. Mostrar libro");
		p("4. Mostrar cliente");
		p("5. Mostrar libros disponibles");
		p("6. Mostrar libros prestados");
		p("7. Que cliente tiene el libro");
		p("8. Mostrar libros prestados");
		p("9. Insertar libro");
		p("10. Insertar cliente");
		p("11. Actualizar libro");
		p("12. Actualizar cliente");
		p("13. Eliminar libro");
		p("14. Eliminar cliente");
		p("0. Salir");
		p("Elige una opción");
	}
	/**
	 * Para que al hacer un system.out.print ln solo tengas que poner una p
	 * 
	 * @param s
	 */
	public static void p(String s) {
		System.out.println(s);
	}

	/**
	 * muestra un video con su id codigo y titulo
	 * @param video
	 */
	private static void mostrarLibro(Libro libro) {
		p(libro.getId() + "\t" + libro.getIsbn() + "\t" + libro.getTitulo()+ "\t" + libro.getAutor()+ "\t" + libro.getEditorial()+ "\t" + libro.getCliente().toString());

	}	
		

	private static void mostrarCliente(Cliente cliente) {
		//TODO implementar mostrar cliente
		//long id, String dni, String nombre, String apellidos, List<Libro> librosPrestados
		
		System.out.printf(cliente.getId()+ "\t", cliente.getDni()+ "\t", cliente.getNombre()+ "\t", cliente.getApellidos()+ "\t",cliente.getLibrosPrestados()+ "\t");
		
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/**
	 * muestra un listado de libros.
	 */
	private static void listadoLibros() {
		LibroArrayDAO dao = LibroArrayDAO.getInstance();

		
		//recorre el array de libros y los muestra
		for (Libro libro : dao.getAll()) {
			mostrarLibro(libro);
			}
		}
	
		
	private static void listadoCientes() {
		ClienteArrayDAO dao = ClienteArrayDAO.getInstance();

		
		//recorre el array de libros y los muestra
		for (Cliente cliente : dao.getAll()) {
			mostrarCliente(cliente);
			}
		
	}
	

















	private static void cargarLibros() {
		LibroArrayDAO dao = LibroArrayDAO.getInstance();
		
		//Libro libro1 = new Libro(1,"123","HTML","Pepito","everest", new Cliente());
		//Libro libro2 = new Libro(1,"1234","JAVA","Pepita","debolsillo", new Cliente());
		//Libro libro3 = new Libro(1,"1235","SQL","Pepi","guay", new Cliente());

		dao.insert(new Libro(1,"123","HTML","Pepito","everest", new Cliente()));
		dao.insert(new Libro(1,"1234","JAVA","Pepita","debolsillo", new Cliente()));
		dao.insert(new Libro(1,"1235","SQL","Pepi","guay", new Cliente()));
		
	

}}
