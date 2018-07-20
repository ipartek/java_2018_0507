package com.ipartek.formacion.uf2216.accesodatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.pojo.Revista;

class RevistaArrayDAOTest {

	private static final int ID_INEXISTENTE = 1234;
	static Revista mock1;
	static final String MOCK1_TITULO = "Caza";
	static final int MOCK1_ISBN = 1234567891;
	static final int MOCK1_NUMPAGINAS = 100;
	static final boolean MOCK1_FORMATO = false;
	static final int MOCK1_ID = 1;
	
	static Revista mock2;
	static final String MOCK2_TITULO = "Pesca";
	static final int MOCK2_ISBN = 2134567890;
	static final int MOCK2_NUMPAGINAS = 200;
	static final boolean MOCK2_FORMATO = true;
	static final int MOCK2_ID = 2;
	
	static Revista mock3;
	static final String MOCK_NUEVO_TITULO = "Tendencias";
	static final int MOCK_NUEVO_ISBN = 1231231234;
	static final int MOCK_NUEVO_NUMPAGINAS =450 ;
	static final boolean MOCK_NUEVO_FORMATO = true;
	static final int MOCK_NUEVO_ID = 3;
	
	private static RevistaArrayDAO dao = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		dao = RevistaArrayDAO.getInstance();
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}
	

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new Revista(MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUMPAGINAS, MOCK1_FORMATO, (int) MOCK1_ID);
		mock2 = new Revista(MOCK2_TITULO, MOCK2_ISBN, MOCK2_NUMPAGINAS, MOCK2_FORMATO, (int) MOCK2_ID);

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
		CrudAble<Revista> dao1 = (CrudAble<Revista>) RevistaArrayDAO.getInstance();
		RevistaArrayDAO dao2 = RevistaArrayDAO.getInstance();

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

		Revista revistaInsertada = new Revista(MOCK_NUEVO_TITULO, MOCK_NUEVO_ISBN, MOCK_NUEVO_NUMPAGINAS, MOCK_NUEVO_FORMATO, (int) MOCK_NUEVO_ID);

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

		Revista revistaModificarConID = new Revista("COCHES", 2111233213, 230,true,MOCK1_ID);
		
		assertTrue(dao.update(revistaModificarConID));
		Revista revistaModificada = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, revistaModificada.getId());
		assertEquals("PESCA2", revistaModificada.getTitulo());
		assertEquals(1234567891, revistaModificada.getIsbn());
		assertEquals(500, revistaModificada.getNumeroPaginas());

		
		Revista revistaModificarSinId = new Revista("FORBES", 1212152535, 150,true,ID_INEXISTENTE);
		assertFalse(dao.update(revistaModificarSinId));
	}
	@Test
	void testDelete() {
		
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2, dao.getAll().size());

	
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size());
	}

}