package com.ipartek.formacion.uf2216;

<<<<<<< HEAD
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RevistasMain {
	private static final int SALIR = 0;
	private static final int LISTADO = 1;
	private static final int BUSCAR_ID = 2;
	private static final int ADD_REVISTA = 3;
	private static final int UPDATE_REVISTA = 4;
	private static final int DELETE_REVISTA = 5;
	private static final int CREAR_FICHERO = 6;

	private static CrudAble<Revistas> dao = RevistasArrayDAO.getInstance();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		cargarRevistas();
		int opt_menu;
		do {

			menuPrincipal();
			opt_menu = sc.nextInt();
			procesarOpcion(opt_menu);

		} while (opt_menu != SALIR);
		sc.close();

	}

	private static void procesarOpcion(int opcion) throws IOException {
		switch (opcion) {
		case LISTADO:
			listadoRevistas();
			break;
		case BUSCAR_ID:
			buscarPorId();
			break;
		case ADD_REVISTA:
			addRevista();
			break;
		case UPDATE_REVISTA:
			updateRevista();
			break;
		case DELETE_REVISTA:
			deleteRevista();
			break;
		case CREAR_FICHERO:
			crearFichero();
			break;
		case SALIR:
			salir();
			break;
		default:
			optNoCorrecta();
		}
	}

	private static void deleteRevista() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Identificación de revista");
		long id = sc.nextLong();

		if (dao.delete(id)) {
			System.out.println("Revista eliminada correctamente");
		} else {
			System.out.println("No se ha podido borrar la revista");
		}
		sc.close();
	}

	private static void updateRevista() {
		Revistas revista = creacionRevistaConsola();

		if (dao.update(revista)) {
			System.out.println("La revista se ha modificado correctamente");
		} else {
			System.out.println("No se ha podido modificar la revista");
		}
	}

	private static void addRevista() {
		Revistas revista = creacionRevistaConsola();

		if (dao.insert(revista)) {
			System.out.println("Revista añadida correctamente");
		} else {
			System.out.println("No se ha podido añadir la revista");
		}
	}

	private static Revistas creacionRevistaConsola() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el ID:");
		long id = sc.nextLong();
		System.out.println("Introduce el título:");
		String titulo = sc.next();
		System.out.println("Introduce el ISBN:");
		String ISBN = sc.next();
		System.out.println("Introduce el número de páginas:");
		int num_paginas = sc.nextInt();

		sc.nextLine();

		Revistas nuevaRevista = new Revistas(id, titulo, ISBN, num_paginas, true);
		sc.close();
		return nuevaRevista;

	}

	private static void buscarPorId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la identificación (ID) de la revista:");
		long id = sc.nextLong();
		Revistas revista = dao.getById(id);

		mostrarTitulo();
		mostrarRevistas(revista);
		sc.close();
	}

	private static void salir() {
		System.out.println("Muchas gracias, el programa ha finalizado.");
	}

	private static void menuPrincipal() {
		System.out.println("");
		System.out.println("JKiosk - Gestión de revistas");
		System.out.println("----------------------------");
		System.out.println("Por favor, selecciona una opción para continuar:");
		System.out.println("1. Lista de revistas disponibles");
		System.out.println("2. Buscar revista por identificación (ID)");
		System.out.println("3. Añadir revista");
		System.out.println("4. Modificar revista existente");
		System.out.println("5. Eliminar revista");
		System.out.println("6. Guardar ruta en fichero");
		System.out.println("-----------------------------");
		System.out.println("0. Salir");
		System.out.println("");
	}

	private static void listadoRevistas() {
		mostrarTitulo();

		for (Revistas revista : dao.getAll()) {
			mostrarRevistas(revista);
		}
	}

	private static void mostrarTitulo() {
		System.out.println("ID\tTITULO\tISBN\tNUM_PAGS\tFORMATO");
	}

	private static void mostrarRevistas(Revistas revistas) {
		System.out.println(revistas.getId() + "\t" + revistas.getTitulo() + "\t" + revistas.getISBN() + "\t"
				+ revistas.getNumPaginas() + "\t" + revistas.getFormato());
	}

	private static void cargarRevistas() {
		CrudAble<Revistas> dao = RevistasArrayDAO.getInstance();

		for (int i = 1; i <= 8; i++) {
			dao.insert(new Revistas(i, "Título" + i, "ISBN" + i, (i + 100), false));

		}

	}

	public static void crearFichero() throws IOException {
		BufferedWriter bw = null;
		List<Revistas> registros = dao.getAll();
		try {
			// String mycontent = "Contenido de demostrasión";
			File archivotxt = new File("C:\\revistas\\jkiosk_contenido.txt");

			/*
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 */
			if (!archivotxt.exists()) {
				archivotxt.createNewFile();
			}

			FileWriter fw = new FileWriter(archivotxt);
			bw = new BufferedWriter(fw);
			bw.write("El objeto que contiene las revistas se encuentra en " + dao.toString());
			System.out.println("El archivo se ha guardado de manera satisfactoria. :-)");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}

	}

	private static void optNoCorrecta() {
		System.out.println("Esa función no existe");
	}

