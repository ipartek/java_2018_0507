package com.ipartek.formacion.uf2216.RevistaAccesoadatos;

import java.util.List;

public interface CrudAble<P> {
	List<P> getAll();	
	P getById(long id);
	boolean insert(P pojo);
	boolean update(P pojo);
	boolean delete(long id);
}
