package com.ipartek.formacion.javaee.supermercado.logica;

import java.math.BigDecimal;
import java.util.List;

import com.ipartek.formacion.javaee.supermercado.accesodatos.MapDAO;
import com.ipartek.formacion.javaee.supermercado.pojo.Producto;
import com.ipartek.formacion.javaee.supermercado.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	private static MapDAO<Producto> productos = new MapDAO<Producto>();
	
	static {
		usuarios.insert(new Usuario(1,"antxon@gmail.com","123"));
		usuarios.insert(new Usuario(2,"admin@gmail.com","456"));
		
		for (int i = 0; i <= 10; i++) {
			productos.insert(new Producto(i, "Producto" + i, new BigDecimal(i*10 + "." + i)));
		}
	}

	public static boolean validarUsuario(Usuario usuario) {
		for(Usuario u : usuarios.getAll()) {
			if (u.getEmail().equals(usuario.getEmail())) {
				return u.getPassword().equals(usuario.getPassword());
			}
		}
		return false;
	}
	
	public static List<Producto> obtenerProductos(){
		return productos.getAll();
	}
	
	public static Producto obtenerProductoPorId(long id){
		return productos.getById(id);
	}
	
	public static void agregarProducto(Producto producto) {
		if(!productos.insert(producto)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
	}
	public static void modificarProducto(Producto producto){
		if(!productos.update(producto)) {
			throw new LogicaNegocioException("No se ha podido modificar el registro");
		}
	}
	public static void borrarProducto(Long id) {
		if(!productos.delete(id)) {
			throw new LogicaNegocioException("No se ha podido borrar el registro");
		}
	}

}
