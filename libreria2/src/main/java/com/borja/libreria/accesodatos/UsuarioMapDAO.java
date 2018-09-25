package com.borja.libreria.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.borja.libreria.pojo.Usuario;

public class UsuarioMapDAO implements CrudAble<Usuario> {
	private TreeMap<Long, Usuario> usuarios = new TreeMap<Long, Usuario>();

	@Override
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(usuarios.values());
	}

	@Override
	public Usuario getById(long id) {
		return usuarios.get(id);
	}

	@Override
	public boolean insert(Usuario pojo) {
		if(usuarios.containsKey(pojo.getId())) {
			return false;
		}
		usuarios.put(pojo.getId(), pojo);
		return true;
	}

	@Override
	public boolean update(Usuario pojo) {
		if(!usuarios.containsKey(pojo.getId())) {
			return false;
		}
		usuarios.put(pojo.getId(), pojo);
		return true;
	}

	@Override
	public boolean delete(long id) {
		if(!usuarios.containsKey(id)) {
			return false;
		}
		usuarios.remove(id);
		return true;
	}
	
	

}
