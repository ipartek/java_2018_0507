package com.ipartek.formacion.supermercado.logica;

import java.math.BigDecimal;

import com.ipartek.formacion.supermercado.logica.LogicaNegocioException;
import com.ipartek.formacion.supermercado.accesodatos.MapDAO;
import com.ipartek.formacion.supermercado.pojo.Producto;
import com.ipartek.formacion.supermercado.pojo.Usuario;

public class LogicaNegocio {
	private static MapDAO<Producto> productos = new MapDAO<Producto>();
	private static MapDAO<Usuario> usuarios = new MapDAO<Usuario>();
	
	static {
		//La diferencia entre usuario y administrador ç
		//se encuentra en el filtro
		usuarios.insert(new Usuario(1, "batman@email.com", "contra"));
		usuarios.insert(new Usuario(2, "admin@email.com", "contra"));
		
		for(int i = 1; i <= 100; i++) {
			productos.insert(new Producto(i, "Producto" + i, new BigDecimal(i*10 + "." + i)));
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
	
	public static Object obtenerProductos() {
		return productos.getAll();
	}

	public static Producto obtenerProductoPorId(long id) {
		return productos.getById(id);
	}

	public static void agregarProducto(Producto producto) {
		if(!productos.insert(producto)) {
			throw new LogicaNegocioException("No se ha podido insertar el registro");
		}
		
	}
	public static void modificarProducto(Producto producto) {
		if(!productos.update(producto)) {
			throw new LogicaNegocioException("No se ha podido modificar el registro");
		}
	}

	public static void borrarProducto(long id) {
		if(!productos.delete(id)) {
			throw new LogicaNegocioException("No se ha podido borrar el registro");
		}
	}

}
