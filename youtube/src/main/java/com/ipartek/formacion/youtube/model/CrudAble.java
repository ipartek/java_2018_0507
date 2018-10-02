package com.ipartek.formacion.youtube.model;

import java.util.List;


public interface CrudAble<P> {
	
	//Create
	boolean insert(P pojo);
	
	//Read
	/**
	 * Recupera todos los pojo
	 * @return si no existe resultados retorna Lista vacia, no null
	 */
	List<P> getAll();
	
	/**
	 * Buscamos un pojo por su identificador
	 * @param id
	 * @return VideoYoutube si lo encuentra, null si no lo encuentra
	 */
	P getById(String id);
	
	//Upadte
	boolean update(P pojo);
	
	//Delete
	boolean delete(String id);

}
