package com.ipartek.formacion.libro.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.libro.accesodatos.ClienteArrayDAO;
import com.ipartek.formacion.libro.accesodatos.CrudAble;
import com.ipartek.formacion.libro.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.libro.pojo.Cliente;
import com.ipartek.formacion.libro.pojo.Libro;

public class MainMenu {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		cargarClientes();
		cargarLibros();
		
		mostrarMenu();

		// TODO: Hacer el menú que se repita cada vez e implementar la lectura de
		// teclado
		Scanner sc = new Scanner(System.in);
		String opcion =  sc.next();

		switch (opcion) {
		case "1":
			LibroMenu.libroMenu();;
			break;
		case "2":
			ClienteMenu.clienteMenu();
			break;
		case "3":
			Reserva.reserva();
			break;
		case "0":
			menuSalir();
			break;
			default: System.out.println(">>Opción no válida");
			main(args);
		}
		sc.close();
	}

	private static void mostrarMenu() {
		p("------------");
		p("SISTEMA DE BIBLIOTECA");
		p("------------");
		p("1. Gestionar libros");
		p("2. Gestionar clientes");
		p("3. Gestionar reservas");
		p("");
		p("0. Salir");
		p("");
		p(">>Elige una opción: ");
	}

	private static void menuSalir() {
		p("Gracias por utilizar esta aplicación. Adiós");

	}
	
	private static void cargarLibros() throws InstantiationException, IllegalAccessException {
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();

		for (int i = 1; i <= 5; i++) {
			dao.insert(
					new Libro(i, "isbn" + i, "titulo" + i, "autor" + i, "editorial" + i, -1));
		}
	}
	
	private static void cargarClientes() throws InstantiationException, IllegalAccessException {
		CrudAble<Cliente> dao = ClienteArrayDAO.getInstance();
		for (int i = 1; i <= 5; i++) {
			dao.insert(
					new Cliente(i, "dni" + i, "nombre" + i, "apellidos" + i, null));
		}
	}
	
	
	
public static void p(String s) {
	System.out.println(s);
}
}
