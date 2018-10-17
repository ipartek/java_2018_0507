package com.ipartek.formacion.ejemplos.perros.accesodatos;

import java.util.List;

public interface CrudAble<T> {
	public List<T> getAll();
	public int insert(T tipo);
	public int update(T tipo);
	public int delete(Long id);
}
