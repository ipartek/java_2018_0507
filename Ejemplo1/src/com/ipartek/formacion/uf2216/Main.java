package com.ipartek.formacion.uf2216;

import java.util.Scanner;
import com.ipartek.formacion.uf2216.accesodatos.CrudAble;
import com.ipartek.formacion.uf2216.accesodatos.RevistaArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		cargarRevistas();
		mostrarMenu();

		Scanner sc = new Scanner(System.in);
		String opcion =  sc.next();

		switch (opcion) {
		case "1":
			listadoRevistas();
			break;
		case "2":
			revistasNuevo();
			break;
		case "3":
			guardarFichero();
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
		p("1. Listado de revistas");
		p("2. Introducir revista");
		p("3. Generar fichero de revistas");
		p("");
		p("0. Salir");
		p("");
		p(">>Elige una opción: ");
	}

	
	
	
	
	private static void guardarFichero() {
		p("------------");
	}
	

	private static void revistasNuevo() throws InstantiationException, IllegalAccessException {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID de la revista: ");
		long id = sc1.nextLong();

		Scanner sc2 = new Scanner(System.in);
		p("Introduce el isbn de la revista: ");
		Integer isbn = Integer.parseInt(sc2.next().trim());

		Scanner sc3 = new Scanner(System.in);
		p("Introduce el titulo de la revista: ");
		String titulo = sc3.next().trim();

		Scanner sc4 = new Scanner(System.in);
		p("Introduce el número de páginas de la revista: ");
		Integer paginas = Integer.parseInt(sc4.next().trim());

		Scanner sc5 = new Scanner(System.in);
		p("Introduce el formato del libro: ");
		Boolean formato = sc5.nextBoolean();

		Revista revista = Revista.class.newInstance();
		revista.setId(id);
		revista.setIsbn(isbn);
		revista.setTitulo(titulo);
		revista.setPaginas(paginas);
		revista.setFormato(formato);

		dao.insert(revista);

		p("La revista se ha insertado");
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		sc5.close();
	}
	
	
	
	public static void listadoRevistas() {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
		mostrarCabecera();
		for (Revista revista : dao.getAll()) {
			mostrarRevista(revista);
		}
	}
	
	
	private static void mostrarCabecera() {
		p("ID\tISBM\tTITULO\tPAGS\tFORMATO");
	}
	
	
	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + revista.getIsbn() + "\t" + revista.getTitulo() + "\t" + revista.getPaginas() + "\t" +revista.getFormato());
	}
	
	
	private static void menuSalir() {
		p("Gracias por utilizar esta aplicación. Adiós");
	}
	

	private static void cargarRevistas() throws InstantiationException, IllegalAccessException {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();

		for (int i = 1; i <= 5; i++) {
			dao.insert(new Revista(i, i, "titulo"+i, 0, true));
		}
	}
	
	
public static void p(String s) {
	System.out.println(s);

	}

}
