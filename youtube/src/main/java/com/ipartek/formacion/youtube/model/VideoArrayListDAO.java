package com.ipartek.formacion.youtube.model;


import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	 

	private static VideoArrayListDAO INSTANCE = null;
private static List<Video> videos = null;
	
	
	private VideoArrayListDAO() {
	/*	videos = new ArrayList<Video>();
		try {
			videos.add(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
			videos.add(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
			videos.add(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		} catch (Exception e) {
			e.printStackTrace();
}*/
	}

	public static synchronized VideoArrayListDAO getInstance() throws ClassNotFoundException {
		
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new VideoArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {
		return videos.add(pojo);
	}

	@Override
	public List<Video> getAll() {
		return videos;
	}

	@Override
	public Video getById(String id) {
		Video resul = null;
		if (id != null) {
			for (Video v : videos) {
				if (id.equals(v.getId())) {
					resul = v;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Video pojo) {
		
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Video v = null;
		if ( id != null ) { 
			for (int i = 0; i < videos.size(); i++) {
				v = videos.get(i); 
				if (id.equals(v.getId()) ) { 
					resul = videos.remove(v);
					break;
				}
			}
		}	
		return resul;
	}

}
