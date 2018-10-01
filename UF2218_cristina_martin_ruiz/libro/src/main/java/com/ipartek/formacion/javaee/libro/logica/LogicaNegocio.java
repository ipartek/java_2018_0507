package com.ipartek.formacion.javaee.libro.logica;

import java.util.List;

import com.ipartek.formacion.javaee.libro.accesoadatos.MapDAO;
import com.ipartek.formacion.javaee.libro.pojo.Pagina;
import com.ipartek.formacion.javaee.libro.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Pagina> paginas = new MapDAO<Pagina>();

	static {
		usuarios.insert(new Usuario(1, "William ", "Shakespeare"));
		usuarios.insert(new Usuario(2, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(3, "pablo", "neruda"));
		usuarios.insert(new Usuario(4, "paulo", "cohelo"));
		
		//pagina inicial
		paginas.insert(new Pagina(1, "Erase una veeeez...",  "anonymous"));
		paginas.insert(new Pagina(2, "pagina2",  "anonymous"));
		paginas.insert(new Pagina(3, "pagina3",  "anonymous"));
		
	}
	

	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.getAll()) {
			if (u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}

		return false;
		// return ("javier@email.com".equalsIgnoreCase(usuario.getEmail()) &&
		// "contra".equals(usuario.getPassword())) ||
		// ("admin@email.com".equalsIgnoreCase(usuario.getEmail()) &&
		// "contra".equals(usuario.getPassword()));
	}

	public static List<Pagina> obtenerPaginas() {
		return paginas.getAll();
	}

	public static Pagina obtenerPaginaPorId(long id) {
		return paginas.getById(id);
	}

	public static void agregarPagina(Pagina producto) {
		if (!paginas.insert(producto)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
	}

	public static void modificarPagina(Pagina producto) {
		if (!paginas.update(producto)) {
			throw new LogicaNegocioException("No se ha podido modificar el registro");
		}
	}

	public static void borrarPagina(long id) {
		if (!paginas.delete(id)) {
			throw new LogicaNegocioException("No se ha podido borrar el registro");
		}
	}
}
