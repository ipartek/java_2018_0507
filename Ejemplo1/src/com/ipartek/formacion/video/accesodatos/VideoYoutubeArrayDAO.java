package com.ipartek.formacion.video.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube>{

	private List<VideoYoutube> videos = new ArrayList<>();
	
	
	@Override //Override significa que en Padre voy a tener un metodo igual
	public List<VideoYoutube> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoYoutube getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(VideoYoutube pojo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(VideoYoutube pojo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(VideoYoutube pojo) {
		// TODO Auto-generated method stub
		
	}
	
}
