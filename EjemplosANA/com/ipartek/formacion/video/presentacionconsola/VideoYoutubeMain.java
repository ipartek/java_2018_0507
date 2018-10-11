package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;
@SuppressWarnings("unused")
public class VideoYoutubeMain {

	private static final int LISTADO = 1;
	private static final int SALIR = 0;
	
	private static boolean CONTINUAR=true;
	public static void main(String[] args) {
	String videoIDSeleccionado;
	int opcion = LISTADO;
		
		cargarVideos();
		
		mostrarMenu();
		
		//Leer de Teclado
		//
		
		Scanner sc = new Scanner(System.in);
		System.out.println("SC"+sc.nextLine());
		VideoYoutubeArrayDAO vyad=VideoYoutubeArrayDAO.getInstance();

		
		while(sc.nextLine()!="0") {
				
				switch(sc.nextLine()) {
					
					case "1":
						listadoVideos();
						mostrarMenu();
						break;
						
					case "2":
						//mostrarVideo con id
						System.out.println("Introduce ID Video");
						Scanner sc1 = new Scanner(System.in);
						videoIDSeleccionado=sc1.nextLine();
						System.out.println("Video seleccionado ID:"+videoIDSeleccionado);
						mostrarVideo(vyad.getById(Long.valueOf(videoIDSeleccionado)));
						break;

					case "3":
						//mostrarVideo con id
						System.out.println("Añadiendo video");
						aniadirVideo();
						
					case "0":
						p("ADIOS");
						CONTINUAR=false;
						opcion=0;
						break;
			
					default:
						p("ADIOS");
						CONTINUAR=false;
						opcion=0;
						break;
				}
		}
		sc.close();
	}

	private static void mostrarMenu() {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Mostrar Video");
		p("3. Añadir video");
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
	@SuppressWarnings("static-access")
	private static void aniadirVideo() {
		
		VideoYoutube video = new VideoYoutube(33, "titut", "24");
		
		VideoYoutubeArrayDAO vyad=VideoYoutubeArrayDAO.getInstance();
		vyad.insert(video);
		System.out.println("Video con ID "+video.getId()+" añadido");
	
		
	}
	
	@SuppressWarnings("static-access")
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