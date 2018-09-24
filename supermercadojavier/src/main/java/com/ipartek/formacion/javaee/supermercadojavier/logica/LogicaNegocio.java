package com.ipartek.formacion.javaee.supermercadojavier.logica;

import com.ipartek.formacion.javaee.supermercadojavier.pojo.Usuario;

public class LogicaNegocio {

	public static boolean validarUsuario(Usuario usuario) {
		//TODO: Llamar DAO
		//TODO: Consultar por email
		//TODO: Comparar Password
		
		return "javier@email.com".equalsIgnoreCase(usuario.getEmail()) && "contra".equals(usuario.getPassword());
			
	}
}
