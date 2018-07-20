package com.ipartek.formacion.uf2216;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.Revista;

class RevistaArrayDAOTest {
//MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN,MOCK1_NPAGINAS,MOCK1_FORMATO
	private static final int ID_INEXISTENTE = 1234;
	static Revista mock1;
	static final int MOCK1_ID = 1;
	static final String MOCK1_TITULO = "la casa de bernarda alba";
	static final String MOCK1_ISBN = "152635478";
	static final int MOCK1_NPAGINAS = 500;
	static final boolean MOCK1_FORMATO = true;


	static Revista mock2;
	static final int MOCK2_ID = 2;
	static final String MOCK2_TITULO = "La hija del clerigo";
	static final String MOCK2_ISBN = "15484512";
	static final int MOCK2_NPAGINAS = 234;
	static final boolean MOCK2_FORMATO = false;
	
	private static final long MOCK_NUEVO_ID = 555;
	private static final String MOCK_NUEVO_TITULO = "Video de prueba";
	private static final String MOCK_NUEVO_ISBN = "15484512";
	private static final int MOCK_NUEVO_NPAGINAS = 234;
	private static final boolean MOCK_NUEVO_FORMATO = false;
	
	private static RevistaArrayDAO dao = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = RevistaArrayDAO.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN,MOCK1_NPAGINAS,MOCK1_FORMATO);
		mock2 = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK2_ISBN,MOCK2_NPAGINAS,MOCK2_FORMATO);

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
		CrudAble<Revista> dao1 = RevistaArrayDAO.getInstance();
		RevistaArrayDAO dao2 = RevistaArrayDAO.getInstance();

		assertNotNull(dao1);
		assertNotNull(dao2);

		assertTrue(dao1 == dao2);
	}

	@Test
	void testGetAll() {
		List<Revista> revista = dao.getAll();

		assertNotNull(revista);
		assertEquals(2, revista.size());
		// assertEquals(MOCK1_ID, videos.get(0).getId());
	}

	@Test
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

		Revista revistaInsertado = new Revista(MOCK_NUEVO_ID, MOCK_NUEVO_TITULO, MOCK_NUEVO_ISBN,MOCK_NUEVO_NPAGINAS,MOCK_NUEVO_FORMATO);

		assertTrue(dao.insert(revistaInsertado));

		int cuantosDespues = dao.getAll().size();

		assertEquals(cuantosAntes + 1, cuantosDespues);

		Revista recogido = dao.getById(MOCK_NUEVO_ID);

		assertEquals(recogido, revistaInsertado);

		assertTrue(!dao.insert(null));

		int cuantosDespuesNull = dao.getAll().size();

		assertEquals(cuantosDespues, cuantosDespuesNull);
	}
}
