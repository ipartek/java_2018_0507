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

	private static final int ID_INEXISTENTE = 1234;
	static VideoYoutube mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	static final String MOCK1_TITULO = "Que Te Den";

	static VideoYoutube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "AY4hgwdcvuaesjdPCxg";
	static final String MOCK2_TITULO = "En La Noche";

	private static final long MOCK_NUEVO_ID = 555;
	private static final String MOCK_NUEVO_CODIGO = "noexisteeninternet";
	private static final String MOCK_NUEVO_TITULO = "Video de prueba";

	private static VideoYoutubeArrayDAO dao = null;

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
		CrudAble<VideoYoutube> dao1 = VideoYoutubeArrayDAO.getInstance();
		VideoYoutubeArrayDAO dao2 = VideoYoutubeArrayDAO.getInstance();

		assertNotNull(dao1);
		assertNotNull(dao2);

		assertTrue(dao1 == dao2);
	}

	@Test
	void testGetAll() {
		List<VideoYoutube> videos = dao.getAll();

		assertNotNull(videos);
		assertEquals(2, videos.size());
		// assertEquals(MOCK1_ID, videos.get(0).getId());
	}

	@Test
	void testGetById() {
		VideoYoutube video = dao.getById(MOCK2_ID);

		assertNotNull(video);
		assertEquals(mock2, video);

		video = dao.getById(ID_INEXISTENTE);

		assertNull(video);
	}

	@Test
	void testInsert() {
		int cuantosAntes = dao.getAll().size();

		VideoYoutube videoInsertado = new VideoYoutube(MOCK_NUEVO_ID, MOCK_NUEVO_CODIGO, MOCK_NUEVO_TITULO);

		assertTrue(dao.insert(videoInsertado));

		int cuantosDespues = dao.getAll().size();

		assertEquals(cuantosAntes + 1, cuantosDespues);

		VideoYoutube recogido = dao.getById(MOCK_NUEVO_ID);

		assertEquals(recogido, videoInsertado);

		assertTrue(!dao.insert(null));

		int cuantosDespuesNull = dao.getAll().size();

		assertEquals(cuantosDespues, cuantosDespuesNull);
	}

	@Test
	void testUpdate() {
		assertFalse(dao.update(null));

		// Modificamos un Video que Existe
		VideoYoutube videoModificarConID = new VideoYoutube(MOCK1_ID, "El Fary", "fff");
		assertTrue(dao.update(videoModificarConID));
		// recuperar video y comprobar atributos
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("El Fary", videoModificado.getTitulo());
		assertEquals("fff", videoModificado.getCodigo());

		// Modificamos un Video que NO Existe
		VideoYoutube videoModificarSinID = new VideoYoutube(ID_INEXISTENTE, "Inexistente", "fff");
		assertFalse(dao.update(videoModificarSinID));
	}

	@Test
	void testDelete() {
		// eliminar video NO existente
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2, dao.getAll().size());

		// eliminar video existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size());
	}

}
