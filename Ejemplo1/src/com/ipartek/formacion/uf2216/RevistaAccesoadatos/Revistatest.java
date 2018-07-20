package com.ipartek.formacion.uf2216.RevistaAccesoadatos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.RevistaPojo.Revista;

class Revistatest {
	static Revista rev=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		rev=new Revista(1, "hola", "121212112121", 2, true);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		rev=null;
	}

	@BeforeEach
	void setUp() throws Exception {
		rev=new Revista(1, "hola", "121212112121", 2, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		rev=null;
	}

	@Test
	void getId() {
		assertTrue(rev.getId()==1);

	}
	@Test
	void getNombre() {
		assertEquals(rev.getTitulo(), "hola");

	}
	@Test
	void getIsbn() {
		assertEquals(rev.getIsbn(), "121212112121");
		
	}
	void isDigi() {
		assertTrue(rev.isDigital());
		
	}
	
	

}
