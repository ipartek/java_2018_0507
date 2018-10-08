package com.ipartek.examen.controladores;

import javax.servlet.annotation.WebServlet;

@WebServlet("/LogicaNegocio")
public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();

	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(3, "pablo", "neruda"));
		usuarios.insert(new Usuario(4, "paulo", "cohelo"));
	}

	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.getAll()) {
			if (u.getUser().equals(usuario.getUser())) {
				return u.getPass().equals(usuario.getPass());
			}
		}
		return false;
	}
}
