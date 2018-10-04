package com.ipartek.formacion.ejemplos.crud.accesodatos;

import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.ejemplos.crud.modelos.Usuario;

public class UsuarioTreeMapDAO implements CrudAble<Usuario> {

	//PRINCIPIO SINGLETON
	private static final UsuarioTreeMapDAO dao = new UsuarioTreeMapDAO();
	
	private UsuarioTreeMapDAO() {}
	
	public static UsuarioTreeMapDAO getInstance() { return dao; }
	//FIN SINGLETON
	
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	
	@Override
	public List<Usuario> getAll() {
		return (List<Usuario>)usuarios.values();
	}

	@Override
	public Usuario getById(long id) {
		return usuarios.get(id);
	}

	@Override
	public void insert(Usuario usuario) {
		if(usuarios.containsKey(usuario.getId())) {
			throw new AccesoDatos("Clave duplicada");
		}
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void update(Usuario usuario) {
		if(!usuarios.containsKey(usuario.getId())) {
			throw new AccesoDatos("Id no existente");
		}
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void delete(long id) {
		if(!usuarios.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		usuarios.remove(id);
	}

}
