package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeMain {


	public static void main(String[] args) {

		cargarVideos();
		mostrarMenu();
		
		
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado

		
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
		p("2-buscar videos por id");
		p("3-insertar video");
		p("4-actualizar");
		p("5-borrar video");
		p("0. Salir");
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
