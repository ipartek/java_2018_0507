package com.ipartek.formacion.bbddyoutube.logica;

import java.util.ArrayList;

import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

public class LogicaNegocio {
	private static ArrayList<Usuario> usuarios = (ArrayList<Usuario>) UsuarioMySqlDAO.getInstance().getAll();
			
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios) {
			if(u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
}
