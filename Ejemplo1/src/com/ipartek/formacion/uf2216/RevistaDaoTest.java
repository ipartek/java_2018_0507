package com.ipartek.formacion.uf2216;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.CrudAble;
import com.ipartek.formacion.uf2216.RevistaDao;


class RevistaDaoTest {
	private static final int ID_INEXISTENTE = 1234;
	static Revista mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_ISBN = "AY4QbN5PCxg";
	static final String MOCK1_TITULO = "Ojala no penque";
	static final long MOCK1_NPAGINAS = 123;
	static final boolean MOCK1_FORMATO = false;

	static Revista mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_ISBN = "AWRasd1231";
	static final String MOCK2_TITULO = "Ojala apruebe";
	static final long MOCK2_NPAGINAS = 231;
	static final boolean MOCK2_FORMATO = false;
	

	private static final long MOCK_NUEVO_ID = 555;
	private static final String MOCK_NUEVO_TITULO = "Revista de prueba";
	private static final String MOCK_NUEVO_ISBN = "lets have fun";
	private static final long MOCK_NUEVO_NPAGINAS = 321;
	private static final boolean MOCK_NUEVO_FORMATO = false;

	private static RevistaDao dao = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = RevistaDao.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN,MOCK1_NPAGINAS,MOCK1_FORMATO);
		mock2 = new Revista(MOCK2_ID, MOCK2_TITULO, MOCK2_ISBN,MOCK2_NPAGINAS,MOCK2_FORMATO);

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
		CrudAble<Revista> dao1 = RevistaDao.getInstance();
		RevistaDao dao2 = RevistaDao.getInstance();

		assertNotNull(dao1);
		assertNotNull(dao2);

		assertTrue(dao1 == dao2);
	}

	@Test
	void testGetAll() {
		List<Revista> revistas = dao.getAll();

		assertNotNull(revistas);
		assertEquals(2, revistas.size());
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

		Revista revistaInsertada = new Revista(MOCK_NUEVO_ID, MOCK_NUEVO_ISBN, MOCK_NUEVO_TITULO,MOCK_NUEVO_NPAGINAS,MOCK_NUEVO_FORMATO);

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
