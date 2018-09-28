package com.ipartek.formacion.javaee.supermercadojavier.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.javaee.supermercadojavier.pojo.Producto;

public class ProductoMapDAO implements CrudAble<Producto> {
	private TreeMap<Long, Producto> productos = new TreeMap<Long, Producto>();

	@Override
	public List<Producto> getAll() {
		return new ArrayList<Producto>(productos.values());
	}

	@Override
	public Producto getById(long id) {
		return productos.get(id);
	}

	@Override
	public boolean insert(Producto pojo) {
		if(productos.containsKey(pojo.getId())) {
			return false;
		}
		productos.put(pojo.getId(), pojo);
		return true;
	}

	@Override
	public boolean update(Producto pojo) {
		if(!productos.containsKey(pojo.getId())) {
			return false;
		}
		productos.put(pojo.getId(), pojo);
		return true;
	}

	@Override
	public boolean delete(long id) {
		if(!productos.containsKey(id)) {
			return false;
		}
		productos.remove(id);
		return true;
	}
	
}
