package com.ipartek.formacion.uf2216.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.pojo.*;
/**
 * @class RevistaTest 
 * @author AnaMAMM
 *
 */
class RevistaTest {

	private static final int ID_INEXISTENTE = 1234;
	
	
	static Revista mock1;
	
	static final String MOCK1_TITULO = "Blaaa";
	static final String MOCK1_ISBN = "4483920987";
	static final int MOCK1_PAGINAS = 2;
	static final Boolean DIGITAL = true;
	static final int MOCK1_ID = 325;
	

	static Revista mock2;
	
	
	static final String MOCK2_TITULO = "ajaaa";
	static final String MOCK2_ISBN = "36473";
	static final int MOCK2_PAGINAS = 1;
	static final Boolean DIGITAL2 = false;
	static final int MOCK2_ID = 421;


	
	private static final String MOCK_NUEVO_TITULO = "pruebaa";
	private static final String MOCK_NUEVO_ISBN = "1234567891";
	static final int MOCK2_NUEVO_PAGINAS = 1;
	static final Boolean NUEVO_DIGITAL = true;
	private static final int MOCK_NUEVO_ID = 5;

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
		mock1 = new Revista(MOCK1_TITULO, MOCK1_ISBN, MOCK1_PAGINAS,DIGITAL, MOCK1_ID);
		mock2 = new Revista(MOCK2_TITULO,MOCK2_ISBN ,MOCK2_PAGINAS,DIGITAL2,MOCK2_ID);

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

		Revista revistaInsertada = new Revista(MOCK_NUEVO_TITULO, MOCK_NUEVO_ISBN, MOCK2_NUEVO_PAGINAS,NUEVO_DIGITAL,MOCK_NUEVO_ID);

		assertTrue(dao.insert(revistaInsertada));

		int cuantosDespues = dao.getAll().size();

		assertEquals(cuantosAntes + 1, cuantosDespues);

		Revista recogido = dao.getById(MOCK_NUEVO_ID);

		assertEquals(recogido, revistaInsertada);

		assertTrue(!dao.insert(null));

		int cuantosDespuesNull = dao.getAll().size();

		assertEquals(cuantosDespues, cuantosDespuesNull);
	}

	@Test
	void testUpdate() {
		assertFalse(dao.update(null));

		// Modificamos una revista que Existe
		Revista revistaModificarConID = new Revista(MOCK1_TITULO,"4483920988", 3, true, 7);
		assertTrue(dao.update(revistaModificarConID));
		// recuperar video y comprobar atributos
		Revista revistaModificada = dao.getById(MOCK1_ID);
		assertEquals("tituloooo", revistaModificada.getTitulo());
		assertEquals("4483920988", revistaModificada.getIsbn());
		assertEquals(3, revistaModificada.getPaginas());
		assertEquals(3, revistaModificada.isDigital());
		assertEquals(3, revistaModificada.getId());
		// Modificamos una revista que NO Existe
		Revista revistaModificarSinID = new Revista("no hay", "weriksd", 0, false, ID_INEXISTENTE );
		assertFalse(dao.update(revistaModificarSinID));
	}

	@Test
	void testDelete() {
		// eliminar revista NO existente
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2, dao.getAll().size());

		// eliminar revista existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size());
	}

}

