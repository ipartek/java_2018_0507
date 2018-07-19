package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {


	public static void main(String[] args) {
		cargarVideos();
		
		mostrarMenu();
		
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado
		elegirOpcion();
		
		
	}

	public static Scanner sc = new Scanner(System.in);

	private static void elegirOpcion() {

		int opcion = sc.nextInt();
		
		switch(opcion) {
		case 1:
			listadoVideos();
			break;
		case 2:
			busquedaVideos();
			break;
		case 3:
			insertarVideo();
			break;
		case 4:
			actualizarVideo();
			break;
		case 5:
			borrarVideo();
			break;
		default:
			System.out.println("Has salido del programa.");
			break;
		}
	}
	
	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Busqueda de videos");
		p("3. Insertar video");
		p("4. Actualizar video");
		p("5. Borrar video");
		p("0. Salir");
		p("Elige una opción");
	}
	
	private static void borrarVideo() {
		// TODO Auto-generated method stub
		
	}

	private static void actualizarVideo() {
		// TODO Auto-generated method stub
		
	}

	private static void insertarVideo() {
		// TODO Auto-generated method stub
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		p("Introduce el id:");
		int id = sc.nextInt();
		
		p("Introduce el codigo:");
		String codigo = sc.nextLine();
		
		p("Introduce el titulo:");
		String titulo = sc.nextLine();
		
		dao.insert(new VideoYoutube (id,codigo,titulo));
		mostrarMenu();
		
	}

	private static void busquedaVideos() {
		// TODO Auto-generated method stub
		
	}
	
	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);
		}
		mostrarMenu();
		elegirOpcion();
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

	public static void p(String s) {
		System.out.println(s);
	}

}
