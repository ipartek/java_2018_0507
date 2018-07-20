package com.ipartek.formacion.prestamolibros.accesoDatos;

import java.util.List;

import com.ipartek.formacion.uf2216.accesoDatos.CrudAble;

public interface CrudAbleLibro<P> extends CrudAble<P> {

	/**
	 * Buscamos un libro por su isbn
	 * @param isbn string identificador
	 * @return P pojo si no lo encuentra, null si no encuentra
	 * */
	P getByIsbn(String isbn);
	
	/**
	 * Buscamos libros prestados o No prestados
	 * @param boolean isPrestado
	 * @return lista libros
	 * */
	List<P> getAllPrestados(boolean isPrestado);
	
	/**
	 * Buscamos Libros que coincida el titulo, es ignoreCase, nos sirve cualquier coincidencia no tiene porque ser el titulo exacto
	 * @param busqueda String termino a buscar
	 * @return listado de Libros que coincidan con la 'busqueda'
	 */
	List<P> getByTitulo(String busqueda);
}
