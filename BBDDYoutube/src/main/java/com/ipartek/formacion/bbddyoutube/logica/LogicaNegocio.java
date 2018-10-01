package com.ipartek.formacion.bbddyoutube.logica;

import com.ipartek.formacion.bbddyoutube.accesodatos.MapDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
}
