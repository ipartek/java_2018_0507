package com.ipartek.formacion.uf2216;

import java.util.Scanner;

public class RevistaMain {

	public static void main(String[] args) {
		cargarRevistas();
		mostrarMenu();

	}

	private static void mostrarMenu() {
		Scanner sc = new Scanner (System.in);
		int numero = 0;
		do {
			p("---------");
			p("Revistas");
			p("------------");
			p("");
			p("1. Listado de videos");
			p("2. insertar video");
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
		case 1:
			listadoRevistas();
			break;
		case 2:
			System.out.println("Introduce la id de la revista");
			String idrevista=sc.nextLine();
			int idr = Integer.parseInt(idrevista);
			
			System.out.println("Introduce el titulo de la revista");
			String titulor = sc.nextLine();
			
			System.out.println("Introduce el isbn de la revista");
			String isbnr = sc.nextLine();
			
			System.out.println("Introduce el numero de paginas de la revista");
			String nPaginas= sc.nextLine();
			int nPag = Integer.parseInt(nPaginas);
			
			System.out.println("Introduce el formato de la revista-> true=digital , false=papel");
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
		case 0:
			
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
		p(revista.getId() + "\t" + revista.getTitulo() + "\t" + revista.getIsbn()
		 + " \t" + revista.getnPaginas() + "\t" + revista.isFormato());
	}

	private static void mostrarCabecera() {
		p("ID\tTITULO\tISBN\tNUMERO PAGINAS\tFORMATO");
		
	}

	private static void cargarRevistas() {
		CrudAble<Revista> dao = RevistaDao.getInstance();
		
		
	}
	
	public static void p(String s) {
		System.out.println(s);
	}

}
