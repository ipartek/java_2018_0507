package com.ipartek.formacion.uf2216;

import java.util.Scanner;

public class RevistaMain {

	public static void main(String[] args) {
		//cargarRevistas();
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
		case 1:
			System.out.println("Introduce la id de la revista");
			String idrevista=sc.nextLine();
			int idr = Integer.parseInt(idrevista);
			
			System.out.println("Introduce el titulo de la revista");
			String titulor = sc.nextLine();
			if (titulor != null) {
				if (titulor.length()<3) {
					System.out.println("Tienes que poner un minimo de 3 caracteres.");
					break;
				}else if(titulor.length() > 150) {
					System.out.println("El titulo no puede contener mas de 150 caracteres");
					break;
				}	
			}else {
				System.out.println("No puedes dejar en blanco el campo Titulo.");
				break;
			}
			
			
			System.out.println("Introduce el isbn de la revista");
			String isbnr = sc.nextLine();
			if (isbnr != null) {
				if (isbnr.length() != 10) {
					System.out.println("El isbn tiene que tener 10 digitos");
					break;
				}
			}else {
				System.out.println("No puedes dejar en blanco el campo ISBN");
			}
			
			
			System.out.println("Introduce el numero de paginas de la revista");
			String nPaginas= sc.nextLine();
			int nPag = Integer.parseInt(nPaginas);
			if (nPag < 1) {
				System.out.println("La revista tiene que tener 1 pagina como minimo");
			}
			
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
			
		case 2:
			listadoRevistas();
			break;
		case 3:
			
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

	//private static void cargarRevistas() {
		//CrudAble<Revista> dao = RevistaDao.getInstance();	
//	}
	
	public static void p(String s) {
		System.out.println(s);
	}

}
