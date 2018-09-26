package com.ipartek.formacion.examen.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.examen.accesodatos.CrudAble;


public class MapDAO<T> implements CrudAble<T>{
	private TreeMap<Long, T> pojos = new TreeMap<Long, T>();
	
	
	@Override
	public List<T> getAll() {
		return new ArrayList<T>(pojos.values());
	}

	@Override
	public T getById(long id) {
		return pojos.get(id);
	}

	@Override
	public boolean insert(T pojo) {
		if(pojos.containsKey(((Identificable)pojo).getId())) { //comparacion de ID's 
			return false;
		}
		pojos.put(((Identificable) pojo).getId(), pojo);
		return true;
	}

}
