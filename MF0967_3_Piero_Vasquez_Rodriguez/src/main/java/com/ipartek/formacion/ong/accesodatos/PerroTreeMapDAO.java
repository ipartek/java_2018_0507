package com.ipartek.formacion.ong.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import com.ipartek.formacion.ong.pojo.Chip;

public class PerroTreeMapDAO implements CrudAble<Chip> {

	private TreeMap<Long, Chip> perros = new TreeMap<Long, Chip>();
	
	public List<Chip> getAll() {
		return new ArrayList<Chip>(perros.values());
	}

	@Override
	public Chip getById(long id) {
		return perros.get(id);
	}

	@Override
	public boolean insert(Chip objeto) {
		if (perros.containsKey(objeto.getId())) {
			return false;
		}
		perros.put(objeto.getId(), objeto);
		return true;
	}

	
}