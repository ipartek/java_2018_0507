package com.ipartek.formacion.video.presentacionconsola;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.Revistas;

public class VideoYoutubeMain {

	private static final int DELETE_VIDEO = 5;
	private static final int UPDATE_VIDEO = 4;
	private static final int ADD_VIDEO = 3;
	private static final int BUSCAR_ID = 2;
	private static final int SALIR = 0;
	private static final int LISTADO = 1;
	
	private static CrudAble<Revistas> dao = VideoYoutubeArrayDAO.getInstance();

	public static void main(String[] args) {
		cargarVideos();
		
		int opcion;
		
		do {
			mostrarMenu();
			
			opcion = Utils.leerInt();
			
			procesarOpcion(opcion);
		}while(opcion != SALIR);
	}

	private static void procesarOpcion(int opcion) {
		switch(opcion) {
		case LISTADO:
			listadoVideos();
			break;
		case BUSCAR_ID:
			buscarPorId();
			break;
		case ADD_VIDEO: 
			addVideo();
			break;
		case UPDATE_VIDEO:
			updateVideo();
			break;
		case DELETE_VIDEO:
			deleteVideo();
			break;
		case SALIR:
			salir();
			break;
		default:
			noDisponible();
		}
	}

	private static void deleteVideo() {
		p("Dime el ID del video");
		long id = Utils.leerLong();
		
		if(dao.delete(id)) {
			p("Video borrado correctamente");
		} else {
			p("No se ha podido borrar el video");
		}
	}

	private static void updateVideo() {
		Revistas video = crearVideoConDatosDeConsola();
		
		if(dao.update(video)) {
			p("Video modificado correctamente");
		} else {
			p("No se ha podido modificar el video");
		}
	}

	private static void addVideo() {
		Revistas video = crearVideoConDatosDeConsola();
		
		if(dao.insert(video)) {
			p("Video añadido correctamente");
		} else {
			p("No se ha podido añadir el video");
		}
	}

	private static Revistas crearVideoConDatosDeConsola() {
		p("ID:");
		long id = Utils.leerLong();
		p("Código:");
		String codigo = Utils.leerLinea();
		p("Título:");
		String titulo = Utils.leerLinea();
		
		Revistas video = new Revistas(id, codigo, titulo);
		return video;
	}

	private static void buscarPorId() {
		p("Dime el ID del video");
		long id = Utils.leerLong();
		
		Revistas video = dao.getById(id);
		
		mostrarCabecera();
		mostrarVideo(video);
	}

	private static void salir() {
		p("Gracias por tu visita");
	}

	private static void noDisponible() {
		p("Esa función no existe");		
	}

	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Buscar video por id");
		p("3. Añadir video");
		p("4. Modificar video");
		p("5. Eliminar video");
		p("");
		p("0. Salir");
		p("");
		p("Elige una opción");
	}
	
	private static void listadoVideos() {
		mostrarCabecera();
		
		for(Revistas video: dao.getAll()) {
			mostrarVideo(video);
		}
	}

	private static void mostrarCabecera() {
		p("ID\tCODIGO\tTITULO");
	}
	
	private static void mostrarVideo(Revistas video) {
		p(video.getId() + "\t" + video.getCodigo() + "\t" + video.getTitulo());
	}

	private static void cargarVideos() {
		CrudAble<Revistas> dao = VideoYoutubeArrayDAO.getInstance();
		
		for(int i = 1; i <= 5; i++) {
			dao.insert(new Revistas(i, "codigo" + i, "titulo" + i));
		}
		
	}

	public static void p(String s) {
		System.out.println(s);
	}

}
