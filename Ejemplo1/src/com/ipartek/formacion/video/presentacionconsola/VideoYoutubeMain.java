package com.ipartek.formacion.video.presentacionconsola;

import com.ipartek.formacion.video.accesoDatos.CrudAble;
import com.ipartek.formacion.video.accesoDatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {
	
	public static void main(String[] args) {
		cargarVideos();
		
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("...");
		p("Elige una opcion");
		
		//TODO Hacer el menu que se repita cada vez e implementar lectura de teclado

		int opcion = 1;
		
		switch(opcion) {
		case 1:
		listadoVideos();
		break;
		}
	}
	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao =VideoYoutubeArrayDAO.getInstance();
		
		p("id\tCodigo\tTitulo");
		
		for (VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);
		}
	}
	private static void mostrarVideo(VideoYoutube video) {
	//	p(video)
		
	}
	private static void cargarVideos() {
		CrudAble<VideoYoutube> dao =VideoYoutubeArrayDAO.getInstance();
		for(int i =1; i<=10;i++) {
			dao.insert(new VideoYoutube(1, "asdfg", "mi video"));
		}
	}
	public static void p(String s) {
		System.out.println(s);
	}
}
