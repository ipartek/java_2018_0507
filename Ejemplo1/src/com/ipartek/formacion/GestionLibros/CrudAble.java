package com.ipartek.formacion.GestionLibros;

import java.util.List;

public interface CrudAble<P> {
	
	List<P> getAll();
	
	P getByID(long id);
	
	boolean insert(P pojo);
	boolean update(P pojo);
	boolean delete(P pojo);
	
}
