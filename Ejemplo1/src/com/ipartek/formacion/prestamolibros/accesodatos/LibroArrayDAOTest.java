package com.ipartek.formacion.prestamolibros.accesodatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.prestamolibros.pojo.Libro;

class LibroArrayDAOTest {

	private static final int ID_INEXISTENTE = 1234;
	static Libro mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	static final String MOCK1_TITULO = "Que Te Den";
	static final String MOCK1_EDITORIAL="eDITORIAL";
	static final String MOCK1_CLIENTE="cLIENTE";

	static Libro mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "AY4hgwdcvuaesjdPCxg";
	static final String MOCK2_TITULO = "En La Noche";
	static final String MOCK2_EDITORIAL="eDITORIAL";
	static final String MOCK2_CLIENTE="cLIENTE";

	private static final long MOCK_NUEVO_ID = 555;
	private static final String MOCK_NUEVO_CODIGO = "noexisteeninternet";
	private static final String MOCK_NUEVO_TITULO = "Video de prueba";

	private static LibroArrayDAO dao = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = LibroArrayDAO.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new Libro(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO, MOCK1_EDITORIAL, MOCK1_CLIENTE);
		mock2 = new Libro(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO, MOCK2_EDITORIAL, MOCK2_CLIENTE);

		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
	}

	private void Libro() {
		// TODO Auto-generated method stub
		
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
		CrudAble<Libro> dao1 = LibroArrayDAO.getInstance();
		LibroArrayDAO dao2 = LibroArrayDAO.getInstance();

		assertNotNull(dao1);
		assertNotNull(dao2);

		assertTrue(dao1 == dao2);
	}

	@Test
	void testGetAll() {
		List<com.ipartek.formacion.prestamolibros.pojo.Libro> videos = dao.getAll();

		assertNotNull(videos);
		assertEquals(2, videos.size());
		// assertEquals(MOCK1_ID, videos.get(0).getId());
	}

	@Test
	void testGetById() {
		com.ipartek.formacion.prestamolibros.pojo.Libro libro = dao.getById(MOCK2_ID);

		assertNotNull(libro);
		assertEquals(mock2, libro);

		libro = dao.getById(ID_INEXISTENTE);

		assertNull(libro);
	}

	@Test
	void testInsert() {
		int cuantosAntes = dao.getAll().size();

		Libro libroInsertado = new Libro(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO, MOCK1_EDITORIAL, MOCK1_CLIENTE);

		assertTrue(dao.insert(libroInsertado));

		int cuantosDespues = dao.getAll().size();

		assertEquals(cuantosAntes + 1, cuantosDespues);

		com.ipartek.formacion.prestamolibros.pojo.Libro recogido = dao.getById(MOCK_NUEVO_ID);

		assertEquals(recogido, libroInsertado);

		assertTrue(!dao.insert(null));

		int cuantosDespuesNull = dao.getAll().size();

		assertEquals(cuantosDespues, cuantosDespuesNull);
	}

	@Test
	void testUpdate() {
		assertFalse(dao.update(null));

		// Modificamos un Video que Existe
		Libro libroModificarConID = new Libro(MOCK1_ID, "1", "qqq", "ttt", "ddd");
		assertTrue(dao.update(libroModificarConID));
		// recuperar video y comprobar atributos
		com.ipartek.formacion.prestamolibros.pojo.Libro libroModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, libroModificarConID.getId());
		assertEquals("El Fary", libroModificarConID.getTitulo());
		assertEquals("fff", libroModificarConID.getAutor());

		// Modificamos un Video que NO Existe
		Libro videoModificarSinID = new Libro(ID_INEXISTENTE, "Inexistente", "fff", "fff", "rr");
		assertFalse(dao.update(libroModificarConID));
	}

	@Test
	void testDelete() {
		// eliminar video NO existente
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2, dao.getAll().size());

		// eliminar video existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size());
	}

}
