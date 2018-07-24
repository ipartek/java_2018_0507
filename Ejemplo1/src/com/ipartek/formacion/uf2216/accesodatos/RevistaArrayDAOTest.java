//package com.ipartek.formacion.uf2216.accesodatos;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.ipartek.formacion.uf2216.pojo.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class RevistaArrayDAOTest {
//
//	private static final int ID_INEXISTENTE = 1234;
//	static Revista mock1;
//	static final long MOCK1_ID = 111;
//	static final String MOCK1_ISBN = "1111111111";
//	static final String MOCK1_TITULO = "Blablabla";
//	static final Integer MOCK1_PAGINAS = 100;
//	static final Boolean MOCK1_FORMATO = true;
//
//	static Revista mock2;
//	static final long MOCK2_ID = 222;
//	static final String MOCK2_ISBN = "222222";
//	static final String MOCK2_TITULO = "blublublu";
//	static final Integer MOCK2_PAGINAS = 50;
//	static final Boolean MOCK2_FORMATO = false;
//
//
//	private static RevistaArrayDAO dao = null;
//
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		dao = RevistaArrayDAO.getInstance();
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		dao = null;
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//		mock1 = new Revista(MOCK1_ID, MOCK1_ISBN, MOCK1_TITULO, MOCK1_PAGINAS, MOCK1_FORMATO);
//		mock2 = new Revista(MOCK2_ID, MOCK2_ISBN, MOCK2_TITULO, MOCK2_PAGINAS, MOCK2_FORMATO);
//
//		assertTrue(dao.insert(mock1));
//		assertTrue(dao.insert(mock2));
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		dao.delete(MOCK1_ID);
//		dao.delete(MOCK2_ID);
//
//		mock1 = null;
//		mock2 = null;
//	}
//
//	@Test
//	void testGetInstance() {
//		CrudAble<Revista> dao1 = RevistaArrayDAO.getInstance();
//		RevistaArrayDAO dao2 = RevistaArrayDAO.getInstance();
//
//		assertNotNull(dao1);
//		assertNotNull(dao2);
//
//		assertTrue(dao1 == dao2);
//	}
//
//	@Test
//	void testGetAll() {
//		List<Revista> revistas = dao.getAll();
//
//		assertNotNull(revistas);
//		assertEquals(2, revistas.size());
//		// assertEquals(MOCK1_ID, revista.get(0).getId());
//	}
//
//	@Test
//	void testGetById() {
//		Revista revista = dao.getById(MOCK2_ID);
//
//		assertNotNull(revista);
//		assertEquals(mock2, revista);
//
//		revista = dao.getById(ID_INEXISTENTE);
//
//		assertNull(revista);
//	}
//
//	@Test
//	void testInsert() {
//		int cuantosAntes = dao.getAll().size();
//
//		Revista revistaInsertado = new Revista(MOCK1_ID, MOCK1_ISBN, MOCK1_TITULO, MOCK1_PAGINAS, MOCK1_FORMATO);
//
//		assertTrue(dao.insert(revistaInsertado));
//
//		int cuantosDespues = dao.getAll().size();
//
//		assertEquals(cuantosAntes + 1, cuantosDespues);
//
//		Revista recogido = dao.getById(MOCK1_ID);
//
//		assertEquals(recogido, revistaInsertado);
//
//		assertTrue(!dao.insert(null));
//
//		int cuantosDespuesNull = dao.getAll().size();
//
//		assertEquals(cuantosDespues, cuantosDespuesNull);
//	}
//
//	@Test
//	void testUpdate() {
//		assertFalse(dao.update(null));
//
//		// Modificamos un Video que Existe
//		Revista revistaoModificarConID = new Revista(MOCK1_ID, "1234567890", "La odisea",123,false);
//		assertTrue(dao.update(mock1));
//		// recuperar revista y comprobar atributos
//		Revista revistaModificado = dao.getById(MOCK1_ID);
//		assertEquals(MOCK1_ID, revistaModificado.getId());
//		assertEquals("La odisea", revistaModificado.getTitulo());
//		assertEquals("1234567890", revistaModificado.getIsbn());
//
//		// Modificamos un Revista que NO Existe
//		Revista revistaModificarSinID = new Revista(ID_INEXISTENTE, "Inexistente", "Inexistente", 0, true);
//		assertFalse(dao.update(revistaModificarSinID));
//	}
//
//	@Test
//	void testDelete() {
//		// eliminar revista NO existente
//		assertFalse(dao.delete(ID_INEXISTENTE));
//		assertEquals(2, dao.getAll().size());
//
//		// eliminar revista existente
//		assertTrue(dao.delete(MOCK2_ID));
//		assertEquals(1, dao.getAll().size());
//	}
//
//}
//
