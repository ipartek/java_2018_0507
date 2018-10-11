package com.ipartek.formacion.prestamolibros.consola;

import java.util.Scanner;

import com.ipartek.formacion.prestamolibros.accesodatos.CrudAble;
import com.ipartek.formacion.prestamolibros.accesodatos.LibroArrayDAO;
import com.ipartek.formacion.prestamolibros.pojo.Libro;


public class ConsolaBiblioteca {

	private static final int LISTADO = 1;
	private static final int SALIR = 0;
	private static boolean CONTINUAR=true;
	public static void main(String[] args) {
	String libroIDSeleccionado;
	int opcion = LISTADO;
		
		cargarLibros();
		
		mostrarMenu();
		
		//Leer de Teclado
		//
		
		Scanner sc = new Scanner(System.in);
		System.out.println("SC"+sc.nextLine());
		LibroArrayDAO vyad=LibroArrayDAO.getInstance();

		
		while(sc.nextLine()!="0") {
				
				switch(sc.nextLine()) {
					
					case "1":
						listadoLibros();
						mostrarMenu();
						break;
						
					case "2":
						//mostrarVideo con id
						System.out.println("Introduce ID Libro");
						Scanner sc1 = new Scanner(System.in);
						libroIDSeleccionado=sc1.nextLine();
						System.out.println("Libro seleccionado ID:"+libroIDSeleccionado);
						mostrarLibro(vyad.getById(Long.valueOf(libroIDSeleccionado)));
						break;

					case "3":
						//mostrarVideo con id
						System.out.println("Añadiendo libro");
						aniadirLibro();
						
					case "0":
						p("ADIOS");
						CONTINUAR=false;
						opcion=0;
						break;
			
					default:
						p("ADIOS");
						CONTINUAR=false;
						opcion=0;
						break;
				}
		}
		sc.close();
	}

	private static void mostrarLibro(Libro byId) {
		Libro l=new Libro(0, null, null, null, null);
		p(l.getId() + "\t" + l.getAutor() + "\t" + l.getTitulo()+ "\t" +l.getEditorial()+ "\t" +l.getIsbn());
		
	}

	private static void mostrarMenu() {
		p("------------");
		p("Biblioteca PepePepito");
		p("------------");
		p("");
		p("1. Listado de libros");
		p("2. Mostrar libro");
		p("3. Añadir libro");
		p("0. Salir");
		p("Elige una opción");
	}
	
	private static void listadoLibros() {
	
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(Libro libro: dao.getAll()) {
			mostrarLibro(libro);
		}
	}

	private static void mostrarCabecera() {
		p("ID\tCODIGO\tTITULO");
	}
	
	private static void aniadirLibro() {
		
		Libro libro = new Libro(33, "titut", "24", "ab", "cd");
		
		LibroArrayDAO lad=LibroArrayDAO.getInstance();
		//lad.insert(libro);
		lad.insert(libro);
		System.out.println("Libro con ID "+libro.getId()+" añadido");
	
		
		
		
		
	}
	
	private static void mostrarLibros(Libro libro) {
		p(libro.getId() + "\t" + libro.getAutor() + "\t" + libro.getTitulo());
	}

	private static void cargarLibros() {
		CrudAble<Libro> dao = LibroArrayDAO.getInstance();
		
		for(int i = 1; i <= 5; i++) {
			dao.insert(new Libro(i, "codigo" + i, "titulo" + i, "ff"+1, "dddd"+i));
		}
	}
	
	public static void p(String s) {
		System.out.println(s);
	}

}
