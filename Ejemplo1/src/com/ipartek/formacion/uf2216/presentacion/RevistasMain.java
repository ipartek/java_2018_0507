package com.ipartek.formacion.uf2216.presentacion;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.uf2216.accesodatos.CrudAble;
import com.ipartek.formacion.uf2216.accesodatos.RevistasArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;

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
	public static char caracter;
	public static String letter;
	static Scanner  sc = new Scanner(System.in);
	static Scanner  sc2 = new Scanner(System.in);
	static LeerTeclado lt = new LeerTeclado(sc);
	static LeerTeclado lt2 = new LeerTeclado(sc2);
	
	public static void main(String[] args) throws IOException {
		grabarCabeceraEnFichera();//Creo la cabecera en el fichero y me cargo los datos anteriores
		cargarRevistas();//TODO Crear una lista de revistas
		mostrarMenu();

	}

	private static void cargarRevistas() throws IOException {
		for(int i = 1; i <= 5; i++) {
			dao.insert(new Revista(i, "titulo" + i, "012345678" + i, i+200, false));
			escribirEnFichero(i, "titulo" + i, "\t" + "012345678" + i, i+200, "papel");
			dao.insert(new Revista(i+5, "titulo" + (i+5), "987654321" + (i+5), i+300, true));
			escribirEnFichero(i+5, "titulo" + (i+5), "\t" + "987654321" + (i+5), i+300, "Digital");
		}
		
	}

	private static void mostrarMenu() throws IOException {
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

	@SuppressWarnings("static-access")
	private static void opcionMenu(int opcionMenu2) throws IOException {
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
			añadirRevistas();
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

	@SuppressWarnings("static-access")
	private static void añadirRevistas() throws IOException {
		long id = 0;
		String format = "";
		listarRevistas();
		p("Introduzca un id que no este en la lista");
		id = lt.leerLong(id);
		p("Introduzca el ISBN");
		comprobarIsbn();
		p("Introduzca el titulo");
		comprobarTitulo();
		p("Introduzca el número de paginas");
		comprobarPaginas();
		p("Introduzca el formato. (Digital o papel");
		format = lt2.leerString(format.toLowerCase());
		p(format);
		formato(format);
		guardar(format);
		
	}
	public static void guardar(String format) throws IOException {
		p("¿Quiere guardar el archivo?");
		p(id + " " + titulo + " " + isbn + " " + numPaginas + " " + format);
		p("S/N");
		leerSN();
		if(caracter == 's' || caracter == 'S') {
			dao.insert(new Revista(id, titulo,  isbn, numPaginas, formato));
			escribirEnFichero(id, titulo,  isbn, numPaginas, format);
			p("Revista añadida exitosamente");
		}else if (caracter == 'n' || caracter == 'N'){
			System.out.println("Adios");
		}else {
			p("Caracter incorrecto introducido.");
		}
	}
	public static void comprobarTitulo() {
		boolean repetir = true;
		do {
			titulo= lt2.leerString(titulo);
			System.out.println(titulo.length());
			if (titulo.length() < 3) {
				p("El titulo debe tener más de 3 caracteres."
						+ "\nVuelva a intentarlo");
			}else if (titulo.length()>=150){
				p("El titulo debe tener menos de 150 caracteres."
						+ "\nVuelva a intentarlo");
			}else {
				repetir=false;
			}
		}while(repetir);
	}
	public static void comprobarIsbn() {
		boolean repetir = true;
		
		do {
			isbn = lt2.leerString(isbn);
			if (isbn.length()==10) {
				
				repetir=false;
			}else {
				p("El valor introducido no contiene 10 caracteres."
						+ "\nVuelva a intentarlo");
			}
		}while(repetir);
	}
	@SuppressWarnings("static-access")
	public static void comprobarPaginas() {
		boolean repetir = true;
		do {
			numPaginas = lt2.leerLong(numPaginas);
			if (numPaginas>0) {
				
				repetir=false;
			}else {
				p("El libro debe tener más de una pagina."
						+ "\nVuelva a intentarlo");
			}
		}while(repetir);
	}

	public static void formato(String format) throws IOException {
		RevistasMain rm = new RevistasMain();
		if (format.toLowerCase().equals("digital")) {
			formato = true;
		}else if(format.toLowerCase().equals("papel")){
			formato = false;
		}else {
			p("Operacion cancelada, formato incorrecto."
					+ " \nELija papel o digital");
			volver();
		}
	}
	public static void escribirEnFichero(long id, String titulo, String isbn,
			long numero, String formato) throws IOException {
		FileWriter fw = new FileWriter("src\\\\com\\\\ipartek\\\\formacion\\\\uf2216\\\\Revistas.txt", true);
		PrintWriter pw = new PrintWriter(fw,true);

		pw.println(id + "\t" + titulo + "\t" + isbn + "\t" + numero + "\t" +  "\t" + formato);
		fw.close();
		pw.close();
	}
	
	private static void grabarCabeceraEnFichera() throws IOException {
		FileWriter fw = new FileWriter("src\\\\com\\\\ipartek\\\\formacion\\\\uf2216\\\\Revistas.txt", false);
		PrintWriter pw = new PrintWriter(fw,true);
		pw.println("ID\tTITULO\t\tISBN\tNº PAGINAS\tFORMATO");
		fw.close();
		pw.close();
		
	}

	private static void listarRevistas() {
		mostrarCabeceraRevistas();
		
		for(Revista revista: dao.getAll()) {
			mostrarRevista(revista);
		}
		
	}
	private static void mostrarCabeceraRevistas() {
		p("ID\tTITULO\t\tISBN\tNº PAGINAS\tFORMATO");
		
	}

	private static void mostrarRevista(Revista revista) {
		boolean format = revista.isFormato();
		String digiOFisi;
		if (format) {
			digiOFisi = "Digital";
		}else {
			digiOFisi = "Papel";
		}
		p(revista.getId() + "\t" + revista.getTitulo()
		+ "\t\t" + revista.getIsbn()
		+ "\t" + revista.getNumPaginas()  
		+ "\t\t" + digiOFisi);
		
	}
	static void volver() throws IOException {
		System.out.println("\nQuieres volver al menu? S/N");
		leerSN();
		if(caracter == 's' || caracter == 'S') {
			mostrarMenu();
		}else if (caracter == 'n' || caracter == 'N'){
			System.out.println("Adios");
		}else {
			p("Caracter incorrecto introducido.");
			volver();
		}
	}
	
	public static void leerSN(){
		letter = lt2.leerChar(letter);
		caracter = letter.charAt(0);
	}
	
	public static void p(String s) {
		System.out.println(s);
	}
}
