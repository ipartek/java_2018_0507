package com.ipartek.formacion.video.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import com.ipartek.formacion.video.pojo.VideoYoutube;

/**
 * @class VideoYoutubArrayDAO que que implementa Crudable operaciones de la BBDD
 *        guarda los videos los recupera elimina actualiza y los busca por id
 * 
 *        contiene un constructor privado para que no se pueda crear un obj de
 *        esta clase fuera sin pasar por otro metodo que solo permite una sola
 *        instanciación del objeto fuera de la clase.
 * @author AnaMAMM
 *
 */
public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube> {

	/**
	 * array para guardar los videos
	 */
	private List<VideoYoutube> videos = new ArrayList<>();

	/**
	 * variable estatica para poder crear la instancia de esta clase en el metodo getInstance()
	 */
	private static VideoYoutubeArrayDAO INSTANCE;

	/**
	 * constructor privado
	 */
	private VideoYoutubeArrayDAO() {
	}

	/**
	 * metodo para crear una sola instancia de esta clase fuera de ella.
	 * si no hay una instancia creada se crea una y la devuelve
	 * @return INSTANCE
	 */
	public static synchronized VideoYoutubeArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}

		return INSTANCE;
	}

	/**
	 * devuelve todos los videos del arrayList
	 */
	@Override
	public List<VideoYoutube> getAll() {
		return videos;
	}

	/**
	 * busca un video por su id y devuelve un objeto
	 * de la clase VideoYuotube
	 */
	@Override
	public VideoYoutube getById(long id) {
		VideoYoutube resul = null;
		// foreach
		for (VideoYoutube videoIteracion : videos) {
			if (id == videoIteracion.getId()) {
				resul = videoIteracion;
				break;
			}
		}
		return resul;
	}

	/**
	 * Inserta un video en el arrayList
	 */
	@Override
	public boolean insert(VideoYoutube video) {
		boolean resul = false;

		if (video != null) {
			resul = videos.add(video);
		}
		return resul;
	}

	/**
	 * actualiza un video
	 */
	@Override
	public boolean update(VideoYoutube videoUpdate) {
		boolean resul = false;
		VideoYoutube videoIteracion = null;
		int i = 0;
		if (videoUpdate != null) {
			// Iterator
			Iterator<VideoYoutube> it = videos.iterator();
			while (it.hasNext()) {
				videoIteracion = it.next();
				if (videoIteracion.getId() == videoUpdate.getId()) {
					videos.set(i, videoUpdate);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	/**
	 * elimina un video
	 */
	@Override
	public boolean delete(long id) {
		boolean resul = false;

		VideoYoutube vIteracion = null;

		// buscar video a eliminar
		for (int i = 0; i < videos.size(); i++) {

			vIteracion = videos.get(i); // video sobre el que iteramos

			if (id == vIteracion.getId()) { // video encontrado
				resul = videos.remove(vIteracion);
				break;
			}
		}

		return resul;
	}

}
