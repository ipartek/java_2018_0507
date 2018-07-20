package com.ipartek.formacion.uf2216.accesodatos;

import java.util.List;

public interface CrudAble<R> {

	
	List<R> getAll();
	

	R getById(long id);
	
	
	/**
	 * insertar revistas
	 * actualizar o modificar revistas
	 * borrar revistas
	 * @param pojo
	 * @return
	 */
	boolean insert(R pojo);
	
	boolean update(R pojo);

	boolean delete(long id);
}

	/** 
	 * @param pojo
	 * @return
	 * si no encuentra la revista devuelve false
	 */
	

