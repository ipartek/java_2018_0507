package com.ipartek.formacion.libro.accesodatos;
//package com.ipartek.formacion.prestamolibros.accesodatos;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.ipartek.formacion.prestamolibros.pojo.Libro;
//import com.ipartek.formacion.video.pojo.VideoYoutube;
//
//class LibroArrayDAOTest {
//
//	private static final int ID_INEXISTENTE = 1234;
//	static Libro mock1;
//	static final long MOCK1_ID = 325;
//	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
//	static final String MOCK1_TITULO = "Que Te Den";
//
//	static Libro mock2;
//	static final long MOCK2_ID = 421;
//	static final String MOCK2_CODIGO = "AY4hgwdcvuaesjdPCxg";
//	static final String MOCK2_TITULO = "En La Noche";
//
//	private static final long MOCK_NUEVO_ID = 555;
//	private static final String MOCK_NUEVO_CODIGO = "noexisteeninternet";
//	private static final String MOCK_NUEVO_TITULO = "Video de prueba";
//
//	private static LibroArrayDAO dao = null;
//
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		dao = LibroArrayDAO.getInstance();
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		dao = null;
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//		mock1 = new Libro(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO);
//		mock2 = new Libro(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO);
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
//		CrudAble<Libro> dao1 = LibroArrayDAO.getInstance();
//		LibroArrayDAO dao2 = LibroArrayDAO.getInstance();
//
//		assertNotNull(dao1);
//		assertNotNull(dao2);
//
//		assertTrue(dao1 == dao2);
//	}
//
//	@Test
//	void testGetAll() {
//		List<Libro> videos = dao.getAll();
//
//		assertNotNull(libros);
//		assertEquals(2, libros.size());
//		// assertEquals(MOCK1_ID, videos.get(0).getId());
//	}
//
//	@Test
//	void testGetById() {
//		Libro libro = dao.getById(MOCK2_ID);
//
//		assertNotNull(libro);
//		assertEquals(mock2, libro);
//
//		libro = dao.getById(ID_INEXISTENTE);
//
//		assertNull(libro);
//	}
//
//	@Test
//	void testInsert() {
//		int cuantosAntes = dao.getAll().size();
//
//		Libro libroInsertado = new Libro(MOCK_NUEVO_ID, MOCK_NUEVO_CODIGO, MOCK_NUEVO_TITULO);
//
//		assertTrue(dao.insert(libroInsertado));
//
//		int cuantosDespues = dao.getAll().size();
//
//		assertEquals(cuantosAntes + 1, cuantosDespues);
//
//		Libro recogido = dao.getById(MOCK_NUEVO_ID);
//
//		assertEquals(recogido, libroInsertado);
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
//		Libro librooModificarConID = new Libro(MOCK1_ID, "fff", "El Fary");
//		assertTrue(dao.update(libroModificarConID));
//		// recuperar libro y comprobar atributos
//		VideoYoutube libroModificado = dao.getById(MOCK1_ID);
//		assertEquals(MOCK1_ID, libroModificado.getId());
//		assertEquals("El Fary", libroModificado.getTitulo());
//		assertEquals("fff", libroModificado.getCodigo());
//
//		// Modificamos un Libro que NO Existe
//		Libro libroModificarSinID = new Libro(ID_INEXISTENTE, "Inexistente", "fff");
//		assertFalse(dao.update(libroModificarSinID));
//	}
//
//	@Test
//	void testDelete() {
//		// eliminar libro NO existente
//		assertFalse(dao.delete(ID_INEXISTENTE));
//		assertEquals(2, dao.getAll().size());
//
//		// eliminar libro existente
//		assertTrue(dao.delete(MOCK2_ID));
//		assertEquals(1, dao.getAll().size());
//	}
//
//}
