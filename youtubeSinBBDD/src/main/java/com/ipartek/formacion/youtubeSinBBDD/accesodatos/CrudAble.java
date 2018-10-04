package com.ipartek.formacion.youtubeSinBBDD.accesodatos;

import java.util.List;

public interface CrudAble<T> {
	public List<T> getAll();
	public T getById(long id);
	public void insert(T objeto);
	public void update(T objeto);
	public void delete(long id);
}
