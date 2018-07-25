package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {

	private static final int SALIR = 0;
	private static final int ACTUALIZAR = 5;
	private static final int BORRAR = 4;
	private static final int NUEVO = 3;
	private static final int ARTICULO = 2;
	private static final int LISTADO = 1;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		cargarVideos();

		mostrarMenu();

		// TODO: Hacer el menú que se repita cada vez e implementar la lectura de
		// teclado
		
		Scanner sc = new Scanner(System.in);

		int opcion= sc.nextInt();		
		
		switch (opcion) {
		case LISTADO:
			listadoVideos();
			break;
		case ARTICULO:
			videosArticulo();
			break;
		case NUEVO:
			videosNuevo();
			break;
		case BORRAR:
			videosBorrar();
			break;
		case ACTUALIZAR:
			videosActualizar();
			break;
		case SALIR:
			videosSalir();
			break;
			
		}
		
		sc.close();
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

		for (VideoYoutube video : dao.getAll()) {
			mostrarVideo(video);
		}
	}

	private static void videosArticulo() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();

		Scanner sc = new Scanner(System.in);
		p("Introduce el ID de la película: ");
		long identificador = sc.nextLong();

		VideoYoutube video = dao.getById(identificador);
		mostrarCabecera();
		mostrarVideo(video);

		sc.close();
	}

	
	private static void videosNuevo() throws InstantiationException, IllegalAccessException {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID de la película: ");
		long id = sc1.nextLong();
		
		
		Scanner sc2 = new Scanner(System.in);
		p("Introduce el código de la película: ");
		String codigo = sc2.next();
		
		
		Scanner sc3 = new Scanner(System.in);
		p("Introduce el titulo de la película: ");
		String titulo = sc3.next();
		
		
		VideoYoutube video = VideoYoutube.class.newInstance();
		video.setId(id);
		video.setCodigo(codigo);
		video.setTitulo(titulo);
		dao.insert(video);

		p("El video se ha insertado");
		sc1.close();
		sc2.close();
		sc3.close();
	}
	
	
	
	private static void videosBorrar() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();

		Scanner sc = new Scanner(System.in);
		p("Introduce el ID de la película a borrar: ");
		long id = sc.nextLong();
		dao.delete(id);
		sc.close();
		
		p("Video borrado");
	}
	
	
	private static void videosActualizar() throws InstantiationException, IllegalAccessException {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();

		Scanner sc1 = new Scanner(System.in);
		p("Introduce el ID de la película a actualizar: ");
		long id = sc1.nextLong();
		
		VideoYoutube video = dao.getById(id);
		
		Scanner sc2 = new Scanner(System.in);
		p("Introduce el nuevo código de la película: ");
		String codigo = sc2.next();
		
		Scanner sc3 = new Scanner(System.in);
		p("Introduce el nuevo titulo de la película: ");
		String titulo = sc3.next();
		
		VideoYoutube video2 = VideoYoutube.class.newInstance();
		video.setCodigo(codigo);
		video.setTitulo(titulo);
		dao.insert(video2);

		sc1.close();
		sc2.close();
		sc3.close();

		p("Video actualizado");
	}
	
	private static void videosSalir() {
		p("Gracias por utilizar esta aplicación. Adiós");

	}
	
	private static void mostrarCabecera() {
		p("ID\tCODIGO\tTITULO");
	}

	private static void mostrarVideo(VideoYoutube video) {
		p(video.getId() + "\t" + video.getCodigo() + "\t" + video.getTitulo());
	}

	private static void cargarVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();

		for (int i = 1; i <= 5; i++) {
			dao.insert(new VideoYoutube(i, "codigo" + i, "titulo" + i));
		}

	}

	public static void p(String s) {
		System.out.println(s);
	}

}
