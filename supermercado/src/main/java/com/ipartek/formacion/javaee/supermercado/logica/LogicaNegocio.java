package com.ipartek.formacion.javaee.supermercado.logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.javaee.supermercado.pojo.Producto;
import com.ipartek.formacion.javaee.supermercado.pojo.Usuario;

public class LogicaNegocio {

	public static boolean validarUsuario(Usuario usuario) {
		//TODO: Llamar DAO
		//TODO: Consultar por email
		//TODO: Comparar Password
		
		return "antxon".equalsIgnoreCase(usuario.getEmail()) && "123".equals(usuario.getPassword());
	}
	
	public static List<Producto> obtenerProductos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		for (int i = 0; i <= 10; i++) {
			productos.add(new Producto(i, "Producto " + i, new BigDecimal(i + "." + i)));
		}
		return productos;
	}

}
