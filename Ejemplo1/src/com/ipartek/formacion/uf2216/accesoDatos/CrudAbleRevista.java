package com.ipartek.formacion.uf2216.accesoDatos;

import java.util.List;

import com.ipartek.formacion.uf2216.accesoDatos.CrudAble;

public interface CrudAbleRevista<P> extends CrudAble<P> {

	/**
	 * Buscamos una revista por su isbn
	 * @param isbn string identificador 10 caracteres
	 * @return P pojo si lo encuentra, null si no encuentra
	 * */
	P getByIsbn(String isbn);
	
	/**
	 * Buscamos revistas por formato 
	 * @param boolean isFormato
	 * @return lista libros
	 * */
	List<P> getAllByFormatos(boolean isFormato);
}
