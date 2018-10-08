package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.logica;

import java.util.ArrayList;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Perro;
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
	
	public static boolean validarPerro(Perro perro) {
		if (perro.getNombre() == "") {
			perro.setErrorNombre("Hay que escribir un nombre para el perro");
			perro.setCorrecto(false);
			return false;
		}
		
		if (perro.getEdad() == 0) {
			perro.setErrorEdad("Hay que escribir una edad para el perro");
			perro.setCorrecto(false);
			return false;
		}
		if (perro.getRaza() == "") {
			perro.setErrorEdad("Hay que escribir una raza para el perro");
			perro.setCorrecto(false);
			return false;
		}
		if (perro.getPeso() == 0) {
			perro.setErrorEdad("Hay que escribir un peso para el perro");
			perro.setCorrecto(false);
			return false;
		}
		if(perro.getChip().getChip() == "") {
			perro.getChip().setErrorChip("Hay que escribir un nombre de chip para el perro");
			perro.setCorrecto(false);
		}
		if (perro.getChip().getLatitud() == "") {
			perro.getChip().setErrorLatitud("Hay que escribir una latitud para el perro");
			perro.setCorrecto(false);
		}
		if (perro.getChip().getLongitud() == "") {
			perro.getChip().setErrorLongitud("Hay que escribir una longitud para el perro");
			perro.setCorrecto(false);
		}
		
		return true;
	}
}
