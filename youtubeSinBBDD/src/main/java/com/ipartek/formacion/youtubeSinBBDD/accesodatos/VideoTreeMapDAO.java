package com.ipartek.formacion.youtubeSinBBDD.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.youtubeSinBBDD.accesodatos.AccesoDatos;
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
		dao.insert(new Video("LPDhuthFD98", "Surf Search Spot"));
		dao.insert(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		dao.insert(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
	}
	// FIN
	
	private TreeMap<Long, Video> videos = new TreeMap<>();
	
	private Long idUltimo = 0L;

	@Override
	public List<Video> getAll() {
		return new ArrayList<Video>(videos.values());
	}

	@Override
	public Video getById(long id) {
		return videos.get(id);
	}

	@Override
	public void insert(Video video) {
		//ID AUTONUMERICO
				Long id = ++idUltimo;
				video.setId(id);

				videos.put(video.getId(), video);
	}

	@Override
	public void update(Video video) {
		if(!videos.containsKey(video.getId())) {
			throw new AccesoDatos("Id no existente");
		}
		videos.put(video.getId(), video);

	}

	@Override
	public void delete(long id) {
		if(!videos.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		videos.remove(id);

	}

}
