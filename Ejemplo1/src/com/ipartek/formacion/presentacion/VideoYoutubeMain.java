package com.ipartek.formacion.presentacion;


import java.util.Scanner;

import com.ipartek.formacion.video.accesoadatos.CrudAble;
import com.ipartek.formacion.video.accesoadatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;
import com.ipartek.formacion.video.pojo.VideoYoutubeHashMap;

public class VideoYoutubeMain {

	private static final int LISTADO = 1;
	private static final int LISTARPORID = 2;
	private static final int BORRARID = 3;
	private static final int MODPORID = 4;
	private static final int EXIT = 0;
	private static int queMen=0;
	private static CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();
	private static CrudAble<VideoYoutube> daoHash = VideoYoutubeHashMap.getInstance();
	public static void main(String[] args) {
		cargarVideos();
		
		
		
		//TODO: Hacer el menú que se repita cada vez e implementar la lectura de teclado
		int opcion=0;
		mostrarMenu(0);
			while(((opcion=leerTeclado())<5))
			{		
				switch(opcion) {
				case LISTADO:
					listadoVideos();
					break;
				case LISTARPORID:
					mostrarMenu(1);
					obtenerVideoXid(leerTecladoElementos(dao.getAll().size()));
					queMen=0;
					break;
				case BORRARID:
					mostrarMenu(1);
					borrarVideoXid(leerTecladoElementos(dao.getAll().size()));
					listadoVideos();
					queMen=0;
					break;
				case MODPORID:
					mostrarMenu(1);
					modVideoXid(leerTecladoElementos(dao.getAll().size()));
					listadoVideos();
					break;
				case EXIT:
					break;		
					
			}
				if(opcion==0)
					break;
		}
	}

	private static void mostrarMenu(int queMenu) {
		if(queMenu==0) {
		p("------------");
		p("VideoYoutube");
		p("------------");
		p("");
		p("1. Listado de videos");
		p("2. Obtener video por id");
		p("3. Eliminar registro ");
		p("4. Modificar registro");
		p("0. Salir");
		p("Elige una opción");}
		if(queMenu==1) {
			p("que id quieres ver");
			p("----------------");
		}
		queMen=queMenu;
			 
	}
	private static void modVideoXid(int id)	{
		mostrarCabecera();
		VideoYoutube video=new VideoYoutube(id, 12+"", "te cambie");
		dao.update(video);
	}
	private static void borrarVideoXid(int id)	{
		mostrarCabecera();
		System.out.println(dao.getById(id));
		dao.delete(id);
	}
	private static void obtenerVideoXid(int id)	{
		mostrarCabecera();
		System.out.println(dao.getById(id));
		mostrarCabecera();
		System.out.println(daoHash.getById(id));
	}
	private static void listadoVideos() {
//		CrudAble<VideoYoutube> dao = VideoYoutubeArrayDAO.getInstance();		
		mostrarCabecera();		
		for(VideoYoutube video: dao.getAll()) {
			mostrarVideo(video);
		}
		for(VideoYoutube video: daoHash.getAll()) {
			mostrarVideo(video);
		}
	}
	private static int leerTecladoElementos(int elementos) {
		Scanner teclado = new Scanner(System.in);
		int i=-1;
		try {
			do {
			i=Integer.parseInt(teclado.nextLine());
			if(i>4)
				System.out.println("mete opciones del 0 al "+ elementos);
			}
			while(i>elementos);
		}
		catch (NumberFormatException e) {
			System.out.println("mete un numero melon");
		}
		return i;
	}
	private static int leerTeclado(){
		int i=-1;
		Scanner teclado = new Scanner(System.in);
	if(queMen==0) {
		try {
			do {
			i=Integer.parseInt(teclado.nextLine());
			if(i>4)
				System.out.println("mete opciones del 0 al 4");
			}
			while(i>4);
		}
		catch (NumberFormatException e) {
			System.out.println("mete un numero melon");
		}
	}
		return i;
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
			daoHash.insert(new VideoYoutube(i, "codigo" + i, "titulo" + i));
		}
		
	}

	public static void p(String s) {
		System.out.println(s);
	}

}
