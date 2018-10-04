package com.ipartek.formacion.youtubeSinBBDD.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.youtubeSinBBDD.modelos.Video;

public class VideoTreeMapDAO implements CrudAble<Video> {

	// PRINCIPIO SINGLETON
	private static final VideoTreeMapDAO dao = new VideoTreeMapDAO();

	private VideoTreeMapDAO() {
	}

	public static VideoTreeMapDAO getInstance() {
		return dao;
	}
	// FIN SINGLETON

	// CONSTRUCTOR ESTÁTICO
	static {
		dao.insert(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
		dao.insert(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		dao.insert(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
	}
	// FIN
	
	private TreeMap<Long, Video> videos = new TreeMap<>();

	@Override
	public List<Video> getAll() {
		return new ArrayList<Video>(videos.values());
	}

	@Override
	public Video getById(long id) {
		return videos.get(id);
	}

	@Override
	public void insert(Video objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Video objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
