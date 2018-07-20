package com.ipartek.formacion.uf2216;

import java.util.Scanner;

import com.ipartek.formacion.uf2216.revista.CrudAble;
import com.ipartek.formacion.uf2216.revista.Revista;
import com.ipartek.formacion.uf2216.revista.RevistaArrayDAO;

public class Consola {

	private static int ISBN;
	private static  int n_paginas;
	private static boolean formato;
	private static String titulo="";

	public static void main(String[] args) {
		
		//cargarRevista();
		
		String idRevista="";
		menuRevista();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("SC"+sc.nextLine());

		
		while(sc.nextLine()!="0") {
			menuRevista();
				switch(sc.nextLine()) {
					
					case "1":
						System.out.println("Añadir Revista");
						aniadirRevista();
						menuRevista();
						break;
					case "2":
						
						System.out.println("Introduce Revista");
						Scanner sc1 = new Scanner(System.in);
						idRevista=sc1.nextLine();
						System.out.println("Revista elegida ID:"+idRevista);
						break;

					case "0":
						System.out.println("ADIOS");
					
						break;
			
					default:
						System.out.println("ADIOS");
						break;
				}
		}
		sc.close();
	}
	
	private static void menuRevista() {
		System.out.println("-----------------");
		System.out.println("MIS REVISTAS Y YO");
		System.out.println("-----------------");
		System.out.println("\n\n");
	
		System.out.println("1.-Añadir Revista");
		System.out.println("2.-Mostrar Revistas");
		
		System.out.println("-----------------");
		
		System.out.println("0.-Salir");
	
		System.out.println("Elige un menu de arriba");
	}

	
		
		
		private static void listadoRevista() {
		
			CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
			
			mostrarCabecera();
			
			for(Revista revista: dao.getAll()) {
				mostrarRevista(revista);
			}
		}

		private static void mostrarCabecera() {
			System.out.println("ID\tCODIGO\tTITULO");
		}
		
		private static void aniadirRevista() {
			
			Scanner sc = new Scanner(System.in);
			
			Revista revista = new Revista(ISBN,n_paginas,formato);
			
			
			System.out.println("Introduce ISBN");
			ISBN=sc.nextInt();
			System.out.println("Introduce Titulo");
			titulo = sc.nextLine();
			System.out.println("Introduce Formato: d para digital o p para papel");
			String formatoReci = sc.nextLine();
			
			
			revista.setISBN(ISBN);
			revista.setTitulo(titulo);
			
			if (formatoReci=="d") {
				revista.setFormato(true);;
			}else if(formatoReci=="p") {
				revista.setFormato(false);
			}else {
				System.out.println("Formato no reconocio");
			}
			
			
			
			
			System.out.println("ISBN Introducido"+ISBN);
		
			System.out.println("ISBN::: "+revista.getISBN()+" añadido");
		
			
		}
		
		private static void mostrarRevista(Revista rev) {
		//CAmpiar
			System.out.println(rev.getISBN() + "\t" + rev.getTitulo() + "\t" + rev.getFormato());
		}

		private static void cargarRevista() {
			CrudAble<Revista> dao = RevistaArrayDAO.getInstance();
			
			for(int i = 1; i <= 5; i++) {
				dao.insert(new Revista(1, 1, true));
			}
		}
		
}
