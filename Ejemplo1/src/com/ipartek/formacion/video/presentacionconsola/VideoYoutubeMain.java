package com.ipartek.formacion.video.presentacionconsola;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {
	
	//variables estaticas para definir la accion que selecciona el usuario en el switch
	
	private static final int LISTADO = 1;
	private static final int MOSTRAR = 2;
	private static final int INSERTAR = 3;
	private static final int ACTUALIZAR = 4;
	private static final int ELIMINAR = 5;
	private static final int SALIR = 0;


	public static void main(String[] args) {
		
		//instanciar la clase VideoYoutubeArrayDAO 
		VideoYoutubeArrayDAO dao = VideoYoutubeArrayDAO.getInstance();
		//cargar por defecto los videos que haya
		cargarVideos();
		
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		
		
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado
		//int opcion = LISTADO;
		
	    do {
			mostrarMenu();
			
			opcion = teclado.nextInt();
			
			//TODO: corregir 
	
			switch (opcion) {

			case LISTADO:
				listadoVideos();
				break;
				
			case MOSTRAR:
				
				p("Inserte el ID de video que desea ver");
				int idVideo = 0;
				
				idVideo = teclado.nextInt();
				
				//public VideoYoutube getById(long id)

				VideoYoutube videoSelect = dao.getById(idVideo);
				mostrarCabecera(); 
				mostrarVideo(videoSelect); 
				
				break;
			
			case INSERTAR:
				p("Inserte el ID del nuevo video");
				long id = 0;
				id = teclado.nextLong();
				p("Inserte el CODIGO del nuevo video");
				String codigo = null;
				codigo = teclado.nextLine();
				p("Inserte el TITULO del nuevo video");
				String titulo = null;
				titulo = teclado.nextLine();
				
				//public boolean insert(VideoYoutube video) 
				VideoYoutube videoInsert = new VideoYoutube(id, codigo, titulo);
				mostrarCabecera(); 
				mostrarVideo(videoInsert); 
				
				
				break;
				
			case ACTUALIZAR:
				break;
				
			case ELIMINAR:
				break;
				
		
			}
		
	}while(opcion != SALIR);
	    
	}


	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("3. Mostrar video");
		p("4. Insertar");
		p("5. Actualizar");
		p("6. Eliminar");
		p("0. Salir");
		p("Elige una opción");
	}
	
	private static void listadoVideos() {
		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
		
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
