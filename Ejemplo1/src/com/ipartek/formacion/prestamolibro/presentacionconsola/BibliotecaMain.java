package com.ipartek.formacion.prestamolibro.presentacionconsola;

import java.util.Scanner;

public class BibliotecaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		cargarLibros();
		empezar();
		insertarLibros();
		
	}

	
	private static void mostrarMenu() {
		p("selecciona una opcion");
		p("0.mostrar lista libros y clientes");

		p("1.Subir un libro");
		p("2.Subir un cliente");
		p("3.actualizar libro");
		p("4.actualizar cliente");
		p("5.eliminar libro");
		p("6.eliminar cliente");
		p("7.actualizar video");

		p("Elige una opción");
		
		
		Scanner o=new Scanner(System.in);
		
	int opcion = o.nextInt();
		
		switch(opcion) {
		case 1:
			listadoVideos();
			break;
		case 2:
			subirVideos();
			break;
		case 3:
			eliminarVideos();;
			break;
		case 4:
			actualizarVideo();
			break;
		}
	}
	
	
	
	
	private static void insertarLibros() {
		// TODO Auto-generated method stub
		
	}

	private static void empezar() {
		// TODO Auto-generated method stub
		
	}

	private static void cargarLibros() {
		// TODO Auto-generated method stub
		
	}

	private static void p(String p) {
		System.out.println(p);
	}
	
}
