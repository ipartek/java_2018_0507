package com.ipartek.formacion.prestamolibros.pojo;

//TODO: Quitar el @SuppressWarnings("unused")
@SuppressWarnings("unused")
public class Libro {
	private long id;
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private String cliente;
	
	public Libro(long mock1Id, String mock1Titulo, String mock1Codigo, String mock1Editorial, String mock1Cliente) {
		
	id =mock1Id;
	isbn=mock1Titulo;
	titulo=mock1Codigo;
	editorial=mock1Editorial;
	cliente=mock1Cliente;
	}

	public boolean isLibre() {
		//TODO: implementar isLibre
		throw new RuntimeException("No implementado");
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getTitulo() {
		// TODO Auto-generated method stub
		return titulo;
	}

	public String getAutor() {
		// TODO Auto-generated method stub
		return autor;
	}

	public String getEditorial() {
		// TODO Auto-generated method stub
		return editorial;
	}

	public String getIsbn() {
		// TODO Auto-generated method stub
		return isbn;
	} 
}
