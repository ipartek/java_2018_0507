package com.ipartek.formacion.presentacionConsola;

import java.util.Scanner;

import com.ipartek.formacion.accesoDatos.CrudAble;
import com.ipartek.formacion.accesoDatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeMain {

	private static final int LISTADO = 1;
	private static final int CARGAR_VIDEO = 2;
	private static final int INSERTAR_VIDEO = 3;
	private static final int MODIFICAR_VIDEO = 4;
	private static final int BORRAR_VIDEO = 5;
	private static final int SALIR = 0;
	
	
	//TODO pruebas con enum
	/*public enum OpcionesMenu{
		LISTADO(1),
		CARGAR_VIDEO(2),
		INSERTAR_VIDEO(3),
		MODIFICAR_VIDEO(4),
		BORRAR_VIDEO(5),
		SALIR(0);
		
		private int numeroOpcion;
		private OpcionesMenu(int numeroOpcion) {
			this.numeroOpcion = numeroOpcion;
		}
		public int getNumeroOpcion() {
			return this.numeroOpcion;
		}
	}*/

	public static void main(String[] args) {
		
		cargarVideos();
		
		int opcion = 0;
	
		do {
			//borrarPantalla();
			mostrarMenu();
			opcion = leerOpcion();
			
			//TODO pruebas con enum
			//OpcionesMenu opcionesMenu = OpcionesMenu.obtenerOperacionDesdeInt(opcion);
			//OpcionesMenu opcionesMenu = OpcionesMenu.values()[opcion];
			
			switch (opcion) {
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
			default:
				break;
			}
		} while (opcion != SALIR);
		
		System.out.println("ADIOS!!!");
	}

	private static int leerOpcion() {
		int opcionLeida = 0;
		Scanner sc;
		
		do {
			sc = new Scanner(System.in); 
			opcionLeida = sc.nextInt();
		}while (opcionLeida < LISTADO-1 && opcionLeida > LISTADO+4);
		
		sc.close();
		return opcionLeida;
	}

	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		mostrarCabecera();
		
		for (VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);	
		}
	}

	private static void cargarVideoConcreto() {
		long idVideo = 1;
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		listadoVideos();
		
		//do {
			p("Introduce un ID: ");
			Scanner sc = new Scanner(System.in); 
			idVideo = sc.nextInt();
		//}while (idVideo instanceof Long);
		
		sc.close();
		VideoYoutube newDao = dao.getById(idVideo);
		if (newDao != null) {
			mostrarCabecera();
			mostrarVideo(newDao);
		}else {
			p("No existe el video con ID" + idVideo);
		}
	}

	private static void insertarVideo() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		long id = dao.getAll().size()+1;
		String codigo;
		String titulo;
		
		Scanner sc = new Scanner(System.in);
		p("Nuevo codigo youtube: ");
		codigo = sc.nextLine();
		p("Nuevo titulo youtube: ");
		titulo = sc.nextLine();
		
		sc.close();
		
		boolean resultadoOperacion = dao.insert(new VideoYoutube(id, codigo, titulo));
		
		if (resultadoOperacion) {
			p("Video insertado correctamente");
		}else {
			p("ERROR al insertar video");
		}
	}
	
	private static void modificarVideo() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		long id;
		String codigo;
		String titulo;
		
		Scanner sc = new Scanner(System.in);
		p("ID del video a modificar: ");
		id = sc.nextLong();
		p("Nuevo codigo youtube: ");
		codigo = sc.nextLine();
		p("Nuevo titulo youtube: ");
		titulo = sc.nextLine();
		
		sc.close();
		
		boolean resultadoOperacion = dao.update(new VideoYoutube(id, codigo, titulo));
		
		if (resultadoOperacion) {
			p("Video modificado correctamente");
		}else {
			p("ERROR al modificar video");
		}
	}
	
	private static void eliminarVideo() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
		long id;
		Scanner sc = new Scanner(System.in);
		p("ID del video a eliminar: ");
		id = sc.nextLong();
		
		sc.close();
		
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
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
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
}
