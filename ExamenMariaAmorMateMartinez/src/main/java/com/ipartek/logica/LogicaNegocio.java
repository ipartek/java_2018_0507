package com.ipartek.logica;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.PerroDAO;
import com.ipartek.modelo.UsuarioDAO;
import com.ipartek.pojo.Perro;
import com.ipartek.pojo.Usuario;

public class LogicaNegocio {

	// USUARIOS
	public boolean validarUsuario(Usuario usuario) {

		UsuarioDAO userDAO = UsuarioDAO.getInstance();

		List<Usuario> usuarios = userDAO.getAll();

		for (int i = 0; i < usuarios.size(); i++) {

			if (usuario.getEmail().equals(usuarios.get(i).getEmail())
					&& usuario.getPassword().equals(usuarios.get(i).getPassword())) {

				return true;
			}
		}
		return false;

	}

	public boolean insertarUsuario(Usuario usuario) {

		UsuarioDAO userDAO = UsuarioDAO.getInstance();

		// se valida el email y la contrase�a tb y si esta bien lo inserta (que sea
		// email y pass mayor que 6 y menor q 8)

		if (usuario.getEmail().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]+)$")
				&& (usuario.getPassword().trim().length() < 8 && usuario.getPassword().trim().length() > 6)) {

			// para que tengan un id autoincremental
			usuario.setId(userDAO.getAll().size());

			// si lo consigue insertar devueltve true
			return userDAO.insert(usuario);

		} else {

			// si no devuelve false
			return false;

		}

	}

	public List<Usuario> obtenerTodosUsuarios() {

		UsuarioDAO userDAO = UsuarioDAO.getInstance();

		return userDAO.getAll();

	}

	public boolean update(Usuario usuario) {

		UsuarioDAO userDAO = UsuarioDAO.getInstance();
		boolean resultado = userDAO.update(usuario);
		return resultado;

	}

	public boolean delete(Long id) {

		UsuarioDAO userDAO = UsuarioDAO.getInstance();
		boolean resultado = userDAO.delete(id);
		return resultado;
	}

	public Usuario obtenerUsuarioId(Long id) {

		UsuarioDAO userDAO = UsuarioDAO.getInstance();
		Usuario user = userDAO.getById(id);
		return user;
	}

	
	
	
	
	// PRODUCTOS

	public boolean insertarProducto(Perro producto) {

		PerroDAO prodDAO = PerroDAO.getInstance();

		// para que tengan un id autoincremental
		producto.setId((long) prodDAO.getAll().size());

		// si lo consigue insertar devueltve true
		return prodDAO.insert(producto);

	}

	public List<Perro> obtenerTodosProductos() {

		PerroDAO prodDAO = PerroDAO.getInstance();

		return prodDAO.getAll();

	}

	public boolean updateProd(Perro perro) {

		PerroDAO prodDAO = PerroDAO.getInstance();
		boolean resultado = prodDAO.update(perro);
		return resultado;

	}

	public boolean deleteProd(Long id) {

		PerroDAO prodDAO = PerroDAO.getInstance();
		boolean resultado = prodDAO.delete(id);
		return resultado;
	}

	public Perro obtenerProductoId(Long id) {

		PerroDAO prodDAO = PerroDAO.getInstance();
		Perro prod = prodDAO.getById(id);
		return prod;
	}

}
