package com.ipartek.formacion.supermercado.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.supermercado.pojo.Identificable;



public class MapDAO<T> implements CrudAble<T>{
	//Long porque le paso el id
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
		if(pojos.containsKey(((Identificable)pojo).getId())) {
			return false;
		}
		pojos.put(((Identificable) pojo).getId(), pojo);
		return true;
	}

	@Override
	public boolean update(T pojo) {
		if(!pojos.containsKey(((Identificable) pojo).getId())) {
			return false;
		}
		pojos.put(((Identificable) pojo).getId(), pojo);
		return true;
	}

	
	//Porque no usa aqui el identificable
	@Override
	public boolean delete(long id) {
		if(!pojos.containsKey(id)) {
			return false;
		}
		pojos.remove(id);
		return true;
	}
	

}
