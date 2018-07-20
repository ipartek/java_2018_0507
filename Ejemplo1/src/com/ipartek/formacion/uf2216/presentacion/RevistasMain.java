package com.ipartek.formacion.uf2216.presentacion;

import java.util.Scanner;

import com.ipartek.formacion.uf2216.accesodatos.CrudAble;
import com.ipartek.formacion.uf2216.accesodatos.RevistasArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;
import com.ipartek.prestamolibros.Libro;





public class RevistasMain {
	
	static CrudAble<Revista> dao = 
			RevistasArrayDAO.getInstance();
	public static long id;
	public static String titulo;
	public static String isbn;
	public static long numPaginas;
	public static boolean formato;
	public static int opcionMenu;
	public static boolean salir = true;
	static Scanner  sc = new Scanner(System.in);
	static Scanner  sc2 = new Scanner(System.in);
	static LeerTeclado lt = new LeerTeclado(sc);
	static LeerTeclado lt2 = new LeerTeclado(sc2);
	
	public static void main(String[] args) {
		cargarRevistas();//TODO Crear una lista de revistas
		mostrarMenu();

	}

	private static void cargarRevistas() {
		//cargar una lista
		
	}

	private static void mostrarMenu() {
		//Mostrar el menu
		p("------------");
		p("--Revistas--");
		p("------------");
		p("");
		p("1. Listado de revistas");
		p("...");
		p("2. Añadir Revista");
		p("...");
		p("0. Salir");
		p("...");
		p("Elige una opción");
		opcionMenu(opcionMenu);
		
	}

	private static void opcionMenu(int opcionMenu2) {
		// Elegir que opcion del menu desea
		System.out.println();
		do {
			opcionMenu = lt.leerInt(opcionMenu);
			salir = true;
		switch(opcionMenu) {
		case 1: 
			listarRevistas();
			volver();
			break;
		case 2:
			AñadirRevistas();
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

	private static void AñadirRevistas() {
		long id = 0;
		String format = null;
		listarRevistas();
		p("Introduzca un id que no este en la lista");
		id = lt.leerLong(id);
		p("Introduzca el ISBN");
		isbn = lt2.leerString(isbn);
		p("Introduzca el titulo");
		titulo = lt2.leerString(titulo);
		p("Introduzca el número de paginas");
		numPaginas = lt2.leerLong(numPaginas);
		p("Introduzca el formato");
		format = lt2.leerString(format);
	
		dao.insert(new Revista(id, titulo,  isbn, numPaginas, formato));
		
	}

	private static void listarRevistas() {
		mostrarCabeceraRevistas();
		
		for(Revista revista: dao.getAll()) {
			mostrarRevista(revista);
		}
		
	}
	private static void mostrarCabeceraRevistas() {
		p("ID\tTITULO\tISBN\t\tNº PAGINAS\tFORMATO");
		
	}

	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + revista.getIsbn() + "\t" + revista.getTitulo() + "\t" + libro.getAutor() + 
				"\t" + revista.getEditorial());
		
	}

	private static void volver() {
		// TODO Auto-generated method stub
		
	}

	public static void p(String s) {
		System.out.println(s);
	}
}
