package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {

	private static final int LISTADO = 1;

	public static void main(String[] args) {
		cargarVideos();
		inicio();
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado
	
	}
	
	
	private static void inicio() {
	
		mostrarMenu();
		
		
	}

	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2.subir video");
		p("3.Borrar video");
		p("4.actualizar video");

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
	
	
	
	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for(VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);
		}
		inicio();
	}

	public static void subirVideos() {
		System.out.println("mete id, codigo y nombre ");
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();

		Scanner o=new Scanner(System.in);

		
		long id=o.nextLong();
		String codigo=o.next();
		String titulo=o.next();
		if(dao.getById(id)==null) {
		dao.insert(new VideoYoutube(id, codigo, titulo));
		}
		else {
		 System.out.println("ya existe");
		}
		inicio();			
	}
	public static void eliminarVideos() {
		
		VideoYoutubeArrayDAO dao=VideoYoutubeArrayDAO.getInstance();
		System.out.println("que video quieres eliminar");
		Scanner o=new Scanner(System.in);

		
		long id=o.nextLong();
		if(dao.getById(id).getId()==id) {
			dao.delete(id);
			System.out.println("video eliminado");
		}
		else {
			System.out.println("no existe");
		}
		inicio();
	}
	
	public static void actualizarVideo() {
		
		VideoYoutubeArrayDAO dao=VideoYoutubeArrayDAO.getInstance();
		System.out.println("que video quieres actualizar");
		Scanner o=new Scanner(System.in);
		long id=o.nextLong();
		String codigo=o.next();
		String titulo=o.next();
		if(dao.getById(id).getId()==id) {
			dao.update(new VideoYoutube(id, codigo, titulo));
		}
		else {
			System.out.println("no existe el que quieres actualizar");
		}
		inicio();
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
