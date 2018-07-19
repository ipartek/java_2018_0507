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

class ClienteDAOTest {
	
	private static ClienteDAO dao = null;
	
	private static final long ID_INEXISTENTE = -1;
	private static final String DNI_INEXISTENTE = "-1";
	
	private static final List<Libro> MOCK_LISTA_LIBROS= new ArrayList<>();
	
	private static Libro mockLibro1;
	private static final long MOCKLIBRO1_ID = 123;
	private static final String MOCKLIBRO1_ISBN = "123456";
	private static final String MOCKLIBRO1_TITULO = "Juego de tronos";
	private static final String MOCKLIBRO1_AUTOR = "JRR";
	private static final String MOCKLIBRO1_EDITORIAL = "Anaya";
	private static final Boolean MOCKLIBRO1_PRESTADO = true;
	
	private static Libro mockLibro2;
	private static final long MOCKLIBRO2_ID = 456;
	private static final String MOCKLIBRO2_ISBN = "7890";
	private static final String MOCKLIBRO2_TITULO = "Shogun";
	private static final String MOCKLIBRO2_AUTOR = "James Clavell";
	private static final String MOCKLIBRO2_EDITORIAL = "Plaza and Jones";
	private static final Boolean MOCKLIBRO2_PRESTADO = true;
	
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
		dao = ClienteDAO.getInstance();
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
				MOCKLIBRO1_PRESTADO,
				mockCliente1);
		
		mockLibro2 = new Libro(
				MOCKLIBRO2_ID, 
				MOCKLIBRO2_ISBN, 
				MOCKLIBRO2_TITULO, 
				MOCKLIBRO2_AUTOR, 
				MOCKLIBRO2_EDITORIAL,
				MOCKLIBRO2_PRESTADO,
				mockCliente2);
		
		assertTrue(dao.insert(mockCliente1));
		assertTrue(dao.insert(mockCliente2));
	}

	@AfterEach
	void tearDown() throws Exception {
		dao.delete(MOCKCLIENTE1_ID);
		dao.delete(MOCKCLIENTE2_ID);
		
		mockCliente1 = null;
		mockCliente2 = null;
	}

	@Test
	void testGetInstance() {
		ClienteDAO dao1 = ClienteDAO.getInstance();
		ClienteDAO dao2 = ClienteDAO.getInstance();
		
		assertNotNull(dao1);
		assertNotNull(dao2);
		
		assertTrue(dao1 == dao2);
	}
	
	@Test
	void testGetAll() {
		List<Cliente> clientes = dao.getAll();
		
		assertNotNull(clientes);
		
		assertEquals(2, clientes.size());
		
		assertEquals(MOCKCLIENTE1_ID, clientes.get(0).getId());
	}
	
	@Test
	void testGetById() {
		Cliente cliente = dao.getById(MOCKCLIENTE1_ID);
		
		assertNotNull(cliente);
		
		assertEquals(mockCliente1, cliente);
		
		cliente = dao.getById(ID_INEXISTENTE);
		assertNull(cliente);
	}
	
	@Test
	void testGetByDni() {
		Cliente cliente = dao.getByDni(MOCKCLIENTE1_DNI);
		
		assertNotNull(cliente);
		
		assertEquals(mockCliente1, cliente);
		
		cliente = dao.getByDni(DNI_INEXISTENTE);
		assertNull(cliente);
	}
	
	void testInsert() {
		int totalClientes = dao.getAll().size();
		
		assertFalse(dao.insert(null));
		
		assertEquals(totalClientes, dao.getAll().size());
		
		assertTrue(dao.insert(mockCliente1));
		
		assertEquals(totalClientes + 1, dao.getAll().size());	
	}

	@Test
	void testUpdate() {
		assertFalse(dao.update(null));
		
		Cliente clienteModificarConID = new Cliente(
				MOCKCLIENTE1_ID, 
				"111222333A", 
				"nombre ficticio", 
				"apellido ficticio", 
				MOCK_LISTA_LIBROS);
		
		assertTrue(dao.update(clienteModificarConID));
		
		Cliente clienteModificado = dao.getById(MOCKCLIENTE1_ID);
		assertEquals(MOCKCLIENTE1_ID, clienteModificado.getId());
		assertEquals("nombre ficticio", clienteModificado.getNombre());
		assertEquals("111222333A", clienteModificado.getDni());
			
		Cliente clienteModificarSinID = new Cliente(
				ID_INEXISTENTE, 
				DNI_INEXISTENTE,
				"Nombre inexistente", 
				"Apellido inexistente",
				MOCK_LISTA_LIBROS);
		
		assertFalse(dao.update(clienteModificarSinID));
	}

	@Test
	void testDelete() {
		
		assertFalse(dao.delete(ID_INEXISTENTE));
		
		assertEquals(2, dao.getAll().size());		
	
		assertTrue(dao.delete(MOCKCLIENTE2_ID));
		
		assertEquals(1, dao.getAll().size());
	}


}
