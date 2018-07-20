package com.ipartek.formacion.video.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.video.pojo.Revistas;

public class VideoYoutubeArrayDAO implements CrudAble<Revistas> {

	private List<Revistas> videos = new ArrayList<>();

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
	public List<Revistas> getAll() {
		return videos;
	}

	@Override
	public Revistas getById(long id) {
		Revistas resul = null;
		//foreach
		for (Revistas videoIteracion : videos) {
			if ( id == videoIteracion.getId() ) {
				resul = videoIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Revistas video) {
		boolean resul = false;

		if (video != null) {
			resul = videos.add(video);
		}
		return resul;
	}

	@Override
	public boolean update(Revistas videoUpdate) {
		boolean resul = false;
		Revistas videoIteracion = null;
		int i = 0;
		if ( videoUpdate != null ) {
			//Iterator		
			Iterator<Revistas> it = videos.iterator();
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

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		
		Revistas vIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < videos.size(); i++) {
			
			vIteracion = videos.get(i);   //video sobre el que iteramos
			
			if ( id == vIteracion.getId() ) {    // video encontrado
				resul = videos.remove(vIteracion);
				System.out.println();
				break;
			}
		}
		
		return resul;
	}

}
