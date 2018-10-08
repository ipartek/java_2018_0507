package com.ipartek.pabloDAO.paginaExamen.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.pabloDAO.paginaExamen.modelos.Usuario;

public class UsuarioMapDAO implements CrudAble<Usuario> {

	
	private static final UsuarioMapDAO dao = new UsuarioMapDAO();
	
	private UsuarioMapDAO() {}
	
	public static UsuarioMapDAO getInstance() {return dao;}
	
	static {
		dao.insert(new Usuario(1, "scobby", "galletas"));
	}
	
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
	public void insert(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
/*	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.getAll()) {
			if (u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}

		return false;
	}*/

}
