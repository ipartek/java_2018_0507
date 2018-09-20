package com.ipartek.formacion.javaee.supermercado.accesodatos;

import java.util.List;

public interface CrudAble<P> {

	List<P> getAll();

	P getById(long id);

	// Create
	boolean insert(P pojo);

	// Update
	boolean update(P pojo);

	// Delete
	boolean delete(long id);

}
