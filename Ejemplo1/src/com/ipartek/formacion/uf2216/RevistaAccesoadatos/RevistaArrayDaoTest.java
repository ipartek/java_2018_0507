package com.ipartek.formacion.uf2216.RevistaAccesoadatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.RevistaPojo.Revista;



class RevistaArrayDaoTest {
	static Revista mock1,mock2;
	static final long MOCK1_ID = 1;
	static final String MOCK1_isbn = "12345678910";
	static final String MOCK1_TITULO = "Que Te Den";
	static final boolean MOCK1_siNo = true;
	static final int MOCK1_numPaginas = 2;
	private static RevistaArrayDao dao = null;
	static final long MOCK2_ID = 2;
	static final String MOCK2_CODIGO = "Aasdasdxg";
	static final String MOCK2_TITULO = "Easas";
	static final long ID_INEXISTENTE = 421;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = RevistaArrayDao.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao=null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mock1 = new Revista(2, "12aasasass", "sadsadsadasd",12,true);
		mock2 = new Revista(MOCK1_ID, "12aasasass", "sadsadsadasd",12,true);
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
	}

	@AfterEach
	void tearDown() throws Exception {
		dao.delete(MOCK1_ID);
		mock1 = null;
	}

	
	@Test
	void testGetInstance() {
		CrudAble<Revista> dao1 = RevistaArrayDao.getInstance();
		RevistaArrayDao dao2 = RevistaArrayDao.getInstance();
		assertNotNull(dao1);
		assertNotNull(dao2);
		assertTrue(dao1 == dao2);
	}
	
	@Test

	void testGetById() {
		Revista rev = dao.getById(1);
		assertNotNull(rev);
		assertEquals(mock2, rev);
		rev = dao.getById(ID_INEXISTENTE);
		assertNull(rev);
	}
	@Test
	void testGetAll() {
		List<Revista> revista = dao.getAll();
		assertNotNull(revista);
		assertEquals(4, revista.size());
	}
	@Test
	void testInsert() {
		int cuantosAntes = dao.getAll().size();

		Revista revistaInser = new Revista(3, "cazafantasmas","1212121212",5,true);

		assertTrue(dao.insert(revistaInser));

		int cuantosDespues = dao.getAll().size();

		assertEquals(cuantosAntes + 1, cuantosDespues);

		Revista recogido = dao.getById(3);

		assertEquals(recogido, revistaInser);

		assertTrue(!dao.insert(null));

		int cuantosDespuesNull = dao.getAll().size();

		assertEquals(cuantosDespues, cuantosDespuesNull);
	}


}
