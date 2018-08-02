package com.ipartek.formacion.prestamolibros.presentacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.prestamolibros.accesodatos.ClienteArrayDAO;
import com.ipartek.formacion.prestamolibros.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeDao;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class PresentacionMain {

	private static final int LISTADO_LIBROS = 1;
	private static final int LISTADO_CLIENTES = 2;
	private static final int MOSTRAR_LIBRO = 3;
	private static final int MOSTRAR_CLIENTE = 4;
	private static final int MOSTRAR_LIBROS_DISPONIBLES = 5;
	private static final int MOSTRAR_LIBROS_PRESTADOS = 6;
	private static final int PEDIR_PRESTADO = 7;
	private static final int CLIENTE_TIENE_LIBRO = 8;
	private static final int INSERTAR_LIBRO = 9;
	private static final int INSERTAR_CLIENTE = 10;
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
		ClienteArrayDAO daoC = ClienteArrayDAO.getInstance();

		cargarLibros();

		int opcion = 0;

		Scanner teclado = new Scanner(System.in);

		do {
			/**
			 * se muestra el menu y se inicializa teclado para poder introducir el numero de
			 * la opción por consola
			 */
			mostrarMenu();

			try {
				try {
					opcion = teclado.nextInt();
				} catch (Exception e) {

					e.printStackTrace();
				}
			} catch (Exception e) {

				e.printStackTrace();
			}

			switch (opcion) {

			case LISTADO_LIBROS:

				listadoLibros();
				break;

			case LISTADO_CLIENTES:
				listadoCientes();
				break;

			case MOSTRAR_LIBRO:

				p("Insertar ID del libro");
				int idLibro = 0;
				try {
					idLibro = teclado.nextInt();
				} catch (Exception e) {

					e.printStackTrace();
				}
				Libro lib = dao.getById(idLibro);
				if (lib != null) {
					mostrarLibro(lib);
				}

				break;

			case MOSTRAR_CLIENTE:
				p("Insertar ID del Cliente");
				int idCliente = 0;
				try {
					idCliente = teclado.nextInt();
				} catch (Exception e) {

					e.printStackTrace();
				}
				Cliente client = daoC.getById(idCliente);
				if (client != null) {
					mostrarCliente(client);
				} else {
					p("No existe el Cliente");
				}
				break;

			case MOSTRAR_LIBROS_DISPONIBLES:

				mostrarLibrosDisponibles();
				break;

			case MOSTRAR_LIBROS_PRESTADOS:
				mostrarLibrosPrestados();
				break;
			case PEDIR_PRESTADO:
				p("Insertar ID del Cliente");
				int idClient = 0;
				try {
					idClient = teclado.nextInt();
				} catch (Exception e) {

					e.printStackTrace();
				}

				Cliente cliente = daoC.getById(idClient);
				if (cliente != null) {

					p("Insertar ID del Libro");
					int idLibr = 0;
					try {
						idLibr = teclado.nextInt();
					} catch (Exception e) {

						e.printStackTrace();

					}

					Libro libr = dao.getById(idLibr);
					if (libr != null) {

						cliente.getLibrosPrestados().add(libr);
						libr.setCliente(cliente);
						p("Has cogido prestado el libro: ");
						mostrarLibro(libr);

					}
				} else {
					p("No existes como Cliente, no puedes pedir libro");
				}

				break;

			case CLIENTE_TIENE_LIBRO:

				// mostrar todos los clientes que tengan un libro prestado

				clienteConLibro();// TODO implementar
				break;

			case INSERTAR_LIBRO:

				p("Escribir ID del libro para insertar un nuevo libro");
				long id = 0;
				try {
					id = teclado.nextLong();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (dao.getById(id) == null) {// si el id no existe, el video no existe podemos seguir
					p("Escribir isbn del libro para insertar un nuevo libro");
					String cod = null;
					try {
						cod = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					} // introduce el codigo
					p("Escribir título del libro para insertar un nuevo libro");
					String tit = null;
					try {
						tit = teclado.next();
					} catch (Exception e) {
						
						e.printStackTrace();

					} // introduce el titulo
					p("Escribir autor del libro para insertar un nuevo libro");
					String autor = null;
					try {
						autor = teclado.next();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					p("Escribir editorial del libro para insertar un nuevo libro");
					String ed = null;
					try {
						ed = teclado.next();
					} catch (Exception e) {
						
						e.printStackTrace();
					}

					Libro libroNuevo = new Libro(id, cod, tit, autor, ed, null);
					Boolean correcto = dao.insert(libroNuevo);
					if (correcto) {
						p(" Libro insertado correctamente: ");
						mostrarLibro(libroNuevo);
					} else {
						p("No se ha insertado el libro: ");
					}

				} else {
					p("El id introducido ya existe");
				}

				break;

			case INSERTAR_CLIENTE:
				p("Escribir ID del cliente para insertar un nuevo cliente");
				long idC = 0;
				try {
					idC = teclado.nextLong();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (daoC.getById(idC) == null) {// si el id no existe, el video no existe podemos seguir
					p("Escribir dni del libro para insertar un nuevo cliente");
					String dni = null;
					try {
						dni = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					} // introduce el codigo
					p("Escribir nombre del libro para insertar un nuevo cliente");
					String nomb = null;
					try {
						nomb = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();

					} // introduce el titulo
					p("Escribir apellidos del libro para insertar un nuevo cliente");
					String apellidos = null;
					try {
						apellidos = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}

					Cliente clienteNuevo = new Cliente(idC, dni, nomb, apellidos, null);
					Boolean correcto = daoC.insert(clienteNuevo);
					if (correcto) {
						p(" Cliente insertado correctamente: ");
						mostrarCliente(clienteNuevo);
					} else {
						p("No se ha insertado el cliente: ");
					}

				} else {
					p("El id introducido ya existe");
				}

				break;

			case ACTUALIZAR_LIBRO:
				p("Intruduzca el Id del libro a actualizar");
				long idUpdate = 0;
				try {
					idUpdate = teclado.nextLong();
				} catch (Exception e) {

					e.printStackTrace();
				}
				if (dao.getById(idUpdate) != null) {
					p("Escribir el nuevo isbn ");
					String cod = null;
					try {
						cod = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}
					p("Escribir el nuevo título");
					String tit = null;
					try {
						tit = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}
					p("Escribir el nuevo autor");
					String autor = null;
					try {
						autor = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}
					p("Escribir la nuevo editorial");
					String ed = null;
					try {
						ed = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}

					Libro lbM = new Libro(idUpdate, cod, tit, autor, ed, null);
					boolean correcto = dao.update(lbM);

					if (correcto) {
						p("El libro se ha actualizado correctamente: ");
						mostrarLibro(lbM);
					}

				} else {
					p("El id no existe, por lo tanto no puede actualizarse ");
				}
				break;

			case ACTUALIZAR_CLIENTE:
				p("Intruduzca el Id del libro a actualizar");
				long idUpdateC = 0;
				try {
					idUpdateC = teclado.nextLong();
				} catch (Exception e) {

					e.printStackTrace();
				}
				if (dao.getById(idUpdateC) != null) {
					p("Escribir el nuevo dni ");
					String dniC = null;
					try {
						dniC = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}
					p("Escribir el nuevo nombre");
					String nombre = null;
					try {
						nombre = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}
					p("Escribir los nuevos apellidos");
					String ap = null;
					try {
						ap = teclado.next();
					} catch (Exception e) {

						e.printStackTrace();
					}

					Cliente cl = new Cliente(idUpdateC, dniC, nombre, ap, null);
					boolean correcto = daoC.update(cl);

					if (correcto) {
						p("El libro se ha actualizado correctamente: ");
						mostrarCliente(cl);
					}

				} else {
					p("El id no existe, por lo tanto no puede actualizarse ");
				}
				break;

			case ELIMINAR_LIBRO:
				p("Intruduzca el Id del libro a eliminar");
				long idDelete = 0;
				try {
					idDelete = teclado.nextLong();
				} catch (Exception e) {

					e.printStackTrace();
				}
				if (dao.getById(idDelete) != null) {
					dao.delete(idDelete);

					p("Libro eliminado correctamente");

				} else {
					p("El Id del libro no existe. No puede eliminarse un libro inexistente");
				}
				break;

			case ELIMINAR_CLIENTE:
				p("Intruduzca el Id del libro a eliminar");
				long idDeleteC = 0;
				try {
					idDeleteC = teclado.nextLong();
				} catch (Exception e) {

					e.printStackTrace();
				}
				if (dao.getById(idDeleteC) != null) {
					dao.delete(idDeleteC);

					p("Cliente eliminado correctamente");

				} else {
					p("El Id del cliente no existe. No puede eliminarse un cliente inexistente");
				}
				break;

			case SALIR:
				p("Bye byeee");
				break;

			}

			/**
			 * switch
			 */

		} while (opcion != SALIR);

	}

	private static void clienteConLibro() {

		ClienteArrayDAO cl = ClienteArrayDAO.getInstance();
		
		List<Cliente> clArray = new  ArrayList<Cliente>();
		
		
		for(Cliente cli: clArray ) {
			
			if(cli.getLibrosPrestados()==null) 
				mostrarCliente(cli);

			}
			
			
		}

	

	/**
	 * muetra libros prestados y quien los tiene
	 */
	private static void mostrarLibrosPrestados() {
		LibroArrayDAO daolp = LibroArrayDAO.getInstance();
		List<Libro> lbp = daolp.getAll();
		for (Libro librs : lbp) {
			if (librs.getCliente() != null) {
				mostrarLibro(librs);
				p(librs.getCliente().getNombre());

			}
		}

	}

	/**
	 * muestra libros disponibles
	 */
	private static void mostrarLibrosDisponibles() {
		LibroArrayDAO daold = LibroArrayDAO.getInstance();
		List<Libro> lbd = daold.getAll();
		for (Libro librs : lbd) {
			if (librs.getCliente() == null) {
				mostrarLibro(librs);
			}
		}

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
		p("7. Clientes que tienen un libro prestado");
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
	 * 
	 * @param video
	 */
	private static void mostrarLibro(Libro libro) {
		p(libro.getId() + "\t" + libro.getIsbn() + "\t" + libro.getTitulo() + "\t" + libro.getAutor() + "\t"
				+ libro.getEditorial() + "\t" + (libro.getCliente() != null));

	}

	/**
	 * muestra un cliente
	 * 
	 * @param cliente
	 */
	private static void mostrarCliente(Cliente cliente) {
		// TODO implementar mostrar cliente
		// long id, String dni, String nombre, String apellidos, List<Libro>
		// librosPrestados

		System.out.println(cliente.getId() + "\t" + cliente.getDni() + "\t" + cliente.getNombre() + "\t" +
				cliente.getApellidos() + "\t" + cliente.getLibrosPrestados() + "\t");

	}

	/**
	 * muestra un listado de libros.
	 */
	private static void listadoLibros() {
		LibroArrayDAO dao = LibroArrayDAO.getInstance();

		// recorre el array de libros y los muestra
		for (Libro libro : dao.getAll()) {
			mostrarLibro(libro);
		}
	}

	/**
	 * listado de clientes
	 */

	private static void listadoCientes() {
		ClienteArrayDAO dao = ClienteArrayDAO.getInstance();

		// recorre el array de clientes y los muestra
		for (Cliente cliente : dao.getAll()) {
			mostrarCliente(cliente);
		}
		if (dao.getAll().size() == 0) {
			System.out.println("No existen clientes");
		}

	}

	/**
	 * carga libros
	 */
	private static void cargarLibros() {
		//Se define el dao de libro
		LibroArrayDAO dao = LibroArrayDAO.getInstance();
		//Definimos el array con el que vamos atrabjar, puede ser un array o un objeto 
		List<Libro> libros = new ArrayList<>();
try {
	//Esto se encarga de abrir el fichero (si no existe lo crea)
	FileInputStream fis = new FileInputStream("c:\\trabajo\\libros.txt");
	//mientras haya archivo por leer
	while(fis.available()>0) {
		//creamos el inputStream para leer el objeto
		ObjectInputStream inputStream = new ObjectInputStream(fis);
		//Leemos el objeto y hacemos el casting , puede ser un array o un objeto , lo que queramos .
		libros=(List<Libro>) inputStream.readObject();
	}
} catch (FileNotFoundException e) {
	e.printStackTrace();
}   
 catch (IOException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
//Ahora lo que queremos es poder trabajar con los libros que hemos cargado para eso, recorremos el array y por cada libro que haya lo insertamos en el dao
for(Libro lib : libros) {
	dao.insert(lib);
}


//si al coger los libros del fichero el tamaño de la lista de libros es igual a 0 es decir que no hay libros metemos los libros por defecto
if(libros.size()==0) {
	dao.insert(new Libro(1, "123", "HTML", "Pepito", "everest", null));
	dao.insert(new Libro(2, "1234", "JAVA", "Pepita", "debolsillo", null));
	dao.insert(new Libro(3, "1235", "SQL", "Pepi", "guay", null));
}
	

	}
	
	private static void guardarLibros() {
		//Creamos el dao para poder acceder a la lista de libros
		LibroArrayDAO dao = LibroArrayDAO.getInstance();
		//Recuperamos la lista de libros 
		List<Libro> libros = dao.getAll();
		
		try {
			//Creamos un fileOutput y le pasamos como parametro el fcihero en el que lo vamos a guardar
			FileOutputStream outputStream = new FileOutputStream("c:\\trabajo\\libros.txt");
			//Creamos un objectoOutput y le pasamos como parametro fielOutput
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			//Guardamos el objeto , o un array o lo que queramos
			objectOutputStream.writeObject(libros);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
