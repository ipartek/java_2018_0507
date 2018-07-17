package com.ipartek.formacion.video.accesoDatos;

import java.util.List;

//Create//Retrieve//Update//Delete

public interface CrudAble <P>{
	//Retrieve
	/**
	 * Recupera todos los pojos
	 * @return si no existen resultados retorna lista vacia, no null
	 */
	List<P> getAll();
	
	/**
	 * Buscamos un pojo por su identificador
	 * @param id long identificador
	 * @return P pojo si lo encuentra, null si no encuentra
	 */
	P geById(long id);
	
	//Create
	boolean insert(P pojo);
	//Update
	boolean update(P pojo);
	//Delete
	boolean delete(long id);
}
