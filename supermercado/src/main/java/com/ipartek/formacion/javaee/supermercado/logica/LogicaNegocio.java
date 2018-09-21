package com.ipartek.formacion.javaee.supermercado.logica;

import com.ipartek.formacion.javaee.supermercado.pojo.Usuario;

public class LogicaNegocio {

	public static boolean validarUsuario(Usuario usuario) {
		//TODO: Llamar DAO
		//TODO: Consultar por email
		//TODO: Comparar Password
		
		return "antxon".equalsIgnoreCase(usuario.getEmail()) && "123".equals(usuario.getPassword());
	}

}
