package com.ipartek.formacion.video.pojo;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoYoutubeTest {

	private static VideoYoutube mock;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 mock = new VideoYoutube(1, "mockcodigo", "mocktitulo"); 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		mock = null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void equalsTest() {
		VideoYoutube video = new VideoYoutube(1, "mockcodigo", "mocktitulo");
		
		assertTrue(video.equals(mock));
	}

}
