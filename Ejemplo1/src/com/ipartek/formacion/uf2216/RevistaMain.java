package com.ipartek.formacion.uf2216;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class RevistaMain {

	private static final int DIGITOS_NECESARIOS = 10;
	private static final int MAXIMO_CARACTER = 150;
	private static final int MINIMO_CARACTER = 3;
	private static final int SALIR = 0;
	private static final int GUARDAR_EN_FICHERO = 3;
	private static final int LISTAR_REVISTAS = 2;
	private static final int INSERTAR_REVISTA = 1;


	public static void main(String[] args) {
		mostrarMenu();

	}

	private static void mostrarMenu() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		int numero = 0;
		do {
			p("---------");
			p("Revistas");
			p("------------");
			p("");
			p("1. Insertar revista");
			p("2. Listado de revistas");
			p("3. Guardar las revistas en un fichero");
			p("0. Salir");
			p("Elige una opción");
		
		try {
			String num=sc.nextLine();
			numero = Integer.parseInt(num);
			if(numero<0 && numero>5) {
				Integer.parseInt("correcto");
			}
		}catch(Exception e) {
			System.out.println("Opción incorrecta");
			mostrarMenu();
		}
		switch(numero) {
		case INSERTAR_REVISTA:
			System.out.println("Introduce la id de la revista");
			String idrevista=sc.nextLine();
			int idr = Integer.parseInt(idrevista);
			
			System.out.println("¡Correcto! Introduce el titulo de la revista");
			String titulor = sc.nextLine();
			if (titulor != null) {
				if (titulor.length()<MINIMO_CARACTER) {
					System.out.println("Tienes que poner un minimo de 3 caracteres.");
					break;
				}else if(titulor.length() > MAXIMO_CARACTER) {
					System.out.println("El titulo no puede contener mas de 150 caracteres");
					break;
				}	
			}else {
				System.out.println("No puedes dejar en blanco el campo Titulo.");
				break;
			}
			
			
			System.out.println("¡Correcto! Introduce el isbn de la revista");
			String isbnr = sc.nextLine();
			if (isbnr != null) {
				if (isbnr.length() != DIGITOS_NECESARIOS) {
					System.out.println("El isbn tiene que tener 10 digitos");
					break;
				}
			}else {
				System.out.println("No puedes dejar en blanco el campo ISBN");
			}
			
			
			System.out.println("¡Correcto! Introduce el numero de paginas de la revista");
			String nPaginas= sc.nextLine();
			int nPag = Integer.parseInt(nPaginas);
			if (nPag < 1) {
				System.out.println("La revista tiene que tener 1 pagina como minimo");
				break;
			}
			
			System.out.println("¡Correcto! Introduce el formato de la revista. true=digital , false=papel");
			String format = sc.nextLine();
			boolean formato = Boolean.parseBoolean(format);
			
			Revista revista = new Revista();
			revista.setId(idr);
			revista.setTitulo(titulor);
			revista.setIsbn(isbnr);
			revista.setnPaginas(nPag);
			revista.setFormato(formato);
			RevistaDao.getInstance().insert(revista);
			break;
			
		case LISTAR_REVISTAS:
			listadoRevistas();
			break;
		case GUARDAR_EN_FICHERO:
			FileWriter fichero = null;
			PrintWriter pw = null;
			try {
				fichero = new FileWriter("C:\\Users\\curso\\git\\java_2018_0507\\Ejemplo1\\src\\com\\ipartek\\formacion\\uf2216\\prueba.txt");
				pw = new PrintWriter(fichero);
				CrudAble<Revista> dao = RevistaDao.getInstance();
				
				for (Revista r : dao.getAll()) {
					pw.println(r);
				}
				p("¡Guardado!");
			break;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (null != fichero) {
						fichero.close();
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
			
		case SALIR:
			System.out.println("Adios!");
		}
		}while(numero!=0);
		
	}

	private static void listadoRevistas() {
		CrudAble<Revista> dao = RevistaDao.getInstance();
		
		mostrarCabecera();
		for (Revista revista : dao.getAll()) {
			mostrarRevista(revista);
		}
	}

	private static void mostrarRevista(Revista revista) {
		p(revista.getId() + "\t" + revista.getTitulo() + "\t\t" + revista.getIsbn()
		 + " \t\t" + revista.getnPaginas() + "\t\t" + revista.isFormato());
	}

	private static void mostrarCabecera() {
		p("ID\tTITULO\t" + "\t" + "ISBN\t " + "\t" + "NUMERO PAGINAS\t" + "\t" + "FORMATO");
		
	}

	
	public static void p(String s) {
		System.out.println(s);
	}

}
