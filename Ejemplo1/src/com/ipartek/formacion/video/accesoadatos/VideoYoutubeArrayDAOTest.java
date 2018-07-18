package com.ipartek.formacion.video.accesoadatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.video.pojo.VideoYoutube;

class VideoYoutubeArrayDAOTest {

	private static final String MOCK1_CODIGO = "asasas";
	private static final String MOCK1_TITULO = "que te den";
	private static final long MOCK1_ID = 10;
	private static final String MOCK2_CODIGO = "asasas";
	private static final String MOCK2_TITULO = "en la noche";
	private static final long MOCK2_ID =20;
	private static final long MOCK_NUEVOID = 2;
	private static final String MOCK_NUEVO_CODIGO = "5555";
	private static final String MOCK_NUEVO_TITULO = "ASAS";
	private static VideoYoutubeArrayDAO dao;
	 static VideoYoutube mock1;
	 static VideoYoutube mock2;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao=VideoYoutubeArrayDAO.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao=null;
	}

	

	@BeforeEach
	void setUp() throws Exception {
		mock1=new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO);
		mock2=new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO);
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
	}

	@AfterEach
	void tearDown() throws Exception {
		dao.delete(MOCK1_ID);
		dao.delete(MOCK2_ID);
		mock1=null;
		mock2=null;
		
	}

	@Test
	void testGetInstance() {
		CrudAble<VideoYoutube> dao1=VideoYoutubeArrayDAO.getInstance();
		VideoYoutubeArrayDAO dao2=VideoYoutubeArrayDAO.getInstance();
		assertNotNull(dao1);
		assertNotNull(dao2);
		assertTrue(dao1==dao2);
	}

	@Test
	void testGetAll() {
		List<VideoYoutube> video = dao.getAll();
		assertNotNull(video);
		assertEquals(2,video.size());
		//assertEquals(MOCK1_ID, video.get(0).getId());
	}

	@Test
	void testGetById() {
		VideoYoutube video=dao.getById(MOCK2_ID);
		
		assertNotNull(video);
		assertEquals(mock2, video);
		video=dao.getById(1234);
		assertNull(video);
	}

	@Test
	void testInsert() {
		int cuantosAntes=dao.getAll().size();
		VideoYoutube insertado = new VideoYoutube(MOCK_NUEVOID, MOCK_NUEVO_CODIGO, MOCK_NUEVO_TITULO);
		assertTrue(dao.insert(insertado));
	   VideoYoutube  recogido=dao.getById(MOCK_NUEVOID);
	   assertEquals(recogido, insertado);
	   int cuantosDespues=dao.getAll().size();
	   assertEquals(cuantosAntes+1, cuantosDespues);
	   
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		//assertTrue(MOCK1_ID);
	}

}
