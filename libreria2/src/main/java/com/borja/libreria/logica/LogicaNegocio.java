package com.borja.libreria.logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.borja.libreria.pojo.Pagina;
import com.borja.libreria.pojo.Usuario;
import com.borja.libreria.accesodatos.MapDAO;
import com.borja.libreria.logica.LogicaNegocioException;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Pagina> paginas = new MapDAO<Pagina>();

	static {
		usuarios.insert(new Usuario(1, "borja@email.com", "libreria"));
		usuarios.insert(new Usuario(2, "admin@admin.com", "admin"));
		
		for(int i = 1; i <= 100; i++) {
			paginas.insert(new Pagina(i, "pagina<br>pagina<br>", "borja"));
		}
	}
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getEmail().equals(usuario.getEmail())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		
		return false;
		//return ("javier@email.com".equalsIgnoreCase(usuario.getEmail()) && "contra".equals(usuario.getPassword())) ||
		//		("admin@email.com".equalsIgnoreCase(usuario.getEmail()) && "contra".equals(usuario.getPassword()));	
	}
	
	public static List<Pagina> obtenerPagina() {
		return paginas.getAll();
	}
	
	public static Pagina obtenerPaginaPorId(long id) {
		return paginas.getById(id);
	}
	
	public static void agregarPagina(Pagina pagina) {
		
		if(!paginas.insert(pagina)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
	}

	public static void modificarPagina(Pagina pagina) {
		if(!paginas.update(pagina)) {
			throw new LogicaNegocioException("No se ha podido modificar el registro");
		}
	}

	public static void borrarPagina(long id) {
		if(!paginas.delete(id)) {
			throw new LogicaNegocioException("No se ha podido borrar el registro");
		}
	}
}
