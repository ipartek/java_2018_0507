package com.ipartek.modelo;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {

	List<Usuario> usuarios = new ArrayList<Usuario>();
	private static UsuarioDAO INSTANCE;

	private UsuarioDAO() {

	}

	public static synchronized UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
			Usuario user = new Usuario("scobby", "galletas");
			INSTANCE.usuarios.add(user);
		}

		return INSTANCE;
	}

	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarios;
	}

	public Usuario getById(long id) {
		// TODO Auto-generated method stub
		Usuario user = null;
		for (Usuario u : usuarios)
			if (u.getId() == id) {
				return u;

			}
		return user;
	}

	public boolean insert(Usuario pojo) {
		// TODO Auto-generated method stub
		if (pojo != null) {
			usuarios.add(pojo);
			return true;
		}
		return false;
	}

	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		if (pojo != null)
			for (int i = 0; i < usuarios.size(); i++) {
				if (usuarios.get(i).getId() == pojo.getId()) {
					usuarios.get(i).setEmail(pojo.getEmail());
					usuarios.get(i).setId(pojo.getId());
					usuarios.get(i).setPassword(pojo.getPassword());
				}
			}
		return false;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getId() == id) {
				usuarios.remove(i);
				return true;
			}
		}
		return false;
	}

}
