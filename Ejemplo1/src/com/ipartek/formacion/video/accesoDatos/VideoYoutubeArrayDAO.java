package com.ipartek.formacion.video.accesoDatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube>{

	private static VideoYoutubeArrayDAO INSTANCE;
	private List<VideoYoutube> videos = new ArrayList<>();
	private VideoYoutubeArrayDAO() {
		
	}
	
	public static synchronized VideoYoutubeArrayDAO getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public List<VideoYoutube> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoYoutube geById(long id) {
		VideoYoutube resul = null;
		for(VideoYoutube videoIteracion: videos) {
			if (id==videoIteracion.getId()) {
				resul = videoIteracion;
				break;
			}
		}
		return resul;
	}

	
	
	@Override
	public boolean insert(VideoYoutube video) {
		boolean resul = false;
		if(video!=null) {
			resul = videos.add(video);
		}
		return resul;
		
	}

	@Override
	public boolean update(VideoYoutube videoUpdate) {
		boolean resul = false;
		VideoYoutube videoIteracion = null;
		int i = 0;
		
		if (videoUpdate != null) {
			Iterator<VideoYoutube> it = videos.iterator();
			while (it.hasNext()){
				videoIteracion = it.next();
				if(videoIteracion.getId() == videoUpdate.getId()) {
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


