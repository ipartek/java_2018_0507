package com.ipartek.formacion.video.presentacionconsola;

import java.util.Scanner;

import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.RevistaDao;
import com.ipartek.formacion.video.pojo.Revista;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

/**
 * @class VideoYoutubeMain
 * 
 * 
 *        clase principal que muestra un menu al usuario
 * 
 *        1. Listado de videos 2. Mostrar video 3. Insertar 5. Actualizar 5.
 *        Eliminar 0. Salir
 * 
 *        y contiene metodos, ademas de llamar a la clase
 *        {@link RevistaDao} para llevar a cabo esas operaciones
 * 
 * @author AnaMAMM
 *
 */

public class VideoYoutubeMain {

	/**
	 * variables estaticas para definir la accion que selecciona el usuario en el
	 * switch
	 */
	private static final int LISTADO = 1;
	private static final int MOSTRAR_VIDEO = 2;
	private static final int INSERTAR = 3;
	private static final int ACTUALIZAR = 4;
	private static final int ELIMINAR = 5;
	private static final int SALIR = 0;

	public static void main(String[] args) {

		/**
		 * se crea una instancia de la clase VideoYoutubeArrayDAO utilizando el metodo
		 * especifico para ello en la propia clase que permite crear solo una instancia
		 * de la misma. Se trabajará por tanto con una sola instancia de esta clase.
		 */
		RevistaDao dao = RevistaDao.getInstance();

		/**
		 * Se llama al metodo cargar videos para que cargue una lista de estos por
		 * defecto y ya haya alguno al empezar el programa.
		 */
		cargarVideos();

		/**
		 * variable para elegir la opcion en el switch
		 */
		int opcion = 0;

		/**
		 * Objeto que permite que el usuario introduzca datos por consola
		 */
		Scanner teclado = new Scanner(System.in);

		/**
		 * do - while para hacer que se repita la opción de elegir y el menú mientras la
		 * opcion sea distinta de SALIR
		 */
		do {
			/**
			 * se muestra el menu y se inicializa teclado para poder introducir el numero de
			 * la opción por consola
			 */
			mostrarMenu();
			
			try {
				opcion = teclado.nextInt();
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			/**
			 * bloque switch para elegir la opcion deseada
			 */
			switch (opcion) {

			/**
			 * lista los videos existentes
			 */
			case LISTADO:
				listadoVideos();
				break;
			/**
			 * muestra un video concreto a traves de un Id introducido por consola. Se crea
			 * una instancia de la clase VideoYoutube para llamar al metodo getById de la
			 * clase VideoYoutubeArrayDAO pasandole como parametro el id introducido que
			 * devolverá un objeto VideoYoutube
			 */
			case MOSTRAR_VIDEO:
				p("Insertar ID del video");
				int idVideo = 0;
				try {
					idVideo = teclado.nextInt();
				} catch (Exception e) {
					
					e.printStackTrace();
				}

				Revista videoElegido = dao.getById(idVideo);// crear obj VideoYoutube que es lo que devuelve
																	// getByid
				mostrarCabecera(); // muestra la cabecera
				mostrarVideo(videoElegido); // muestra el video
				break;

			/**
			 * Inserta un nuevo video. Introduce en primer lugar un id y si este no existe
			 * pide el codigo y titulo del video. Se crea una instancia de la clase
			 * VideoYoutube pasandole los parametros que hemos introducido para pasar este
			 * objeto como parametro al metodo insert de la clase VideoYoutubearrayDAO el
			 * cual devuelve un boolean. Si es correcto se intruducirá el video y lo
			 * mostrará, si no un mensaje de error aparecerá y saldrá de la opción.
			 */
			case INSERTAR:

				p("Escribir ID del video para insertar un nuevo video");
				long id = 0;
				try {
					id = teclado.nextLong();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				if (dao.getById(id) == null) {// si el id no existe, el video no existe podemos seguir
					p("Escribir Codigo del video para insertar un nuevo video");
					String cod = null;
					try {
						cod = teclado.next();
					} catch (Exception e) {
						
						e.printStackTrace();
					}// introduce el codigo
					p("Escribir título del video para insertar un nuevo video");
					String tit = null;
					try {
						tit = teclado.next();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}// introduce el titulo
					Revista videoI = new Revista(id, cod, tit); // crea una instancia de video
					boolean correcto = dao.insert(videoI); // se la pasa como argumento al metodo insert
					if (correcto) { // si devuelve true se ha insertado
						p("Nuevo video insertado correctamente. ");
						p("El video introducido es : ");
						mostrarVideo(videoI);
					} else {
						p("No se ha insertado el video");
					}
					p("El video introducido es: ");
					mostrarCabecera();
					mostrarVideo(videoI);

				} else {
					p("El id introducido ya existe");
				}
				break;

			/**
			 * Actualiza los datos de un video Se introduce el id por consola. Si este
			 * existe se introducen los datos codigo y titulo. Se crea una instanciade la
			 * clase VideoYoutube pasandole los parametros que hemos introducido para pasar
			 * este objeto como parametro al metodo updatede la clase VideoYoutubearrayDAO
			 * se muestra. Si no mensaje de error y sale
			 */
			case ACTUALIZAR:

				p("Intruduzca el Id del video a actualizar");
				long idUpdate = 0;
				try {
					idUpdate = teclado.nextLong();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				if (dao.getById(idUpdate) != null) {
					p("Escribir el nuevo codigo ");
					String cod = null;
					try {
						cod = teclado.next();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p("Escribir el nuevo título");
					String tit = null;
					try {
						tit = teclado.next();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Revista videoUp = new Revista(idUpdate, cod, tit);
					dao.update(videoUp);
					p("El video actualizado es: ");
					mostrarCabecera();
					mostrarVideo(videoUp);
				} else {
					p("El id no existe, por lo tanto no puede actualizarse ");
				}

				mostrarCabecera();
				break;

			/**
			 * Elimina un video. Se introduce el id por consola. Si existe lo elimina
			 * llamando al metodo delete de la clase VideoYoutubearrayDAO si no mensaje de
			 * error y sale.
			 */
			case ELIMINAR:
				p("Intruduzca el Id del video a eliminar");
				long idDelete = 0;
				try {
					idDelete = teclado.nextLong();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (dao.getById(idDelete) != null) {
					dao.delete(idDelete);

					p("Video eliminado correctamente");

				} else {
					p("El Id del video no existe. No puede eliminarse un video inexistente");
				}

				break;
			/**
			 * sale del menú
			 */
			case SALIR:
				p("byee");
				break;
			}
		} while (opcion != SALIR);

	}

	/**
	 * muestra el menu
	 */
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

	/**
	 * muestra un listado de videos.
	 */
	private static void listadoVideos() {
		RevistaDao dao = RevistaDao.getInstance();
//
		mostrarCabecera();
		//recorre el array de videos y los muestra
		for (Revista video : dao.getAll()) {
			mostrarVideo(video);
		}

	}

	/**
	 * muestra la cabecera de los videos. id codigo y titulo
	 */
	private static void mostrarCabecera() {
		p("ID\tCODIGO\tTITULO");
	}

	/**
	 * muestra un video con su id codigo y titulo
	 * @param video
	 */
	private static void mostrarVideo(Revista video) {
		p(video.getId() + "\t" + video.getCodigo() + "\t" + video.getTitulo());

	}

	/**
	 * carga unos videos por defecto
	 */
	private static void cargarVideos() {
		CrudAble<Revista> dao = RevistaDao.getInstance();

		for (int i = 1; i <= 5; i++) {
			dao.insert(new Revista(i, "codigo" + i, "titulo" + i));
		}

	}

	/**
	 * Para que al hacer un system.out.print ln solo tengas que poner una p
	 * 
	 * @param s
	 */
	public static void p(String s) {
		System.out.println(s);
	}


}
