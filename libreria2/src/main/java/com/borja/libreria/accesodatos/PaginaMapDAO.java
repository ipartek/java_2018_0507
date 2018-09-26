package com.borja.libreria.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.borja.libreria.pojo.Pagina;

public class PaginaMapDAO implements CrudAble<Pagina> {
	private TreeMap<Long, Pagina> paginas = new TreeMap<Long, Pagina>();

	@Override
	public List<Pagina> getAll() {
		return new ArrayList<Pagina>(paginas.values());
	}

	@Override
	public Pagina getById(long id) {
		return paginas.get(id);
	}

	@Override
	public boolean insert(Pagina pojo) {
		if(paginas.containsKey(pojo.getId())) {
			return false;
		}
		paginas.put(pojo.getId(), pojo);
		return true;
	}

	@Override
	public boolean update(Pagina pojo) {
		if(!paginas.containsKey(pojo.getId())) {
			return false;
		}
		paginas.put(pojo.getId(), pojo);
		return true;
	}

	@Override
	public boolean delete(long id) {
		if(!paginas.containsKey(id)) {
			return false;
		}
		paginas.remove(id);
		return true;
	}
	
}
