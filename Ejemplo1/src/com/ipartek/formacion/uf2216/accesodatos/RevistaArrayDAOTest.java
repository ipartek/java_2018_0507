package com.ipartek.formacion.uf2216.accesodatos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.accesodatos.RevistasArrayDAO;
import com.ipartek.formacion.uf2216.pojo.Revista;
import com.ipartek.formacion.video.pojo.Revista;
import com.ipartek.formacion.video.pojo.Revista;

class RevistaArrayDAOTest {
	
	private static final int ID_INEXISTENTE = 1234;
	static Revista mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_TITULO = "revista";
	static final String MOCK1_ISBN = "1234567890";
	static final long MOCK1_NUMPAGINAS = 333;
	static final boolean MOCK1_FORMATO= true;

	static Revista mock2;
	static final long MOCK2_ID = 35;
	static final String MOCK2_TITULO = "revista2";
	static final String MOCK2_ISBN = "1234577890";
	static final long MOCK2_NUMPAGINAS = 666;
	static final boolean MOCK2_FORMATO= false;

	private static final long MOCK_NUEVO_ID = 555;
	private static final String MOCK_NUEVO_TITULO = "NEWLIBRO";
	static final String MOCK_NUEVO_ISBN = "1234567880";
	static final long MOCK_NUEVO_NUMPAGINAS = 223;
	static final boolean MOCK_NUEVO_FORMATO= true;
	
	private static RevistasArrayDAO dao = null;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = RevistasArrayDAO.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao= null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new RevistaArrayDAOTest(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUMPAGINAS, MOCK1_FORMATO);
		mock2 = new RevistaArrayDAOTest(MOCK2_ID, MOCK2_TITULO, MOCK2_ISBN, MOCK2_NUMPAGINAS, MOCK2_FORMATO);

		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2))
	}

	@AfterEach
	void tearDown() throws Exception {
		dao.delete(MOCK1_ID);
		dao.delete(MOCK2_ID);

		mock1 = null;
		mock2 = null;
	}

	void testGetById() {
		Revista revista = dao.getById(MOCK2_ID);

		assertNotNull(revista);
		assertEquals(mock2, revista);

		revista = dao.getById(ID_INEXISTENTE);

		assertNull(revista);
	}
	
	@Test
	void testInsert() {
		int cuantosAntes = dao.getAll().size();

		Revista revistaInsertada = new Revista(MOCK_NUEVO_ID, MOCK_NUEVO_TITULO, MOCK_NUEVO_ISBN, MOCK_NUEVO_NUMPAGINAS,MOCK_NUEVO_FORMATO);

		assertTrue(dao.insert(revistaInsertada));

		int cuantosDespues = dao.getAll().size();

		assertEquals(cuantosAntes + 1, cuantosDespues);

		Revista recogido = dao.getById(MOCK_NUEVO_ID);

		assertEquals(recogido, revistaInsertada);

		assertTrue(!dao.insert(null));

		int cuantosDespuesNull = dao.getAll().size();

		assertEquals(cuantosDespues, cuantosDespuesNull);
	}

}
