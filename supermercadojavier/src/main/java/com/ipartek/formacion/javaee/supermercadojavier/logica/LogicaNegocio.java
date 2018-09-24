package com.ipartek.formacion.javaee.supermercadojavier.logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.javaee.supermercadojavier.pojo.Producto;
import com.ipartek.formacion.javaee.supermercadojavier.pojo.Usuario;

public class LogicaNegocio {

	public static boolean validarUsuario(Usuario usuario) {
		//TODO: Llamar DAO
		//TODO: Consultar por email
		//TODO: Comparar Password
		

		return ("javier@email.com".equalsIgnoreCase(usuario.getEmail()) && "contra".equals(usuario.getPassword())) ||
				("admin@email.com".equalsIgnoreCase(usuario.getEmail()) && "contra".equals(usuario.getPassword()));	
	}
	
	public static List<Producto> obtenerProductos() {
		//TODO: Llamar DAO
		ArrayList<Producto> productos = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			productos.add(new Producto(i, "Producto" + i, new BigDecimal(i*10 + "." + i)));
		}
		
		return productos;
	}
	
	public static Producto obtenerProductoPorId(long id) {
		//TODO: Llamar a DAO
		return new Producto(id, "Producto" + id, new BigDecimal(id*10 + "." + id));
	}
	
	public static void agregarProducto(Producto producto) {
		//TODO: Llamar a DAO
		System.out.println("AÑADIR PRODUCTO " + producto);
		if(producto.getId() == 5) {
			throw new RuntimeException("No se ha podido añadir el producto 5");
		}
	}

	public static void modificarProducto(Producto producto) {
		//TODO: Llamar a DAO
		System.out.println("MODIFICAR PRODUCTO " + producto);
		if(producto.getId() == 5) {
			throw new RuntimeException("No se ha podido modificar el producto 5");
		}
	}

	public static void borrarProducto(long id) {
		//TODO: Llamar a DAO
		System.out.println("BORRAR PRODUCTO " + id);
		if(id == 5) {
			throw new RuntimeException("No se ha podido borrar el producto 5");
		}

	}
}
