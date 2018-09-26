package com.ipartek.formacion.javaee.libro.logica;

import java.util.List;

import com.ipartek.formacion.javaee.libro.accesodatos.MapDAO;
import com.ipartek.formacion.javaee.libro.pojo.Pagina;
import com.ipartek.formacion.javaee.libro.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Pagina> paginas = new MapDAO<Pagina>(); 
	
	static {
		usuarios.insert(new Usuario(1,"William ","Shakespeare"));
		usuarios.insert(new Usuario(2,"cervantes","saavedra"));
		usuarios.insert(new Usuario(3,"pablo","neruda"));
		usuarios.insert(new Usuario(4,"paulo","cohelo"));
		
		paginas.insert(new Pagina(1,"Erase una vez...","William Shakespeare" ));
	}

	public static boolean validarUsuario(Usuario usuario) {
		for (Usuario u : usuarios.getAll()) {
			if (u.getNombre().equals(usuario.getNombre())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
	
	public static List<Pagina> obtenerPaginas(){
		return paginas.getAll();
	}
	
	public static Pagina obtenerPaginaPorId(long id) {
		return paginas.getById(id);
	}
	
	public static void agregarPagina(Pagina pagina) {
		if (!paginas.insert(pagina)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
	}
}
