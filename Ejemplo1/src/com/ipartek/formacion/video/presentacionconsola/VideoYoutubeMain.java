package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {

	private static final int SALIR = 0;
	private static final int ACTUALIZAR = 5;
	private static final int BORRAR = 4;
	private static final int NUEVA = 3;
	private static final int ARTICULO = 2;
	private static final int LISTADO = 1;

	public static void main(String[] args) {
		cargarVideos();
		
		mostrarMenu();
		
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		
		switch(opcion) {
		case LISTADO:
			listadoVideos();
			break;
		case ARTICULO:
			listadoVideos();
			break;
		case NUEVA:
			listadoVideos();
			break;
		case BORRAR:
			listadoVideos();
			break;
		case ACTUALIZAR:
			listadoVideos();
			break;
		case SALIR:
			listadoVideos();
			break;

			
		}
	}

	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Buscar un video");
		p("3. Añadir un nuevo video");
		p("4. Borrar un video");
		p("5. Actualizar un video");
		p("0. Salir");
		p("Elige una opción");
	}
	
	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);
		}
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
