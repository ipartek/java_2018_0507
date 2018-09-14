package com.ipartek.formacion.uf2216.presentacionconsola;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RevistaMain {

	
	private static final int SALIR = 0;
	private static final int LISTADO = 1;
	private static final int BUSCAR_ID = 2;
	private static final int ADD_REVISTA = 3;
	private static final int DELETE_REVISTA = 4;
	private static final int GUARDAR_REVISTA = 5;
//	private static final int BUSCAR_FICHERO = 6;
	
	
	private static CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		cargarRevistas();
		int opcion;
		
		do {
			mostrarMenu();
			opcion = Utils.leerInt();
			
			procesarOpcion(opcion);
		}while(opcion != SALIR);
	}
	
//	private static void buscarFichero() {
//		
//		searchFile(new File("ficheros"), "tesoro");
//
//	}
	
	
//	private static boolean searchFile(File f, String palabra) {
//
//		boolean resul = false;
//		if (f.isDirectory()) {
//			for (File fichero : f.listFiles()) {
//				searchFile(fichero, palabra);
//			}
//		}else {
//			try {
//				FileReader fr = new FileReader(f);
//				BufferedReader bf = new BufferedReader(fr);
//				String linea;
//				while ((linea = bf.readLine()) != null) {
//					System.out.println(linea);
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//		return resul;
//		
//	}
	
//	private static void crearFichero() {
//		File f = new File("Ficheros\\revista.txt");
//		System.out.println("path:" + f.getAbsolutePath());
//
//		if (f.exists()) {
//			System.out.println("Existe el fichero");
//
//			String revis = "";
//
//			try {
//				FileWriter fw = new FileWriter(f);
//				PrintWriter pw = new PrintWriter(fw);
//
//				try {
//					pw.println(revis);
//
//				} finally {
//					pw.close();
//					fw.close();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} else {
//			try {
//				f.createNewFile();
//				System.out.println("Creamos el fichero");
//			} catch (IOException e) {
//				System.out.println("Error al crear fichero");
//				e.printStackTrace();
//			}
//		}
//
//	}
//	
	
	private static void procesarOpcion(int opcion) {
		switch(opcion) {
		case  LISTADO :
			listadoRevistas();
			break;
		case  BUSCAR_ID :
			buscarPorId();
			break;
		case ADD_REVISTA :
			addRevista();
			break;
		case DELETE_REVISTA:
			deleteRevista();
			break;
//		case GUARDAR_REVISTA:
//			crearFichero();
//			break;
		case SALIR:
			salir();
			break;
		default:
			noDisponible();
		}
	}
	
	
	private static void deleteRevista() {
		p("Dime el ID de la Revista");
		long id = Utils.leerLong();
		
		if(dao.delete(id)) {
			p("Revista borrada correctamente de la lista");
		}else {
			p("Ha surgido un error y no se ha podido borrar el video");
		}
	}
	
	
	private static void addRevista() {
		Revista revista = crearRevistaConDatosDeConsola();
		
		if(dao.insert(revista)) {
			p("La revista se añadio correctamente");
		}else {
			p("Ha surgido un error y no se ha podido añadir la revista");
		}			
	}
	
	public static Revista crearRevistaConDatosDeConsola() {
		p("Titulo:");
		long id = Utils.leerLong();
		p("ISBN:");
		String isbn = Utils.leerLinea();
		p("Numero de Paginas:");
		int numPaginas = Utils.leerInt();
		p("Formato:");
//		boolean formato = Utils.leerLinea();
		Revista revista = new Revista(id, isbn, isbn, numPaginas);
	
		
		return revista;
	}
	
	private static void buscarPorId() {
		p("Dime el ID de la revista que deseas buscar:");
		long isbn =Utils.leerLong();
		
		Revista revista = dao.getById(isbn);
		
		mostrarCabecera();
		mostrarRevista(revista);
	}
	
	private static void salir() {
		p("Gracias por su visita");
	}
	
	private static void noDisponible() {
		p("Esa función no existe");		
	}
	
	private static void mostrarMenu() {
		p("---------------");
		p("Aplicacion de Revistas");
		p("");
		p("1. Listado de Revistas");
		p("2. Buscar revista por id");
		p("3. Añadir revista");
		p("4. Eliminar video");
		p("5. Guardar revistas");
		p("5. Salir de la aplicacion");
		p("");
		p("");
		p("Elige una opcion");
	}
	
	private static void listadoRevistas() {
		mostrarCabecera();
		
		for(Revista revista : dao.getAll()) {
			mostrarRevista(revista);
		}
	}
	
	private static void mostrarCabecera() {
		p("Titulo\tISBN\tNumerodePaginas\tFORMATO");
	}
	
	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" +  revista.getTitulo() + "\t" + revista.getNumPaginas());
	}
	
	private static void cargarRevistas() throws Exception {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
		
		for(int i = 1; i<= 5; i++) {
			dao.insert(new Revista(i, "titulo" +i , "isbn" + i, i));
		}
	}

	
	public static void p(String s) {
		System.out.println(s);
	}
	
	
	
	
	
}
