package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {

	//private static final int LISTADO = 1;

	
	
	public static void main(String[] args) {
		
		
		cargarVideos();
		
		//mostrarMenu();
		empezar();
		
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado
		//int opcion = LISTADO;
		
//		switch(opcion) {
//		case LISTADO:
//			listadoVideos();
//			break;
//		}
		
		
		
		
		Scanner teclado = new Scanner(System.in);
		
		int opcion = teclado.nextInt();
		
		
		
//		do {
//			
//		}while(opcion!=0);
	
//		switch(opcion) {
//		case 1:
//			listadoVideos();
//			break;
//		case 2:
//			mostrarCabecera();
//			break;
//		case 3:
//			mostrarVideo(null) ;
//			break;
//		case 4:
//			cargarVideos();
//			break;
//		case 0:
//			System.out.println("byee");
//			break;
//			
//			
//		}
		
	}

	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Mostrar cabecera");
		p("3. Mostrar video");
		p("4. Cargar videos");
		p("0. Salir");
		p("Elige una opción");
	}
	
	
	
	
	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);
		}
		
		empezar();
	}

	private static void mostrarCabecera() {
		p("ID\tCODIGO\tTITULO");
	}
	
	private static void mostrarVideo(VideoYoutube video) {
		p(video.getId() + "\t" + video.getCodigo() + "\t" + video.getTitulo());
		
	}

	private static void cargarVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		for(int i = 1; i <= 5; i++) {
			dao.insert(new VideoYoutube(i, "codigo" + i, "titulo" + i));
		}
	
	}

	/**
	 * Para que al hacer un system.out.print ln solo tengas que poner una p
	 * @param s
	 */
	public static void p(String s) {
		System.out.println(s);
	}
	
	
	/**
	 * 
	 */

	public static void empezar() {
		
		mostrarMenu();
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		
		
		switch(opcion) {
		case 1:
			listadoVideos();
			break;
		case 2:
			mostrarCabecera();
			break;
		case 3:
			mostrarVideo(null) ;
			break;
		case 4:
			cargarVideos();
			break;
		case 0:
			System.out.println("byee");
			break;
			
	}
}}
