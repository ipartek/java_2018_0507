package com.ipartek.formacion.uf2216rec.pojo;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovilesTest {

	private static Moviles mock;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 mock = new Moviles(false, "mockmarca", 0.00, 0.00, 0); 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		mock = null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void equalsTest() {
		Moviles movil = new Moviles(false, "mockmarca", 0.00, 0.00, 0);
		
		assertTrue(movil.equals(mock));
	}

}