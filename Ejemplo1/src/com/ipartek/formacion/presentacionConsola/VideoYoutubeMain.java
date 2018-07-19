package com.ipartek.formacion.presentacionConsola;

import com.ipartek.formacion.accesoDatos.CrudAble;
import com.ipartek.formacion.accesoDatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeMain {
	
	private static CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
	
	private static final int SALIR = 0;
	private static final int LISTADO = 1;
	private static final int CARGAR_VIDEO = 2;
	private static final int INSERTAR_VIDEO = 3;
	private static final int MODIFICAR_VIDEO = 4;
	private static final int BORRAR_VIDEO = 5;
	
	public static void main(String[] args) {
		
		cargarVideos();
		int opcion;
		
		do {
			mostrarMenu();
			
			opcion = Utils.leerInt();
			
			procesarOpcion(opcion);
			
		} while (opcion != SALIR);
	}

	private static void procesarOpcion(int opcionesMenu) {
		switch (opcionesMenu) {
			case LISTADO: 
				listadoVideos();
				break;
			case CARGAR_VIDEO:
				cargarVideoConcreto();
				break;
			case INSERTAR_VIDEO:
				insertarVideo();
				break;
			case MODIFICAR_VIDEO:
				modificarVideo();
				break;
			case BORRAR_VIDEO:
				eliminarVideo();
				break;
			case SALIR:
				salir();
				break;
			default:
				noDisponible();
				break;
		}
	}
	
	private static void listadoVideos() {
		mostrarCabecera();
		
		for (VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);	
		}
	}

	private static void cargarVideoConcreto() {
		listadoVideos();

		p("Introduce un ID: ");
		long idVideo = Utils.leerLong();
		
		VideoYoutube newDao = dao.getById(idVideo);
		
		if (newDao != null) {
			mostrarCabecera();
			mostrarVideo(newDao);
		}else {
			p("No existe el video con ID: " + idVideo);
		}
	}

	private static void insertarVideo() {
		VideoYoutube video = crearVideoConDatosConsola();
		
		boolean resultadoOperacion = dao.insert(video);
		
		if (resultadoOperacion) {
			p("Video insertado correctamente");
		}else {
			p("ERROR al insertar video");
		}
	}

	private static void modificarVideo() {

		VideoYoutube video = crearVideoConDatosConsola();
		
		boolean resultadoOperacion = dao.update(video);
		
		if (resultadoOperacion) {
			p("Video modificado correctamente");
		}else {
			p("ERROR al modificar video");
		}
	}
	
	private static void eliminarVideo() {
		p("ID del video a eliminar: ");
		long id = Utils.leerLong();
		
		boolean resultadoOperacion = dao.delete(id);
		
		if (resultadoOperacion) {
			p("Video borrado correctamente");
		}else {
			p("ERROR al borrar video");
		}
	}

	private static void mostrarCabecera() {
		p("ID\tCODIGO\tTITULO");
	}
	
	private static void mostrarVideo(VideoYoutube video) {
		p(video.getId() + "\t" + video.getCodigo() + "\t" + video.getTitulo());
	}

	private static void cargarVideos() {
		for (int i = 1; i <= 10; i++) {
			dao.insert(new VideoYoutube(i, "codigo" + i, "Titulo" + i));
		}
	}

	public static void p(String s) {
		System.out.println(s);
	}
	
	public static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Cargar video concreto");
		p("3. Insertar nuevo video");
		p("4. Modificar video");
		p("5. Eliminar video");
		p("");
		p("0. Salir de la aplicacion");
		p("Elige una opcion: ");
	}

	private static VideoYoutube crearVideoConDatosConsola() {
		p("ID: ");
		long id = Utils.leerLong();
		p("Nuevo codigo youtube: ");
		String codigo = Utils.leerLinea();
		p("Nuevo titulo youtube: ");
		String titulo = Utils.leerLinea();
		
		VideoYoutube video = new VideoYoutube(id, codigo, titulo);
		return video;
	}
	
	private static void salir() {
		p("ADIOS!!!");
	}
	
	private static void noDisponible() {
		p("Esa funcion no existe");
	}

}
