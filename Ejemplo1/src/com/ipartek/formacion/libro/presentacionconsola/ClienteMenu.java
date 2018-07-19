package com.ipartek.formacion.libro.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.libro.accesodatos.ClienteArrayDAO;
import com.ipartek.formacion.libro.accesodatos.CrudAble;
import com.ipartek.formacion.libro.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.libro.pojo.Cliente;
import com.ipartek.formacion.libro.pojo.Libro;

public class ClienteMenu {

	private static final String SALIR = "0";
	private static final String ACTUALIZAR = "5";
	private static final String BORRAR = "4";
	private static final String NUEVO = "3";
	private static final String ARTICULO = "2";
	private static final String LISTADO = "1";

	public static void clienteMenu() throws InstantiationException, IllegalAccessException{

		mostrarMenuCliente();

		// TODO: Hacer el menú que se repita cada vez e implementar la lectura de
		// teclado
		Scanner sc = new Scanner(System.in);
		String opcion =  sc.next();

		switch (opcion) {
		case LISTADO:
			listadoClientes();
			break;
		case ARTICULO:
			clientesArticulo();
			break;
		case NUEVO:
			clientesNuevo();
			break;
		case BORRAR:
			clientesBorrar();
			break;
		case ACTUALIZAR:
			clientesActualizar();
			break;
		case SALIR:
			MainMenu.main(null);
			break;
		default: System.out.println(">>Opción no válida: ");
			clienteMenu();
		}
		sc.close();
	}

	private static void mostrarMenuCliente() {
		p("------------");
		p("Clientes");
		p("------------");
		p("1. Listado de clientes");
		p("2. Buscar un cliente");
		p("3. Añadir un nuevo cliente");
		p("4. Borrar un cliente");
		p("5. Actualizar un cliente");
		p("");
		p("0. Volver");
		p("");
		p(">>Elige una opción: ");
	}
	
	public static void listadoClientes() {
		CrudAble<Cliente> dao = ClienteArrayDAO.getInstance();
		mostrarCabeceraCliente();
		for (Cliente cliente : dao.getAll()) {
			mostrarCliente(cliente);
		}
	}

	
	private static void clientesArticulo() {
		CrudAble<Cliente> dao = ClienteArrayDAO.getInstance();

		Scanner sc = new Scanner(System.in);
		p("Introduce el ID del cliente: ");
		long identificador = sc.nextLong();

		Cliente cliente = dao.getById(identificador);
		mostrarCabeceraCliente();
		mostrarCliente(cliente);
		sc.close();
	}


	private static void clientesNuevo() throws InstantiationException, IllegalAccessException {
		CrudAble<Cliente> dao = ClienteArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID del cliente: ");
		long id = sc1.nextLong();

		Scanner sc2 = new Scanner(System.in);
		p("Introduce el dni del cliente: ");
		String dni = sc2.next();

		Scanner sc3 = new Scanner(System.in);
		p("Introduce el nombre del cliente: ");
		String nombre = sc3.next();

		Scanner sc4 = new Scanner(System.in);
		p("Introduce los apellidos del cliente: ");
		String apellidos = sc4.next();

		Cliente cliente = Cliente.class.newInstance();
		cliente.setId(id);
		cliente.setDni(dni);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setLibrosPrestados(null);

		dao.insert(cliente);

		p("El cliente se ha creado");
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
	}
	
	private static void clientesBorrar() {
		CrudAble<Cliente> dao = ClienteArrayDAO.getInstance();

		Scanner sc = new Scanner(System.in);
		p("Introduce el ID del cliente a borrar: ");
		long id = sc.nextLong();
		dao.delete(id);
		sc.close();

		p("Cliente borrado");
	}

	
	private static void clientesActualizar() throws InstantiationException, IllegalAccessException {
		CrudAble<Cliente> dao = ClienteArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID del cliente a actualizar: ");
		long id = sc1.nextLong();

		Cliente cliente = dao.getById(id);

		Scanner sc2 = new Scanner(System.in);
		p("Introduce el nuevo dni del cliente: ");
		String dni = sc2.next();

		Scanner sc3 = new Scanner(System.in);
		p("Introduce el nuevo nombre del cliente: ");
		String nombre = sc3.next();

		Scanner sc4 = new Scanner(System.in);
		p("Introduce los nuevos apellidos del cliente: ");
		String apellidos = sc4.next();

//		Scanner sc5 = new Scanner(System.in);
//		p("Introduce el nuevo Cliente del libro: ");
//		String libro = sc5.next();

		Cliente cliente2 = Cliente.class.newInstance();
		cliente.setDni(dni);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
//		cliente.setLibrosPrestados(librosPrestados);
		
		dao.insert(cliente2);

		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
//		sc5.close();

		p("cliente actualizado");
	}

	private static void clientesSalir() {
		p("Gracias por utilizar esta aplicación. Adiós");

	}

	
	private static void mostrarCabeceraCliente() {
		p("ID\tDNI\tNOMBRE\tAPELLIDOS\tLIBROS");
	}

	
	private static void mostrarCliente(Cliente cliente) {
		p(cliente.getId() + "\t" + cliente.getDni() + "\t" + cliente.getNombre() + cliente.getApellidos()
				+ cliente.getLibrosPrestados());
	}


	public static void p(String s) {
		System.out.println(s);
	}

}
