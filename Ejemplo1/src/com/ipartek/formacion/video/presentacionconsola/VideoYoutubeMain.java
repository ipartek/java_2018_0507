package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {

	private static final int LISTADO = 1;
	private static final int BUSQUEDA = 2;
	private static final int INSERTAR = 3;
	private static final int ACTUALIZAR = 4;
	private static final int BORRAR = 5;
	private static final int SALIR = 0;
	

	private static CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();


	public static void main(String[] args) {
		cargarVideos();
		
		int opcion;
		

		elegirOpcion();
				
	}

	private static void elegirOpcion() {
		Scanner sc = new Scanner(System.in);
		int opcion =  sc.nextInt();
	}
//		do {
//			mostrarMenu();
//			
//			opcion = Utils.leerInt();
//			
//			procesarOpcion(opcion);
//		}while(opcion != SALIR);
//	}

	private static void procesarOpcion(int opcion) {

		switch(opcion) {
		case LISTADO:
			listadoVideos();
			break;

		case BUSQUEDA:
			BusquedaVideo();
			break;
		case INSERTAR:
			InsertarVideo();
			break;
		case ACTUALIZAR:
			ActualizarVideo();
			break;
		case BORRAR:
			BorrarVideo();
			break;
		case SALIR:
			p("Venga, hasta luego");
			break;
		}
	}
//<<<<<<< HEAD
//=======
//	private static void deleteVideo() {
//		p("Dime el ID del video");
//		long id = Utils.leerLong();
//		
//		if(dao.delete(id)) {
//			p("Video borrado correctamente");
//		} else {
//			p("No se ha podido borrar el video");
//		}
//	}
//
//	private static void updateVideo() {
//		VideoYoutube video = crearVideoConDatosDeConsola();
//		
//		if(dao.update(video)) {
//			p("Video modificado correctamente");
//		} else {
//			p("No se ha podido modificar el video");
//		}
//	}
//
//	private static void addVideo() {
//		VideoYoutube video = crearVideoConDatosDeConsola();
//		
//		if(dao.insert(video)) {
//			p("Video añadido correctamente");
//		} else {
//			p("No se ha podido añadir el video");
//		}
//	}
//
//	private static VideoYoutube crearVideoConDatosDeConsola() {
//		p("ID:");
//		long id = Utils.leerLong();
//		p("Código:");
//		String codigo = Utils.leerLinea();
//		p("Título:");
//		String titulo = Utils.leerLinea();
//		
//		VideoYoutube video = new VideoYoutube(id, codigo, titulo);
//		return video;
//	}
//
//	private static void buscarPorId() {
//		p("Dime el ID del video");
//		long id = Utils.leerLong();
//		
//		VideoYoutube video = dao.getById(id);
//		
//		mostrarCabecera();
//		mostrarVideo(video);
//	}


	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Búsqueda de video");
		p("3. Insertar video");
		p("4. Actualizar datos video");
		p("5. Borrar Video");
		p("0. Salir");
		p("");
		p("Elige una opción");
		
	
	}
	
	private static void listadoVideos() {
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
	
	private static void InsertarVideo() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Inserta el ID");
		String id = sc.nextLine();
		int id2=Integer.parseInt(id);
		System.out.println("Inserta el Codigo");
		String cod = sc.nextLine();
		System.out.println("Inserta el Titulo");
		String tit = sc.nextLine();
		
		dao.insert(new VideoYoutube (id2,cod,tit));
		
		mostrarMenu();
		elegirOpcion();
	}
	
	private static void BusquedaVideo() {
		
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		Scanner sc = new Scanner(System.in);
		p("Inserta el ID del video que quieres buscar");
		String id = sc.nextLine();
		int id2=Integer.parseInt(id);
		System.out.println(dao.getById(id2));
		
		mostrarMenu();
		elegirOpcion();
	}


	private static void BorrarVideo() {
		
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		Scanner sc = new Scanner(System.in);
		p("Que video quieres borrar?");
		String id = sc.nextLine();
		int id2=Integer.parseInt(id);
		dao.delete(id2);
		
		listadoVideos();
		
	}
	

	private static void ActualizarVideo() {
		
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		Scanner sc = new Scanner(System.in);
		p("Que video quieres actualizar? Inserta su ID");
		String id = sc.nextLine();
		int id2=Integer.parseInt(id);
		
		VideoYoutube encontrado = new VideoYoutube();
		encontrado = VideoYoutubeArrayDAO.getInstance().getById(id2);
		
		int idc2=Integer.parseInt(id);
		System.out.println("Inserta el nuevo Codigo");
		String cod = sc.nextLine();
		System.out.println("Inserta el nuevo Titulo");
		String tit = sc.nextLine();
		encontrado.setCodigo(cod);
		encontrado.setTitulo(tit);
		VideoYoutubeArrayDAO.getInstance().update(encontrado);
		
		
	}
	

}
