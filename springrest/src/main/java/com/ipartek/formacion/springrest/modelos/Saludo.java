package com.ipartek.formacion.springrest.modelos;

public class Saludo {
	private final long id;
    private final String contenido;

    public Saludo(long id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

	public long getId() {
		return id;
	}

	public String getContenido() {
		return contenido;
	}

	@Override
	public String toString() {
		return "Saludo [id=" + id + ", contenido=" + contenido + "]";
	}

}
