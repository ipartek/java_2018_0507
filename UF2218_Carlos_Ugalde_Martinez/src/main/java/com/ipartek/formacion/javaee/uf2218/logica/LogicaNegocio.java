package com.ipartek.formacion.javaee.uf2218.logica;

import com.ipartek.formacion.javaee.uf2218.accesodatos.MapDAO;
import com.ipartek.formacion.javaee.uf2218.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	
	static {
		//La diferencia entre usuario y administrador ç
		//se encuentra en el filtro
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(3, "pablo", "neruda"));
		usuarios.insert(new Usuario(4, "paulo", "cohelo"));
		usuarios.insert(new Usuario(5, "a", "a"));
	}
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;	
	}
}