=======

import java.io.FileWriter;
import java.io.PrintWriter;

public class RevistasMain {

	private static final int LISTADO = 1;
	private static final int MOSTRAR_REVISTA = 2;
	private static final int ADD_REVISTA = 3;
	private static final int GUARDAR_FICHERO = 4;
	private static final int SALIR = 0;
	
	private static CrudAble<Revista> dao = RevistaArrayDao.getInstance();
	
	public static void main(String[] args) {
		cargarRevistas();
		
		int opcion;
		
		do {
			mostrarMenu();
			opcion = Utils.leerInt();
			procesarOpcion(opcion);
			
		}while (opcion != SALIR);
	}
	
	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case LISTADO:
			listadoRevistas();
			break;
		case MOSTRAR_REVISTA:
			buscarPorId();
			break;
		case ADD_REVISTA:
			insertarRevista();
			break;
		case GUARDAR_FICHERO:
			guardarEnFichero();
			break;
		case SALIR:
			salir();
			break;
		default:
			noDisponible();
			break;
		}
	}
	

	//MENU del programa
	private static void mostrarMenu() {
		p("------------");
		p("Revistas");
		p("------------");
		p("");
		p("1. Listado de revistas");
		p("2. Buscar revista por ID");
		p("3. Añadir revista");
		p("4. Guardar en fichero");
		p("");
		p("0. Salir");
		p("Elige una opcion: ");
	}
	
	// CARGAR REVISTAS: metodo para cargar todas las revistas (inicialmente 6)
	private static void cargarRevistas() {
		CrudAble<Revista> dao = RevistaArrayDao.getInstance();
		
		for (int i = 1; i <= 6; i++) {
			try { 					 //id, titulo, isbn, numPag, formato
				dao.insert(new Revista(i, "titulo" + i,"1234567890", i, true));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	// LISTADO: listar todas las revistas
	private static void listadoRevistas() {
		mostrarCabecera();
		
		for (Revista revista: dao.getAll()) {
			mostrarRevista(revista);
		}
	}
	
	// MOSTRAR REVISTA
	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + revista.getIsbn() + "\t" +  revista.getTitulo() + 
				"\t" + revista.getNumPag() + "\t" + revista.isFormato());
	}
	
	//MOSTRAR REVISTA por ID
	private static void buscarPorId() {
		p("Dime el ID de la revista");		
		long id = Utils.leerLong();		
		
		Revista revista = dao.getById(id);	
		
		mostrarCabecera();	
		mostrarRevista(revista);
	}
	
	
	// AÑADIR REVISTA Insertar una revista 
	private static void insertarRevista() {
		
		//llamo a la funcion ¬ que contiene los datos introducidos por teclado
		Revista revista = crearRevistaConDatosDeConsola();
		
		boolean resultadoOperacion = dao.insert(revista);
		
		if (resultadoOperacion) {
			p("Revista insertada correctamente");
		}else {
			p("ERROR al insertar la revista");
		}
	}
	
	// Datos introducidos por consola
	private static Revista crearRevistaConDatosDeConsola() {
		p("ID: ");
		long id = Utils.leerLong();
		p("ISBN: ");
		String isbn = Utils.leerLinea();
		p("Titulo: ");
		String titulo = Utils.leerLinea();
		p("Numero de paginas: ");
		int numPag = Utils.leerInt();
		p("Formato (digital o papel): ");
		String formato = Utils.leerLinea();

		boolean formatoFinal = tipoFormato(formato);
		
		Revista revista = new Revista();
		try {
			revista = new Revista(id, titulo, isbn, numPag, formatoFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return revista;
	}
	
	// Si el formato introducido es true -> papel, si es false -> digital
	private static boolean tipoFormato(String formato) {
		boolean res = false;
		if (formato.trim().equalsIgnoreCase("papel")){
			res = true;
		}else if (formato.trim().equalsIgnoreCase("digital")) {
			res = false;
		}
		return res;
	}
	
	//GUARDAR EN FICHERO el listado de revistas
	private static void guardarEnFichero(){
	
		FileWriter fichero = null;
        PrintWriter pw = null;
        
        try {
            fichero = new FileWriter("C://pruebaFichero//revistas.txt");
            pw = new PrintWriter(fichero);
         
            for (Revista revista: dao.getAll()) {
            	pw.println(revista.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
   
           if (null != fichero) 
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	            		
	}

	private static void mostrarCabecera() {
		p("ID\tISBN\tTITULO\tPAGINAS\tFORMATO");
	}
	
	private static void noDisponible() {
		p("Esa funcion no existe.");
	}

	private static void salir() {
		p("Has salido del programa.");
	}	
	
	private static void p (String s) {
		System.out.println(s);
	}
	
	
>>>>>>> branch 'cristina' of https://github.com/ipartek/java_2018_0507
}
