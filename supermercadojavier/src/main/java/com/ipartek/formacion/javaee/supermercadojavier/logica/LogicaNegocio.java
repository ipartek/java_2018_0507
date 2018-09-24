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
		
		return "javier@email.com".equalsIgnoreCase(usuario.getEmail()) && "contra".equals(usuario.getPassword());	
	}
	
	public static List<Producto> obtenerProductos() {
		//TODO: Llamar DAO
		ArrayList<Producto> productos = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			productos.add(new Producto(i, "Producto" + i, new BigDecimal(i*10 + "." + i)));
		}
		
		return productos;
	}
}
