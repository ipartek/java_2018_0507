package com.ipartek.formacion.prestamolibros.pojo;

import java.util.List;

public class Cliente {
	private long id;
	private String dni; //TODO: private Dni dni; crear clase Dni, ahi se validaria si el dni es correcto
	private String nombre;
	private String apellidos;
	private List<Libro> librosPrestados; //un cliente puede tener varios libros
}
