package com.ipartek.formacion.examen.logica;

import java.util.List;

import com.ipartek.formacion.examen.accesodatos.MapDAO;
import com.ipartek.formacion.examen.pojo.Libro;
import com.ipartek.formacion.examen.pojo.Usuario;


public class LogicaLibro {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Libro> paginas = new MapDAO<Libro>();

	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(3, "pablo", "neruda"));
		usuarios.insert(new Usuario(4, "paulo", "cohelo"));

		paginas.insert(new Libro(1, "Erase una vez"));

	}

	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.getAll()) {
			if (u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;

	}

	public static Libro obtenerPagina(long id) {
		return paginas.getById(id);
	}

	public static void agregarPagina(Libro pagina) {
		if (!paginas.insert(pagina)) { 
			//throw new LogicaLibroException("No se ha podido insertar la pagina");
		}
	}
}
