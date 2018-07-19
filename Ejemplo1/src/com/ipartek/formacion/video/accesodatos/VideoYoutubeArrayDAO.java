package com.ipartek.formacion.video.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.video.pojo.VideoYoutube;


public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube>{

	private List<VideoYoutube> videos = new ArrayList<>(); 

	// SINGLENTON
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
	
	@Override
	public VideoYoutube getById(long id) {
		VideoYoutube resul = null;
		
		//foreach
		for (VideoYoutube videoIteracion : videos) {
			if (id == videoIteracion.getId()) {
				resul = videoIteracion;
				break;
			}
		}
		return resul;
	}
	
	@Override
	public boolean insert(VideoYoutube video) {
		boolean resul = false;
		
		if (video != null) {
			resul = videos.add(video);
		}
		
		return resul;
	}
	
	@Override
	public boolean update(VideoYoutube video) {
		boolean resul = false;
		VideoYoutube videoIteracion = null;
		int i = 0;
		
		if (video != null){
			Iterator<VideoYoutube> it = videos.iterator();	// Iterator	
			while(it.hasNext()) {
				videoIteracion = it.next();
				if (videoIteracion.getId() == video.getId()) {
					videos.set(i, video);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}
	
	@Override
	public boolean delete(long id){
		boolean resul = false;		
		VideoYoutube vIteracion = null;
		
		// Buscar video a eliminar
		for (int i = 0; i < videos.size(); i++) {
			vIteracion = videos.get(i);   			// Video sobre el que iteramos
			
			if (id == vIteracion.getId()) {    		// Video encontrado
				resul = videos.remove(vIteracion);
				break;
			}
		}
			
		return resul;
	}
}
