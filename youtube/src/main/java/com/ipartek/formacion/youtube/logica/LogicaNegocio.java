package com.ipartek.formacion.youtube.logica;

import java.util.ArrayList;

import com.ipartek.formacion.youtube.accessoadatos.UsuarioMySqlDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

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