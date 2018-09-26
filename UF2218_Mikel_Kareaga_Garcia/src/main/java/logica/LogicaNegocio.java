package logica;
import java.util.List;

import accesoDatos.MapDAO;
import pojo.Libro;
import pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Libro> libros = new MapDAO<Libro>();
	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(3, "cervantes", "saavedra"));
		usuarios.insert(new Usuario(4, "pablo", "neruda"));
		usuarios.insert(new Usuario(5, "paulo", "cohelo"));
	}
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getEmail().equals(usuario.getEmail())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
	
	public static List<Libro> obtenerLibros() {
		return libros.getAll();
	}
	
	public static Libro obtenerLibroPorId(long id) {
		return libros.getById(id);
	}
	
	public static void agregarLibro(Libro libro) {
		if(!libros.insert(libro)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
	}

	public static void modificarProducto(Libro libro) {
		if(!libros.update(libro)) {
			throw new LogicaNegocioException("No se ha podido modificar el registro");
		}
	}

	public static void borrarProducto(long id) {
		if(!libros.delete(id)) {
			throw new LogicaNegocioException("No se ha podido borrar el registro");
		}
	}
}