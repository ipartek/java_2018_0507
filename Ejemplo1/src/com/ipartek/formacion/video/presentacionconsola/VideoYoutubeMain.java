package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesoDatos.CrudAble;
import com.ipartek.formacion.video.accesoDatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;


public class VideoYoutubeMain {
	
	public static boolean salir = true;
	public static String letter;
	public static char caracter;
	public static int opcion;
	public static int id;
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc3 = new Scanner(System.in);
	static LeerTeclado lt = new LeerTeclado(sc);
	static LeerTeclado lt2 = new LeerTeclado(sc2);
	static LeerTeclado lt3 = new LeerTeclado(sc3);
	
	public static void main(String[] args) {

		cargarVideos();
		mostrarMenu();//Muestro el menu --> llamo a metodo opcionMenu 
						//desde mostrarMenu
						//despues de elegir y ejecutar una opcion --> volver
						//desde opcionMenu --> y al fi
	}
	
	private static void cargarVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		for(int i = 1; i <= 5; i++) {
			dao.insert(new VideoYoutube(i, "codigo" + i, "titulo" + i));
		}
		
	}


	private static void opcionMenu(int opcion) {
		do {
			opcion = lt.leerInt(opcion);
			salir = true;
		switch(opcion) {
		case 1: 
			listadoVideos();
			volver();
			break;
		case 2:
			listadoById();
			volver();
			break;
		case 3:
			Add();
			volver();
			break;
		case 4:
			update();
			volver();
			break;
		case 5:
			delete();
			volver();
			break;
		default:
			salir = false;
			System.out.println("Eleccion no valida. \nVuelva a elegir una opcion");
			break;
		}
		}while (salir==false);
	}

	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("...");
		p("2. Indica que video quieres ver. (Por Id)");
		p("...");
		p("3. Añadir video.");
		p("...");
		p("4. Modificar video.");
		p("...");
		p("5. Eliminar video.");
		p("...");
		p("0. Salir");
		p("...");
		p("Elige una opción");
		
		opcionMenu(opcion);
	}
	
	private static void volver() {
		
		System.out.println("\nQuieres volver al menu? S/N");
		leerSN();
		if(caracter == 's' || caracter == 'S') {
			mostrarMenu();
		}else if (caracter == 'n' || caracter == 'N'){
			System.out.println("Adios");
		}else {
			volver();
		}
	}
	
	public static void leerSN(){
		letter = lt2.leerChar(letter);
		caracter = letter.charAt(0);
	}
	
	private static void mostrarCabecera() {
		p("ID\tCODIGO\tTITULO");
	}
	
	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);
		}
	}
	
	private static void mostrarVideo(VideoYoutube video) {
		p(video.getId() + "\t" + video.getCodigo() + "\t" + video.getTitulo());
	}
	
	private static void listadoById() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		p("Indique el id" + "(" + dao.getAll().size() + ")");
		id = lt.leerInt(id);
		for (VideoYoutube video : dao.getAll()) {
			if(video.getId()==id) {
				mostrarCabecera();
				System.out.println(video.getId() + "\t" + video.getCodigo() + "\t"  + video.getTitulo());
			}
		}
	}
	
	private static void Add() {
		// TODO Crear metodo añadir
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		long id = 0;
		String codigo = null;
		String titulo = null;
		//No comprueba que el id exista
		//id = dao.getAll().size()+1;
		listadoVideos();
		p("Introduzca un id que no este en la lista");
		id = lt.leerLong(id);
		p("Introduzca el titulo");
		titulo = lt2.leerString(titulo);
		p("Introduzca el Codigo");
		codigo = lt3.leerString(codigo);
		dao.insert(new VideoYoutube(id, codigo,  titulo));

	}

	private static void delete() {
		// TODO Crear metodo eliminar.
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		long id = 0;
		listadoVideos();
		p("");
		p("Introduzca el id del video que desea eliminar");
		id = lt.leerLong(id);
		dao.delete(id);
	}

	private static void update() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		long id = 0;
		String titulo = null;
		String codigo = null;
		listadoVideos();
		p("");
		p("Introduzca el id del video que desea actualizar");
		id = lt.leerLong(id);
		p("Introduzca el titulo del video que desea actualizar");
		titulo = lt2.leerString(titulo);
		p("Introduzca el codigo del video que desea actualizar");
		codigo = lt3.leerString(codigo);
		
		dao.update(new VideoYoutube(id, codigo, titulo));
	}

	public static void p(String s) {
		System.out.println(s);
	}
}
