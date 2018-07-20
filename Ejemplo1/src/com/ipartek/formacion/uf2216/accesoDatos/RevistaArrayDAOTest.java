package com.ipartek.formacion.uf2216.accesoDatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.pojo.Revista;

class RevistaArrayDAOTest {
	
	private static RevistaArrayDAO dao = null;
	
	private static Revista mock1;
	private static final long MOCK1_ID = 1;
	private static final String MOCK1_ISBN = "1234567890";
	private static final String MOCK1_TITULO = "revista";
	private static final int MOCK1_PAGINAS = 2;
	private static final boolean MOCK1_FORMATO = false;
	
	private static Revista mock2;
	private static final long MOCK2_ID = 2;
	private static final String MOCK2_ISBN = "0123456789";
	private static final String MOCK2_TITULO = "revista2";
	private static final int MOCK2_PAGINAS = 3;
	private static final boolean MOCK2_FORMATO = true;
	
	private static final long ID_INEXISTENTE = -1;
	private static final String ISBN_INEXISTENTE = "1111111111";

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
		mock1 = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_PAGINAS, MOCK1_FORMATO);
		mock2 = new Revista(MOCK2_ID, MOCK2_TITULO, MOCK2_ISBN, MOCK2_PAGINAS, MOCK2_FORMATO);
		
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
		// El metodo getInstance crea un objeto singleton y tenemos que comprobar
		// que al crear 2 objetos, son el mismo.
		RevistaArrayDAO dao1 = RevistaArrayDAO.getInstance();
		RevistaArrayDAO dao2 = RevistaArrayDAO.getInstance();
		
		// Comprueba que dao1 y dao 2 no es null
		assertNotNull(dao1);
		assertNotNull(dao2);
		// Comprueba que dao1 es el mismo objeto que dao2
		assertTrue(dao1 == dao2);
	}
	
	@Test
	void testGetAll() {
		List<Revista> revistas = dao.getAll();
		// Comprobar que la lista no sea nulls
		assertNotNull(revistas);
		// Comprobar que la lista tenga 2 elementos.
		assertEquals(2, revistas.size());
		// Comprobar que el "MOCK1_ID" sea el primer id de la lista
		assertEquals(MOCK1_ID, revistas.get(0).getId());
	}
	
	@Test
	void testGetById() {
		Revista revista = dao.getById(MOCK2_ID);
		
		// Comprueba que la revista con el id "MOCK2_ID" existe
		assertNotNull(revista);
		// Comprueba que la revista mock2 es igual a "MOCK2_ID"
		assertEquals(mock2, revista);
		
		// Comprueba que acceder a Revista.getById y pasarle 
		// un id inexistente devuelve null
		revista = dao.getById(ID_INEXISTENTE);
		assertNull(revista);
	}
	
	@Test
	void testInsert() {
		int totalRevistas = dao.getAll().size();
		
		// Comprueba que insertar un valor falso es nulo
		assertFalse(dao.insert(null));
		// Comprueba que el total de revistas es igual al total de la lista
		assertEquals(totalRevistas, dao.getAll().size());
		
		// Comprueba que se puede insertar un valor correcto
		assertTrue(dao.insert(mock1));
		// Comprueba que el total de revistas es igual al total de la lista
		assertEquals(totalRevistas + 1, dao.getAll().size());	
	}
	
	@Test
	void testUpdate() {
		// Comprueba que al hacer update con valor null da falso
		assertFalse(dao.update(null));
		
		// Comprueba que al modificar un valor verdadero da true
		Revista revistaModificarConID = new Revista();
		try {
			revistaModificarConID = new Revista(MOCK1_ID, "Revista test", "1234567895", 2,false);
		} catch (Exception e) {
			System.out.println("Error al intentar crear una revista de prueba en la funcion testUpdate");
		}
		assertTrue(dao.update(revistaModificarConID));
		
		// Recuperar revista y comprobar atributos
		Revista revistaModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, revistaModificado.getId());
		assertEquals("1234567895", revistaModificado.getIsbn());
		assertEquals("Revista test", revistaModificado.getTitulo());
		
		// Modificamos una revista que NO Existe		
		Revista revistaModificarSinID = new Revista();
		try {
			revistaModificarSinID = new Revista(ID_INEXISTENTE, "Inexistente", "1234567890", 1, false);
		} catch (Exception e) {
			System.out.println("Error al intentar crear una revista inexistente");
		}
		assertFalse(dao.update(revistaModificarSinID));
	}


	@Test
	void testDelete() {
		// Comprueba que la revista falsa no se borra
		assertFalse(dao.delete(ID_INEXISTENTE));
		// Comprueba que el tamaño de la lista es 2
		assertEquals(2, dao.getAll().size());		
		
		// Comprueba que se puede borrar una revista existente
		assertTrue(dao.delete(MOCK2_ID));
		// Comprueba que el tamaño de la lista es 1
		assertEquals(1, dao.getAll().size());
	}
	
	@Test
	void testGetByIsbn() {
		Revista revista = dao.getByIsbn(MOCK1_ISBN);
		
		assertNotNull(revista);
		
		assertEquals(mock1, revista);
		
		revista = dao.getByIsbn(ISBN_INEXISTENTE);
		assertNull(revista);
	}
	
	@Test
	void testGetAllByFormatos() {
		List <Revista> revistas = dao.getAllByFormatos(MOCK1_FORMATO);
		
		assertNotNull(revistas);
	}

}
