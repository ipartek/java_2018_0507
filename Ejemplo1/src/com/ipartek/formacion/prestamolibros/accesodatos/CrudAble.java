package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Libro;

//Create, Retrieve, Update, Delete
public interface CrudAble<P> {
	//Retrieve
	
	/**
	 * Recupera todos los pojos
	 * @return si no existen resultados retorna Lista vacia, no null
	 */
	List<Libro> getAll();
	
	/**
	 * Buscamos un Pojo por su identificador
	 * @param id long identificador
	 * @return P pojo si lo encuentra, null si no encuentra
	 */
	Libro getById(long id);
	
	//Create
	boolean insert(P pojo);
	//Update
	boolean update(P pojo);
	//Delete
	boolean delete(long id);
}
