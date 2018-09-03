package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {

	private static final int DELETE_VIDEO = 5;
	private static final int UPDATE_VIDEO = 4;
	private static final int ADD_VIDEO = 3;
	private static final int BUSCAR_ID = 2;
	private static final int SALIR = 0;
	private static final int LISTADO = 1;
	
	private static CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();

	public static void main(String[] args) {

		cargarVideos();
<<<<<<< HEAD
		mostrarMenu();
=======
		
		int opcion;
>>>>>>> refs/remotes/origin/tt
		
<<<<<<< HEAD
		
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado
		int opcion = LISTADO;
		

=======
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
>>>>>>> refs/remotes/origin/tt
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
		Scanner entradaEscaner = new Scanner (System.in);
		int  numero=0;
		do {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
<<<<<<< HEAD
		p("2-buscar videos por id");
		p("3-insertar video");
		p("4-actualizar");
		p("5-borrar video");
=======
		p("2. Buscar video por id");
		p("3. Añadir video");
		p("4. Modificar video");
		p("5. Eliminar video");
		p("");
>>>>>>> refs/remotes/origin/tt
		p("0. Salir");
		p("");
		p("Elige una opción");
		try {
		String num=entradaEscaner.nextLine();
		numero=Integer.parseInt(num);
		if(numero<0) {
			 Integer.parseInt( "hola" );
		}else if(numero>5) {
			 Integer.parseInt( "hola" );
		}
		}catch(Exception e) {
			System.out.println("opcion incorrecta");
			mostrarMenu();
		}
		switch(numero) {
			case 1:
				listadoVideos();
				break;
			case 2:
				System.out.println("introduce la id del video");
				String id1=entradaEscaner.nextLine();
				int id=Integer.parseInt(id1);
				System.out.println(VideoYoutubeArrayDAO.getInstance().getById(id));
				break;
			case 3:
				System.out.println("introduce la id del video");
				String idvideo=entradaEscaner.nextLine();
				int idv=Integer.parseInt(idvideo);
				
				System.out.println("introduce codigo del video");
				String codigov=entradaEscaner.nextLine();
				
				
				System.out.println("introduce el titulo del video");
				String titulov=entradaEscaner.nextLine();
				
				VideoYoutube video= new VideoYoutube();
				video.setCodigo(codigov);
				video.setTitulo(titulov);
				video.setId(idv);
				VideoYoutubeArrayDAO.getInstance().insert(video);
				break;
			case 4:
				System.out.println("introduce el id del video que quieres modificar)");
				String idbusqueda=entradaEscaner.nextLine();
				int idb=Integer.parseInt(idbusqueda);
				VideoYoutube encontrado=new VideoYoutube();
				encontrado=VideoYoutubeArrayDAO.getInstance().getById(idb);
				System.out.println("introduce codigo del video");
				String codigoM=entradaEscaner.nextLine();
				System.out.println("introduce el titulo del video");
				String tituloM=entradaEscaner.nextLine();
				encontrado.setCodigo(codigoM);
				encontrado.setTitulo(tituloM);
				VideoYoutubeArrayDAO.getInstance().update(encontrado);
				break;
			case 5:
				System.out.println("introduce el id del video que quieres modificar)");
				String idborrar=entradaEscaner.nextLine();
				int idbo=Integer.parseInt(idborrar);
				VideoYoutubeArrayDAO.getInstance().delete(idbo);
				break;
			case 0:
		}
	}while(numero!=0);
	}
	
	private static void listadoVideos() {
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
