package com.ipartek.formacion.video.accesoadatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.video.pojo.VideoYoutube;

public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube>{
	private static VideoYoutubeArrayDAO INSTANCE;
	private List<VideoYoutube> videos=new ArrayList<>();
	
	private VideoYoutubeArrayDAO() {
		
	}
	//synchroniced solo por un hilo
	public static synchronized VideoYoutubeArrayDAO getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new VideoYoutubeArrayDAO();
		}
		return INSTANCE;
	}
	@Override
	public List<VideoYoutube> getAll() {
		// TODO Auto-generated method stub
		return videos;
	}

	@Override
	public VideoYoutube getById(long mock2Id) {
		// TODO Auto-generated ,method stub
		VideoYoutube resul=null;
		for (VideoYoutube videoIteracion :videos)
			if(mock2Id==videoIteracion.getId())
			{
				resul=videoIteracion;
				break;
			}
		return resul;
	}

	@Override
	public boolean insert(VideoYoutube pojo) {
		// TODO Auto-generated method stub
		boolean resul=false;
		if (pojo !=null)
			resul=videos.add(pojo);
		
		return resul;
	}

	@Override
	public boolean update(VideoYoutube videoUpdate) {
		// TODO Auto-generated method stub
		boolean resul=false;
		VideoYoutube videoIteracion =null;
		int i=0;
		
		return false;
	}

	@Override
	public boolean delete(Long pojo) {
		// TODO Auto-generated method stub
		return false;
	}

}
