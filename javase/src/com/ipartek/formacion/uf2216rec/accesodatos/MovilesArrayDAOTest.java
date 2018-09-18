package com.ipartek.formacion.uf2216rec.accesodatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216rec.pojo.Moviles;
import com.ipartek.formacion.video.accesodatos.CrudAble;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

class MovilesArrayDAOTest {

	static Moviles mock1;
	static final boolean MOCK1_ANDROID = true;
	static final String MOCK1_MARCA = "xsagvBYUGCTUGvfcTF76";
	static final double MOCK1_RAM = 4784575.25;
	static final double MOCK1_PULGADAS = 87.26535;
	static final int MOCK1_MEMORIA = 87454245;
	
	static Moviles mock2;
	static final boolean MOCK2_ANDROID = false;
	static final String MOCK2_MARCA = "xsagvBYUGCTUGvfcTF76";
	static final double MOCK2_RAM = 754875.25;
	static final double MOCK2_PULGADAS = 2542.6535;
	static final int MOCK2_MEMORIA = 65326545;
	
	static Moviles mock;
	static final boolean MOCK_NUEVO_ANDROID = false;
	static final String MOCK_NUEVO_MARCA = "xsadfsfafcTF76";
	static final double MOCK_NUEVO_RAM = 56464875.25;
	static final double MOCK_NUEVO_PULGADAS = 3332.6535;
	static final int MOCK_NUEVO_MEMORIA = 332125;
	
	private static MovilesArrayDAO dao = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = MovilesArrayDAO.getInstace();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new Moviles(MOCK1_ANDROID, MOCK1_MARCA, MOCK1_RAM, MOCK1_PULGADAS, MOCK2_MEMORIA);
		mock2 = new Moviles(MOCK2_ANDROID, MOCK2_MARCA, MOCK2_RAM, MOCK2_PULGADAS, MOCK2_MEMORIA);
	
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
	}


	@Test
	final void testGetAll() {
		List<Moviles> moviles = dao.getAll();
		
		assertNotNull(moviles);
		//assertEquals(2. moviles.get(MOCK1_MEMORIA));
	}


	@Test
	final void testInsert() {
		int cuantosAntes = dao.getAll().size();
		Moviles movilInsertado = new Moviles(MOCK_NUEVO_ANDROID, MOCK_NUEVO_MARCA, MOCK_NUEVO_RAM, MOCK_NUEVO_PULGADAS, MOCK_NUEVO_MEMORIA);
		
		assertTrue(dao.insert(movilInsertado));
		
		int cuantosDespues = dao.getAll().size();
		
		assertEquals(cuantosAntes + 1, cuantosDespues);
		
		assertTrue(!dao.insert(null));
		
		int cuantosDespuesNull = dao.getAll().size();

		assertEquals(cuantosDespues, cuantosDespuesNull);
		
	}


}
