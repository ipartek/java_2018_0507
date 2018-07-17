package com.ipartek.formacion.video.accesoDatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.video.pojo.VideoYoutube;

class VideoYoutubeDAOTEST {

	static VideoYoutubeArrayDAO dao;
	
	static final long ID_INEXISTENTE = -1;
	
	static VideoYoutube mock1;	
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	static final String MOCK1_TITULO = "Que Te Den";
	
	static VideoYoutube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "AY4hgwdcvuaesjdPCxg";
	
	static final String MOCK_NUEVO_TITULO = "mIAU";
	static final long MOCK_NUEVO_ID = 433;
	static final String MOCK_NUEVO_CODIGO = "gATITO";
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAll() {
		List<VideoYoutube> videos = dao.getAll();
	}

	@Test
	void testGeById() {
		VideoYoutube video = dao.geById(MOCK2_ID);
		
		assertNotNull(video);
		assertEquals(mock2,video);
		
		
	}

	@Test
	void testInsert() {
	/*	//dao.insert(new VideoYoutube(MOCK_NUEVO_ID, MOCK_NUEVO_CODIGO, MOCK_NUEVO_TITULO));
		int cuantosAntes = dao.getAll().size();
		VideoYoutube videoInsertado = new VideoYoutube(MOCK_NUEVO_ID, MOCK_NUEVO_CODIGO, MOCK_NUEVO_TITULO);
		dao.insert(videoInsertado);
		
		assertEquals(cuantosAntes + 1,  cuantosDespues);
		VideoYoutube recogido = dao.getById(MOCK_NUEVO_ID);
		assertEquals(recogido, videoInsertado);
		assertTrue(!dao.insert(null));
		int cuantosDespues_Null = dao.getAll().size();*/
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		//eliminar video NO existente
		assertFalse( dao.delete( ID_INEXISTENTE ));
		assertEquals( 2, dao.getAll().size() );		
		
		//eliminar video existente
		assertTrue( dao.delete(MOCK2_ID));
assertEquals( 1, dao.getAll().size() );
	}

}
