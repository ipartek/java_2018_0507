package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.logica;

import java.util.ArrayList;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Usuario;

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
