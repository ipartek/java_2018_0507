package com.ipartek.formacion.uf2216.principal;

import java.util.Scanner;

import com.ipartek.formacion.uf2216.accesodatos.CrudAble;
import com.ipartek.formacion.uf2216.accesodatos.RevistaArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;

public class RevistaMain {
	private static final int LISTADO = 1;
	private static final int LISTADOID = 2;
	private static final int BORRARID = 3;
	private static final int UPDATEID = 4;
	private static final int EXIT = 0;
	private static CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
	public static void main(String[]args) {
		
		cargarRevistas();
	
	
	int opcion=0;
	
	mostrarMenu();
	
	while(((opcion=leerTeclado())<5)) {
		switch(opcion) {
		case LISTADO:
			listadoRevistas();
			mostrarMenu();
			break;
			
		case LISTADOID:
			p("que id quieres listar del 1 al"+dao.getAll().size());
			p("-----------");
			
			obternerRevistaXid(leerTeclado());
			mostrarMenu();
			break;
			
		case BORRARID:
			p("que id quieres borrar del 1 al"+ dao.getAll().size());
			p("-----------");
			borrarRevistaXid(leerTeclado());
			listadoRevistas();
			mostrarMenu();
			break;
			
		case UPDATEID:
			p("que id quieres modificar del 1 al"+ dao.getAll().size());
			p("------------------");
			modRevistaXid(leerTeclado());
			listadoRevistas();
			mostrarMenu();
			break;
		case EXIT:
			break;
			
		}
		if(opcion==0) {
			break;
			}
		}
	}
	
	private static void mostrarMenu() {
		p("------------");
		p("Revista");
		p("------------");
		p("");
		p("1. Listado de revistas");
		p("2. Obtener revista por id");
		p("3. Eliminar registro ");
		p("4. Modificar registro");
		p("0. Salir");
		p("Elige una opci�n");
		}
	
	private static void modRevistaXid(int id) {
		mostrarCabecera();
		Revista revista = new Revista("Pesca",1234567891,10,true,1);
		dao.update(revista);
	
	}
	
	private static void borrarRevistaXid(int id) {
		mostrarCabecera();
		System.out.println(dao.getById(id));
		dao.delete(id);
	}
	
	private static void obternerRevistaXid(int id) {
		mostrarCabecera();
		System.out.println(dao.getById(id));
	}
	
	private static void listadoRevistas() {
		mostrarCabecera();
		for(Revista revista:dao.getAll()) {
			mostrarRevista(revista);
		}
	}
	private static int leerTecladoElementos(int elementos) {
		Scanner teclado = new Scanner(System.in);
		int i = -1;
		try {
			do {
				i=Integer.parseInt(teclado.nextLine());
				if(i>4) 
					System.out.println("mete opciones del 0 al"+elementos);
				}
				while(i>elementos);
			}
			catch(NumberFormatException e) {
				System.out.println("Introduzca un numero por favor");
			}
			return i;
		}
		
		/*private static int leerTeclado() {
			int i = -1;
			Scanner teclado = new Scanner(System.in);
			try {
				do {
					i = Integer.parseInt(teclado.nextLine());
					if(i>4)
						System.out.println("mete opciones del 0 al 4");
				}
				while(i>4;)
			}
			catch(NumberFormatException e){
				System.out.println("Introduzca un numero por favor");
			}
		}
		return i;
	}*/
	private static int leerTeclado(){
		int i=-1;
		Scanner teclado = new Scanner(System.in);

		try {
			do {
			i=Integer.parseInt(teclado.nextLine());
			if(i>4)
				System.out.println("mete opciones del 0 al 4");
			}
			while(i>4);
		}
		catch (NumberFormatException e) {
			System.out.println("I");
		}
	
		return i;
	}
	
	private static void mostrarCabecera() {
		p("ID\tTITULO\tISBN\tNUMEROPAGINAS");
	}
	
	private static void mostrarRevista(Revista revista) {
		p(revista.getId()+"t"+revista.getTitulo()+"t"+revista.getIsbn()+"t"+revista.getNumeroPaginas());
	}
	
	private static void cargarRevistas() {
		CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
		
		for(int i = 1; i<5; i++) {
			//dao.insert(new Revista("titulo"+i,1234567891+i,4+i,1+i,2+i));
			dao.insert(new Revista(i,"Pesca"+i,1234567891+i,10+i,1+i));
			
		}
	}
	
	public static void p(String s) {
		System.out.println(s);
	}
}
	
	
