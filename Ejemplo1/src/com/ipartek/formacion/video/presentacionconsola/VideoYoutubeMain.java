package com.ipartek.formacion.video.presentacionconsola;

<<<<<<< HEAD
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
=======
import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {
<<<<<<< HEAD
	
	//variables estaticas para definir la accion que selecciona el usuario en el switch
	
=======

	private static final int DELETE_VIDEO = 5;
	private static final int UPDATE_VIDEO = 4;
	private static final int ADD_VIDEO = 3;
	private static final int BUSCAR_ID = 2;
	private static final int SALIR = 0;
>>>>>>> refs/remotes/origin/Javier_Lete
	private static final int LISTADO = 1;
<<<<<<< HEAD
	private static final int MOSTRAR = 2;
	private static final int INSERTAR = 3;
	private static final int ACTUALIZAR = 4;
	private static final int ELIMINAR = 5;
	private static final int SALIR = 0;
	private static CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
	//dao = VideoYoutubeArrayDAO.getInstance(); 
	//CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance(); 
	//convertir variable local a campo
=======
	
	private static CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
>>>>>>> refs/remotes/origin/Javier_Lete

	public static void main(String[] args) {
		cargarVideos();
		int opcion;

		
<<<<<<< HEAD
		do {
			mostrarMenu();
			opcion = Utils.leerInt(); //Lee una opcion
	
			procesarOpcion(opcion);
=======
		int opcion;
>>>>>>> refs/remotes/origin/Javier_Lete
		
<<<<<<< HEAD
=======
		do {
			mostrarMenu();
			
			opcion = Utils.leerInt();
			
			procesarOpcion(opcion);
>>>>>>> refs/remotes/origin/Javier_Lete
		}while(opcion != SALIR);
	}

	private static void procesarOpcion(int opcion) {
		switch(opcion) {
<<<<<<< HEAD
			case LISTADO:
				listadoVideos();
				break;
			case 2:
				buscarPorId();
				break;			
			case 3:
				addVideo();
				break;				
			case 4:
				actualizarVideo();
				break;			
			case 5:
				eliminarVideo();
				break;				
			case SALIR:
				salir();
				break;				
			default:
				noDisponible();
=======
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
>>>>>>> refs/remotes/origin/Javier_Lete
		}
	}
			
	private static void eliminarVideo() {
		p("Dime el ID del video");
		long id = Utils.leerLong();
		
		if(dao.delete(id)) {
			p("Video borrado correctamente");
		} else {
			p("No se ha podido borrar el video");
		}
	}

	private static void actualizarVideo() {
		VideoYoutube video = crearVideoConDatosDeConsola();
		
		if(dao.update(video)) {
			p("Video modificado correctamente");
		} else {
			p("No se ha podido modificar el video");
		}
		
	}

	private static void buscarPorId() {
		p("Dime el ID del video");		//Pregunto por el id
		long id = Utils.leerLong();		//Leo el id
		
		VideoYoutube video = dao.getById(id);	//Le paso el id
		
		mostrarCabecera();	//saco la cabecera con un solo video
		mostrarVideo(video);
	}
	
	private static void addVideo() {
		VideoYoutube video = crearVideoConDatosDeConsola();
		
		if(dao.insert(video)) {	//añado el video
			p("Video añadido correctamente");
		}else {
			p("No se ha podido añadir el video");
		}	
	}

	private static VideoYoutube crearVideoConDatosDeConsola() { //refactor -> extract method
		p("Dime el ID del nuevo video");	
		long id = Utils.leerLong();		
		p("Dime el CODIGO del nuevo video");	
		String codigo = Utils.leerLinea();
		p("Dime el TITULO del nuevo video");
		String titulo = Utils.leerLinea();
		
		VideoYoutube video = new VideoYoutube(id, codigo, titulo);
		return video;
	}
	
	
	    private static void noDisponible() {
	    	p("No disponible");	
	    }
	    
	    private static void salir() {
	    	p("Gracias por su visita");	
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
		VideoYoutube video = crearVideoConDatosDeConsola();
		
		if(dao.update(video)) {
			p("Video modificado correctamente");
		} else {
			p("No se ha podido modificar el video");
		}
	}

	private static void addVideo() {
		VideoYoutube video = crearVideoConDatosDeConsola();
		
		if(dao.insert(video)) {
			p("Video añadido correctamente");
		} else {
			p("No se ha podido añadir el video");
		}
	}

	private static VideoYoutube crearVideoConDatosDeConsola() {
		p("ID:");
		long id = Utils.leerLong();
		p("Código:");
		String codigo = Utils.leerLinea();
		p("Título:");
		String titulo = Utils.leerLinea();
		
		VideoYoutube video = new VideoYoutube(id, codigo, titulo);
		return video;
	}

	private static void buscarPorId() {
		p("Dime el ID del video");
		long id = Utils.leerLong();
		
		VideoYoutube video = dao.getById(id);
		
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
		p("");
	}
	
	private static void listadoVideos() {
<<<<<<< HEAD
		
=======
>>>>>>> refs/remotes/origin/Javier_Lete
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
>>>>>>> branch 'cristina' of https://github.com/ipartek/java_2018_0507
		}
		
	}

	public static void p(String s) {
		System.out.println(s);
	}

}
