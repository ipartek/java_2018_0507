package com.ipartek.formacion.video.accesodatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.video.pojo.VideoYoutube;

class VideoYoutubeArrayDAOTest {

	private static VideoYoutubeArrayDAO dao = null;
	
	private static VideoYoutube mock1;
	private static final long MOCK1_ID = 325;
	private static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	private static final String MOCK1_TITULO = "Que Te Den";
	
	private static VideoYoutube mock2;
	private static final long MOCK2_ID = 421;
	private static final String MOCK2_CODIGO = "AY4hgwdcvuaesjdPCxg";
	private static final String MOCK2_TITULO = "En La Noche";
	
	private static final long ID_INEXISTENTE = -1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = VideoYoutubeArrayDAO.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO);
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO);
		
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2)); 
	}

	@AfterEach
	void tearDown() throws Exception {
		dao.delete(MOCK1_ID);
		dao.delete(MOCK2_ID);
		
		mock1 = null;
		mock2 = null;
	}

	@Test
	void testGetInstance() {
		// El metodo getInstance crea un objeto singleton y tenemos que comprobar
		// que al crear 2 objetos, son el mismo.
		VideoYoutubeArrayDAO dao1 = VideoYoutubeArrayDAO.getInstance();
		VideoYoutubeArrayDAO dao2 = VideoYoutubeArrayDAO.getInstance();
		
		// Comprueba que dao1 y dao 2 no es null
		assertNotNull(dao1);
		assertNotNull(dao2);
		// Comprueba que dao1 es el mismo objeto que dao2
		assertTrue(dao1 == dao2);
	}

	@Test
	void testGetAll() {
		List<VideoYoutube> videos = dao.getAll();
		// Comprobar que la lista no sea nulls
		assertNotNull(videos);
		// Comprobar que la lista tenga 2 elementos.
		assertEquals(2, videos.size());
		// Comprobar que el "MOCK1_ID" sea el primer id de la lista
		assertEquals(MOCK1_ID, videos.get(0).getId());
	}

	@Test
	void testGetById() {
		VideoYoutube video = dao.getById(MOCK2_ID);
		
		// Comprueba que el video con el id "MOCK2_ID" existe
		assertNotNull(video);
		// Comprueba que el video mock2 es igual a "MOCK2_ID"
		assertEquals(mock2, video);
		
		// Comprueba que acceder a VideoYoutube.getById y pasarle 
		// un id inexistente devuelve null
		video = dao.getById(ID_INEXISTENTE);
		assertNull(video);
	}

	@Test
	void testInsert() {
		int totalVideos = dao.getAll().size();
		
		// Comprueba que insertar un valor falso es nulo
		assertFalse(dao.insert(null));
		// Comprueba que el total de videos es igual al total de la lista
		assertEquals(totalVideos, dao.getAll().size());
		
		// Comprueba que se puede insertar un valor correcto
		assertTrue(dao.insert(mock1));
		// Comprueba que el total de videos es igual al total de la lista
		assertEquals(totalVideos + 1, dao.getAll().size());	
	}

	@Test
	void testUpdate() {
		// Comprueba que al hacer update con valor null da falso
		assertFalse(dao.update(null));
		
		// Comprueba que al modificar un valor verdadero da true
		VideoYoutube videoModificarConID = new VideoYoutube(MOCK1_ID, "El Fary", "fff");
		assertTrue(dao.update(videoModificarConID));
		
		// Recuperar video y comprobar atributos
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("fff", videoModificado.getTitulo());
		assertEquals("El Fary", videoModificado.getCodigo());
		
		// Modificamos un Video que NO Existe		
		VideoYoutube videoModificarSinID = new VideoYoutube(ID_INEXISTENTE, "Inexistente", "fff");
		assertFalse(dao.update(videoModificarSinID));
	}

	@Test
	void testDelete() {
		// Comprueba que el video falso no se borra
		assertFalse(dao.delete(ID_INEXISTENTE));
		// Comprueba que el tamaño de la lista es 1
		assertEquals(2, dao.getAll().size());		
		
		// Comprueba que se puede borrar un video existente
		assertTrue(dao.delete(MOCK2_ID));
		// Comprueba que el tamaño de la lista es 1
		assertEquals(1, dao.getAll().size());
	}

}
