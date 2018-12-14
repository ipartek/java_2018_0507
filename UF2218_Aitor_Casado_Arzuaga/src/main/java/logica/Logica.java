package logica;

import java.math.BigDecimal;
import java.util.List;

import accesodatos.MapDAO;

import logica.LogicaException;
import pojo.Producto;
import pojo.Usuario;

public class Logica {
	
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Producto> productos = new MapDAO<Producto>();
	
	static {
		usuarios.insert(new Usuario(1, "William", "Shakespeare"));
		usuarios.insert(new Usuario(2, "Shakespeare", "saavedra"));
		usuarios.insert(new Usuario(2, "pablo", "neruda"));
		usuarios.insert(new Usuario(2, "paulo", "cohelo"));		
	}
	
	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u: usuarios.getAll()) {
			if(u.getEmail().equals(usuario.getEmail())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		
		return false;
	}
	
	public static List<Producto> obtenerProductos() {
		return productos.getAll();
	}
	
	public static Producto obtenerProductoPorId(long id) {
		return productos.getById(id);
	}
	
	public static void agregarProducto(Producto producto) {
		if(!productos.insert(producto)) {
			throw new LogicaException("No se ha podido insertar el registro");
		}
	}

	public static void modificarProducto(Producto producto) {
		if(!productos.update(producto)) {
			throw new LogicaException("No se ha podido modificar el registro");
		}
	}

	public static void borrarProducto(long id) {
		if(!productos.delete(id)) {
			throw new LogicaException("No se ha podido borrar el registro");
		}
	}

}
