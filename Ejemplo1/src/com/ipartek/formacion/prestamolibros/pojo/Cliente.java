package com.ipartek.formacion.prestamolibros.pojo;

import java.util.List;

public class Cliente {
	private long id;
	private String dni; //TODO: private Dni dni;
	private String nombre;
	private String apellidos;
	private List<Libro> librosPrestados;
}
