package com.ipartek.formacion.video.accesodatos;

import java.util.List;

//Create
//Retrieve
//Update
//Delete

public interface CrudAble<P> {

boolean insert(P pojo);
	
	/**
	 * recupera todos los pojos
	 * @return si no existen resultados retorna Lista vacia, no null
	 */
	List<P> getAll();
		
	/**
	 * Buscamos un Pojo por su identificador
	 * @param id long identificador
	 * @return P pojo si lo encuentra, null si no encuentra
	 */
	P getById(long id);
	
	
	boolean update(P pojo);
	
	boolean delete(long id);
}
