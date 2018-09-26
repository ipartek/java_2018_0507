package com.ipartek.formacion.javaee.libro.accesodatos;

import java.util.List;

//Create, Retrieve, Update, Delete
public interface CrudAble<P> {
	//Retrieve
	
	/**
	 * Recupera todos los pojos
	 * @return si no existen resultados retorna Lista vacia, no null
	 */
	List<P> getAll();
	
	/**
	 * Buscamos un Pojo por su identificador
	 * @param id long identificador
	 * @return P pojo si lo encuentra, null si no encuentra
	 */
	P getById(long id);
	
	//Create
	boolean insert(P pojo);
	//Update
	boolean update(P pojo);
	//Delete
	boolean delete(long id);
}
