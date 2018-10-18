package com.ipartek.formacion.ong.accesodatos;

import java.util.List;

public interface CrudAble<T> {
	
	List<T> getAll();
	
	T getById(long id);
	
	
	boolean insert(T perro);

}