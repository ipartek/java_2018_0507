package com.ipartek.formacion.presentacionConsola;

import java.util.Scanner;

import com.ipartek.formacion.accesoDatos.CrudAble;
import com.ipartek.formacion.accesoDatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeMain {
	
	public enum OpcionesMenu{
		SALIR(0),
		LISTADO(1),
		CARGAR_VIDEO(2),
		INSERTAR_VIDEO(3),
		MODIFICAR_VIDEO(4),
		BORRAR_VIDEO(5);
		
		private int numeroOpcion;
		private static int maxOpciones = OpcionesMenu.values().length;
		
		private OpcionesMenu(int numeroOpcion) {
			this.numeroOpcion = numeroOpcion;
		}
		
		public int getNumeroOpcion() {
			return this.numeroOpcion;
		}
		
		public static int getMaxOpciones() {
			return maxOpciones;
		}
	}

	
	public static void main(String[] args) {
		
		cargarVideos();
		
		OpcionesMenu opcionesMenu = OpcionesMenu.values()[0];
		
		int opcion = 0;
	
		do {
			mostrarMenu();
			opcion = leerOpcion();
			
			opcionesMenu = OpcionesMenu.values()[opcion];
			
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
			default:
				break;
			}
		} while (opcion != 0);
		
		System.out.println("ADIOS!!!");
	}

	private static int leerOpcion() {
		int opcionLeida = 0;
		Scanner sc;
		int opcionesMenu = OpcionesMenu.getMaxOpciones();
		
		do {
			sc = new Scanner(System.in); 
			opcionLeida = sc.nextInt();
		}while (opcionLeida < 0 && opcionLeida > opcionesMenu);
		
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

		Scanner sc = new Scanner(System.in); 
		p("Introduce un ID: ");
		idVideo = sc.nextLong();
		
		VideoYoutube newDao = dao.getById(idVideo);
		
		if (newDao != null) {
			mostrarCabecera();
			mostrarVideo(newDao);
		}else {
			p("No existe el video con ID: " + idVideo);
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
