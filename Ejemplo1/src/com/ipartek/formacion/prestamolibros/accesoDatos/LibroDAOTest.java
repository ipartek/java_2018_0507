package com.ipartek.formacion.prestamolibros.accesoDatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;

class LibroDAOTest {

	private static LibroDAO dao = null;
	
	private static final long ID_INEXISTENTE = -1;
	private static final String ISBN_INEXISTENTE = "-1";
	
	private static final List<Libro> MOCK_LISTA_LIBROS= new ArrayList<>();
	
	private static Libro mockLibro1;
	private static final long MOCKLIBRO1_ID = 123;
	private static final String MOCKLIBRO1_ISBN = "123456";
	private static final String MOCKLIBRO1_TITULO = "Juego de tronos";
	private static final String MOCKLIBRO1_AUTOR = "JRR";
	private static final String MOCKLIBRO1_EDITORIAL = "Anaya";
	
	private static Libro mockLibro2;
	private static final long MOCKLIBRO2_ID = 456;
	private static final String MOCKLIBRO2_ISBN = "7890";
	private static final String MOCKLIBRO2_TITULO = "Shogun";
	private static final String MOCKLIBRO2_AUTOR = "James Clavell";
	private static final String MOCKLIBRO2_EDITORIAL = "Plaza and Jones";
	
	private static Cliente mockCliente1;
	private static final long MOCKCLIENTE1_ID = 2;
	private static final String MOCKCLIENTE1_DNI = "123456789A";
	private static final String MOCKCLIENTE1_NOMBRE = "Antxon";
	private static final String MOCKCLIENTE1_APELLIDO = "Urrutia";
	
	private static Cliente mockCliente2;
	private static final long MOCKCLIENTE2_ID = 5;
	private static final String MOCKCLIENTE2_DNI = "123456789B";
	private static final String MOCKCLIENTE2_NOMBRE = "Joxepo";
	private static final String MOCKCLIENTE2_APELLIDO = "Martinez";
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = LibroDAO.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		mockCliente1 = new Cliente(
				MOCKCLIENTE1_ID, 
				MOCKCLIENTE1_DNI, 
				MOCKCLIENTE1_NOMBRE, 
				MOCKCLIENTE1_APELLIDO, 
				MOCK_LISTA_LIBROS);
		
		mockCliente2 = new Cliente(
				MOCKCLIENTE2_ID, 
				MOCKCLIENTE2_DNI, 
				MOCKCLIENTE2_NOMBRE, 
				MOCKCLIENTE2_APELLIDO, 
				MOCK_LISTA_LIBROS);
		
		mockLibro1 = new Libro(
				MOCKLIBRO1_ID, 
				MOCKLIBRO1_ISBN, 
				MOCKLIBRO1_TITULO, 
				MOCKLIBRO1_AUTOR, 
				MOCKLIBRO1_EDITORIAL, 
				mockCliente1);
		
		mockLibro2 = new Libro(
				MOCKLIBRO2_ID, 
				MOCKLIBRO2_ISBN, 
				MOCKLIBRO2_TITULO, 
				MOCKLIBRO2_AUTOR, 
				MOCKLIBRO2_EDITORIAL, 
				mockCliente2);
		
		//MOCK_LISTA_LIBROS.add(mockLibro1);
		//MOCK_LISTA_LIBROS.add(mockLibro2);
		
		assertTrue(dao.insert(mockLibro1));
		assertTrue(dao.insert(mockLibro2));
	}

	@AfterEach
	void tearDown() throws Exception {
		dao.delete(MOCKLIBRO1_ID);
		dao.delete(MOCKLIBRO2_ID);
		
		mockLibro1 = null;
		mockLibro2 = null;
	}

	@Test
	void testGetInstance() {
		LibroDAO dao1 = LibroDAO.getInstance();
		LibroDAO dao2 = LibroDAO.getInstance();
		
		assertNotNull(dao1);
		assertNotNull(dao2);
		
		assertTrue(dao1 == dao2);
	}
	
	@Test
	void testGetAll() {
		List<Libro> libros = dao.getAll();
		
		assertNotNull(libros);
		
		assertEquals(2, libros.size());
		
		assertEquals(MOCKLIBRO1_ID, libros.get(0).getId());
	}
	
	@Test
	void testGetById() {
		Libro libro = dao.getById(MOCKLIBRO1_ID);
		
		assertNotNull(libro);
		
		assertEquals(mockLibro1, libro);
		
		libro = dao.getById(ID_INEXISTENTE);
		assertNull(libro);
	}
	
	@Test
	void testGetByIsbn() {
		Libro libro = dao.getByIsbn(MOCKLIBRO1_ISBN);
		
		assertNotNull(libro);
		
		assertEquals(mockLibro1, libro);
		
		libro = dao.getByIsbn(ISBN_INEXISTENTE);
		assertNull(libro);
	}
	
	void testInsert() {
		int totalLibros = dao.getAll().size();
		
		assertFalse(dao.insert(null));
		
		assertEquals(totalLibros, dao.getAll().size());
		
		assertTrue(dao.insert(mockLibro1));
		
		assertEquals(totalLibros + 1, dao.getAll().size());	
	}

	@Test
	void testUpdate() {
		assertFalse(dao.update(null));
		
		Libro libroModificarConID = new Libro(
				MOCKLIBRO1_ID, 
				"456987", 
				"titulo ficticio", 
				"autor ficticio", 
				"editorial ficticia", 
				mockCliente1);
		
		assertTrue(dao.update(libroModificarConID));
		
		Libro libroModificado = dao.getById(MOCKLIBRO1_ID);
		assertEquals(MOCKLIBRO1_ID, libroModificado.getId());
		assertEquals("titulo ficticio", libroModificado.getTitulo());
		assertEquals("autor ficticio", libroModificado.getAutor());
			
		Libro libroModificarSinID = new Libro(
				ID_INEXISTENTE, 
				"ISBN inexistente",
				"Titulo inexistente", 
				"Autor inexistente",
				"editorial inexistente",
				mockCliente1);
		
		assertFalse(dao.update(libroModificarSinID));
	}

	@Test
	void testDelete() {
		
		assertFalse(dao.delete(ID_INEXISTENTE));
		
		assertEquals(2, dao.getAll().size());		
	
		assertTrue(dao.delete(MOCKLIBRO2_ID));
		
		assertEquals(1, dao.getAll().size());
	}

}
