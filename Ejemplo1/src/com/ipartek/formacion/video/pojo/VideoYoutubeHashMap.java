package com.ipartek.formacion.video.pojo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ipartek.formacion.video.accesoadatos.CrudAble;


public class VideoYoutubeHashMap implements CrudAble<VideoYoutube> {

	private HashMap<Long,VideoYoutube> videos = new HashMap<>();
	private static VideoYoutubeHashMap INSTANCE;
	private VideoYoutubeHashMap() {
	}

	public static synchronized VideoYoutubeHashMap getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeHashMap();
		}

		return INSTANCE;
	}
	@Override
	public List<VideoYoutube> getAll() {
		// TODO Auto-generated method stub
		List<VideoYoutube> list = new ArrayList<VideoYoutube>(videos.values());
		return  list;
	}

	@Override
	public VideoYoutube getById(long id) {
		VideoYoutube video;
		video=videos.get(id);
		// TODO Auto-generated method stub
		return video;
	}

	@Override
	public boolean insert(VideoYoutube pojo) {
		// TODO Auto-generated method stub
		boolean resul = false;

		if (videos != null) {
			resul=true;
			 videos.put(pojo.getId(), pojo);
		}
		return resul;
		
	}

	@Override
	public boolean update(VideoYoutube pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
