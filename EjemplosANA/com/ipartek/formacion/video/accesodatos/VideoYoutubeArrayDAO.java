package com.ipartek.formacion.video.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube> {

	private List<VideoYoutube> videos = new ArrayList<>();

	private static VideoYoutubeArrayDAO INSTANCE;

	private VideoYoutubeArrayDAO() {
	}

	public static synchronized VideoYoutubeArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<VideoYoutube> getAll() {
		return videos;
	}

	@SuppressWarnings("static-access")
	public VideoYoutube getById(long id) {
		VideoYoutube resul = null;
		//foreach
		for (VideoYoutube videoIteracion : videos) {
			if ( id == videoIteracion.getId() ) {
				resul = videoIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(VideoYoutube video) {
		
		System.out.println(video.getTitulo());
		boolean resul = false;

		if (video != null) {
			resul = videos.add(video);
			System.out.println("VideoAñadido");
		}
		return resul;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean update(VideoYoutube videoUpdate) {
		boolean resul = false;
		VideoYoutube videoIteracion = null;
		int i = 0;
		if ( videoUpdate != null ) {
			//Iterator		
			Iterator<VideoYoutube> it = videos.iterator();
			while( it.hasNext() ) {
				videoIteracion = it.next();
				if ( videoIteracion.getId() == videoUpdate.getId() ) {
					videos.set(i, videoUpdate);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean delete(long id) {
		boolean resul = false;
		
		VideoYoutube vIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < videos.size(); i++) {
			
			vIteracion = videos.get(i);   //video sobre el que iteramos
			
			if ( id == vIteracion.getId() ) {    // video encontrado
				resul = videos.remove(vIteracion);
				break;
			}
		}
		
		return resul;
	}

}
