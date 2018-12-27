package com.ipartek.formacion.incidencias.apirest;

import java.util.List;

public interface RestAble<T> {
	public List<T> getAll();

	public T getById(Long id);

	public Long add(T t);

	public void update(T t);

	public void delete(Long id);
}
