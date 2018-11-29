package com.ipartek.formacion.ejercicios.examen.RestApi;

import java.util.List;

public interface RestAble<T> {

	public List<T> GetAll();

	public T GetById(Long id);
}
