package com.iparte.formacion.logica;

import com.ipartek.formacion.pojo.Usuario;

public class LogicaNegocio {

	public static boolean validarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		//llamar dao
		//consultar por email
		//compara password
		if("javier@email".equalsIgnoreCase(usuario.getUsuario()) && "contra".equals(usuario.getPassword())) {
		return true;	
			}
		return false;
	}

}
