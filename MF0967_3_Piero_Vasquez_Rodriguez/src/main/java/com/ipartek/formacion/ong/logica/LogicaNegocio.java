package com.ipartek.formacion.ong.logica;

import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.ong.accesodatos.MapDAO;
import com.ipartek.formacion.ong.pojo.Chip;
import com.ipartek.formacion.ong.pojo.Usuario;

public class LogicaNegocio {

	private static TreeMap<Integer, Usuario> usuarios = new TreeMap<>();
	private static MapDAO<Chip> perros = new MapDAO<Chip>(); 
	
	static {
		usuarios.put(new Integer(1), new Usuario("scobby","galletas"));	
		
		for(int i = 1; i <= 6; i++) {
			perros.insert(new Chip(i, "Roger", i, "Sabueso", i, "Si",i,i, i));
		}
	}
	
	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.values()) {
			if (u.getNick().equals(usuario.getNick())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
	
	public static List<Chip> obtenerPerros(){
		return perros.getAll();
	}
	
	public static Chip obtenerPerroPorID(long id) {
		return perros.getById(id);
	}
	
	public static void AgregarPerro(Chip perro) {
		if (!perros.insert(perro)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
	}
	
}
