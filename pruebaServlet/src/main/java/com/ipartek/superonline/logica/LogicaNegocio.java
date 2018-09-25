package com.ipartek.superonline.logica;


import java.util.ArrayList;
import java.util.List;

import com.ipartek.superonline.pojo.Producto;
import com.ipartek.superonline.pojo.Usuario;
import com.ipartek.superonline.modelo.ProductoDAO;
import com.ipartek.superonline.modelo.UsuarioDAO;



public class LogicaNegocio {
	
	public static boolean validarUsuario(Usuario usuario) {
		
		//Llamar DAO
		//Consultar por email
		// Comparar Password
		
		UsuarioDAO userdao = UsuarioDAO.getInstance();
		List<Usuario> usuarios = userdao.getAll();
		for(int i = 0 ; i< usuarios.size() ; i++) {
			
			if(usuario.getNombre().equals(usuarios.get(i).getNombre()) && usuario.getContrasena().equals(usuarios.get(i).getContrasena())) {
				
				return true;
			}
			
		}
		return false;
	}
	
	public static List<Producto> obtenerProductos() {
		
		ProductoDAO proddao = ProductoDAO.getInstance();
		List<Producto> productos = proddao.getAll();
		return productos;
	}
	
	public static Producto obtenerProductoPorId(long id) {
	
		ProductoDAO proddaoid = ProductoDAO.getInstance();
		Producto producto = proddaoid.getById(id);
		return producto;
		
	}
	
	public static void agregarProducto(Producto producto) {
		
		ProductoDAO proddao = ProductoDAO.getInstance();
		proddao.insert(producto);
		
	}

	public static void modificarProducto(Producto producto) {
		ProductoDAO proddao = ProductoDAO.getInstance();
		proddao.update(producto);
		
	}

	public static void borrarProducto(long id) {
		ProductoDAO proddao = ProductoDAO.getInstance();
		proddao.delete(id);
	}

}
